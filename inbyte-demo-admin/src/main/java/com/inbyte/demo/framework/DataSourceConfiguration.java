package com.inbyte.demo.framework;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.github.pagehelper.PageInterceptor;
import com.inbyte.commons.util.convert.JsonArrayTypeHandler;
import com.inbyte.commons.util.convert.JsonObjectTypeHandler;
import com.inbyte.commons.util.convert.ListTypeHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @module 主数据源配置
 * @author chenjw
 * @date: 2020年7月6日
 */
@Configuration
@MapperScan(basePackages = "com.inbyte.demo.web.dao",
            sqlSessionFactoryRef = "mainSqlSessionFactory")
public class DataSourceConfiguration {

    @Autowired
    private DataSource mainDataSource;

    @Bean(name = "mainTransactionManager")
    @Primary
    public DataSourceTransactionManager mainTransactionManager() {
        return new DataSourceTransactionManager(mainDataSource);
    }

    @Bean(name = "mainSqlSessionFactory")
    @Primary
    public MybatisSqlSessionFactoryBean mainSqlSessionFactory() {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(mainDataSource);

        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig()
                // 全局逻辑删除的实体字段名(since 3.3.0,配置后可以忽略配置字段@TableLogic)
                .setLogicDeleteField("deleted")
                // 逻辑已删除值(默认为 1)
                .setLogicDeleteValue("1")
                // 逻辑未删除值(默认为 0)
                .setLogicNotDeleteValue("0");

        GlobalConfig globalConfig = new GlobalConfig()
                .setDbConfig(dbConfig);
        sessionFactory.setGlobalConfig(globalConfig);

        // 分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "false");
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("param", "pageNum=start;pageSize=limit");
        pageInterceptor.setProperties(properties);
        sessionFactory.setPlugins(pageInterceptor);

        sessionFactory.setTypeHandlers(new JsonObjectTypeHandler(), new JsonArrayTypeHandler(), new ListTypeHandler());

        MybatisConfiguration mybatisConfiguration = new MybatisConfiguration();
        mybatisConfiguration.setMapUnderscoreToCamelCase(false);
        sessionFactory.setConfiguration(mybatisConfiguration);

        return sessionFactory;
    }

}
