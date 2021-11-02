package com.lz;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DailyTestMpGeneratorApplicationTests {

    @Test
    public void testGenerator(){
        //构建代码自动生成器对象
        AutoGenerator mpg = new AutoGenerator();
        // 配置策略
        // 1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("lihao");
        //是否打开资源管理器
        gc.setOpen(false);
        // 是否覆盖
        gc.setFileOverride(true);
        // 去Service的I前缀
        gc.setServiceName("%sService");
        gc.setIdType(IdType.INPUT);
        gc.setDateType(DateType.TIME_PACK);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);
        //2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://{url}:3306/yzs_driver_safety?useSSL=false&useUnicode=true&characterEncoding = utf-8&serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("{username}");
        dsc.setPassword("{password}");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);
        //3、包的配置
        PackageConfig pc = new PackageConfig();
        //设置父级包名
        pc.setParent("com.lz");
        //设置下级模块名
        pc.setModuleName("temp");
        //设置再下级模块名下的包名
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);
        //4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要映射的表名
        strategy.setInclude("user_comp_rel","user_role_rel","role","role_perm_rel","permission");
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 自动lombok；
        strategy.setEntityLombokModel(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}