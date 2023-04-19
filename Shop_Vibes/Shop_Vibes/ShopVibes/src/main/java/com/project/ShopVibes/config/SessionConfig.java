package com.project.ShopVibes.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@EnableHazelcastHttpSession
public class SessionConfig {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName("my-hazelcast-instance");
        NetworkConfig network = config.getNetworkConfig();
        network.setPort(5701);
        network.setPortAutoIncrement(true);
        return Hazelcast.newHazelcastInstance(config);
    }
}