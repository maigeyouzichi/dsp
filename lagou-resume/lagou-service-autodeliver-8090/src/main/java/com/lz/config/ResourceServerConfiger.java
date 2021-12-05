package com.lz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@SuppressWarnings("all")
@Configuration
@EnableResourceServer // 开启资源服务器功能
@EnableWebSecurity // 开启web访问安全
public class ResourceServerConfiger extends ResourceServerConfigurerAdapter {

    private String sign_key = "lagou123"; // jwt签名密钥

    /**
     * 该⽅法⽤于定义资源服务器向远程认证服务器发起请求，进⾏token校验等事宜
     *
     * @param resources
     * @throws Exception
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        /*// 设置当前资源服务的资源id
        resources.resourceId("autodeliver");
        // 定义token服务对象（token校验就应该靠token服务对象）
        RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
        // 校验端点/接⼝设置 (集群的如何处理?)
        remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9999/oauth/check_token");
        // 携带客户端id和客户端安全码
        remoteTokenServices.setClientId("client_lagou");
        remoteTokenServices.setClientSecret("abcxyz");
        // 别忘了这⼀步
        resources.tokenServices(remoteTokenServices);*/

        //jwt令牌改造
        resources
                //设置资源id
                .resourceId("autodeliver")
                .tokenStore(tokenStore())
                //无状态设置
                .stateless(true);
    }

    /**
     * 该⽅法⽤于创建tokenStore对象（令牌存储对象）
     * token以什么形式存储
     */
    private TokenStore tokenStore() {
        //return new InMemoryTokenStore();
        // 使⽤jwt令牌
        return new JwtTokenStore(jwtAccessTokenConverter());
    }


    /**
     * 返回jwt令牌转换器（帮助我们⽣成jwt令牌的）
     * 在这⾥，我们可以把签名密钥传递进去给转换器对象
     * @return
     */
    private JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey(sign_key); // 签名密钥
        jwtAccessTokenConverter.setVerifier(new MacSigner(sign_key)); // 验证时使⽤的密钥，和签名密钥保持⼀致
        return jwtAccessTokenConverter;
    }

    /**
     * 场景：⼀个服务中可能有很多资源（API接⼝）
     * 某⼀些API接⼝，需要先认证，才能访问
     * 某⼀些API接⼝，压根就不需要认证，本来就是对外开放的接⼝
     * 我们就需要对不同特点的接⼝区分对待（在当前configure⽅法中完成），设置是否需要经过认证
     * <p>
     * 思考：当我们第⼀次登陆之后，认证服务器颁发token并将其存储在认证服务器中，后期我们
     * 访问资源服务器时会携带token，资源服务器会请求认证服务器验证token有效性，如果资源
     * 服务器有很多，那么认证服务器压⼒会很⼤.......
     * 另外，资源服务器向认证服务器check_token，获取的也是⽤户信息UserInfo，能否把⽤户信
     * 息存储到令牌中，让客户端⼀直持有这个令牌，令牌的验证也在资源服务器进⾏，这样避免
     * 和认证服务器频繁的交互......
     * 我们可以考虑使⽤ JWT 进⾏改造，使⽤JWT机制之后资源服务器不需要访问认证服务器......
     * 3.3.4 JWT改造统⼀认证授权中⼼的令牌存储机制
     * JWT令牌介绍
     * 通过上边的测试我们发现，当资源服务和授权服务不在⼀起时资源服务使⽤RemoteTokenServices 远
     * 程请求授权 服务验证token，如果访问量较⼤将会影响系统的性能。
     * 解决上边问题： 令牌采⽤JWT格式即可解决上边的问题，⽤户认证通过会得到⼀个JWT令牌，JWT令牌
     * 中已经包括了⽤户相关的信 息，客户端只需要携带JWT访问资源服务，资源服务根据事先约定的算法⾃
     * ⾏完成令牌校验，⽆需每次都请求认证 服务完成授权。
     * 1）什么是JWT？
     * JSON Web Token（JWT）是⼀个开放的⾏业标准（RFC 7519），它定义了⼀种简介的、⾃包含的协议
     * 格式，⽤于 在通信双⽅传递json对象，传递的信息经过数字签名可以被验证和信任。JWT可以使⽤
     * HMAC算法或使⽤RSA的公 钥/私钥对来签名，防⽌被篡改。
     * 2）JWT令牌结构
     * JWT令牌由三部分组成，每部分中间使⽤点（.）分隔，⽐如：xxxxx.yyyyy.zzzzz
     * Header
     * 头部包括令牌的类型（即JWT）及使⽤的哈希算法（如HMAC SHA256或RSA），例如
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http // 设置session的创建策略（根据需要创建即可）
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                .antMatchers("/auto-deliver/**").authenticated() //autodeliver为前缀的请求需要认证
                .antMatchers("/demo/**").authenticated() // demo为前缀的请求需要认证
                .anyRequest().permitAll(); // 其他请求不认证
    }
}