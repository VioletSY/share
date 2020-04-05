package com.songyan.share.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/** 
* @author songyan
* @date 2020年3月19日 
* @desc: 
*/
@Configuration 
@MapperScan(basePackages = "com.songyan.share.dao")
public class DBConfig {
	
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(initMethod = "init", destroyMethod = "close", name = "dataSource")
    public DruidDataSource dataSource() {
        return new DruidDataSource();
    }
}