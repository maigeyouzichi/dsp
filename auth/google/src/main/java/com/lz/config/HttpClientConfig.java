package com.lz.config;

import java.nio.charset.StandardCharsets;
import javax.net.ssl.SSLContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
@SuppressWarnings("all")
public class HttpClientConfig {

    @Bean
    public CloseableHttpClient httpClient() throws Exception {
        SSLContext sslContext = SSLContexts.custom()
                .loadTrustMaterial((chain, authType) -> true)
                .build();

        SSLConnectionSocketFactory sslConnectionSocketFactory =
                new SSLConnectionSocketFactory(sslContext.getSocketFactory(),
                        NoopHostnameVerifier.INSTANCE);

        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder
                .<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslConnectionSocketFactory)
                .build();

        PoolingHttpClientConnectionManager connectionManager =
                new PoolingHttpClientConnectionManager(socketFactoryRegistry);

        // 整个连接池最大连接数
        connectionManager.setMaxTotal(100);
        // 每路由最大连接数，默认值是2
        connectionManager.setDefaultMaxPerRoute(5);

        final RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(3000) // 从连接池获取连接的timeout
                .setConnectTimeout(6000) // 客户端和服务器建立连接的timeout
                .setSocketTimeout(18000) // 客户端从服务器读取数据的timeout
                .build();

        return HttpClients.custom()
                .setSSLContext(sslContext) // 事实上生效的应该只有connectionManageer
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE) // 事实上生效的应该只有connectionManageer
                .setSSLSocketFactory(sslConnectionSocketFactory) // 事实上生效的应该只有connectionManageer
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .build();
    }


    @Bean("restTemplate")
    public RestTemplate restTemplate(CloseableHttpClient httpclient){
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setHttpClient(httpclient);
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

}
