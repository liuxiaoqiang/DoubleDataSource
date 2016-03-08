package com.ebaolife.conf;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.ebaolife.model.DataSource;

@Configuration
public class GlobalDataConfiguration {
	@Bean(name="primaryDataSource")  
    @Primary  
    @ConfigurationProperties(prefix="datasource.primary")  
    public DataSource primaryDataSource() {
		return new DataSource();  
    }  
      
    @Bean(name="secondaryDataSource")  
    @ConfigurationProperties(prefix="datasource.secondary")  
    public DataSource secondaryDataSource() {
		return new DataSource();  
    }  
}
