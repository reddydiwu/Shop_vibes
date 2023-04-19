package com.project.ShopVibes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.hazelcast.config.NetworkConfig;

@Configuration
public class MyConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

	public void setInstanceName(String string) {
		// TODO Auto-generated method stub
		
	}

	public NetworkConfig getNetworkConfig() {
		// TODO Auto-generated method stub
		return null;
	}
   
}