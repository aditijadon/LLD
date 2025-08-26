package com.example.design.licious.config;

import com.example.interview.service.impl.Cache;
import com.example.interview.service.ICache;
import com.example.interview.model.Node;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class BeanConfiguration {
    @Bean
    public ICache cache(){
        return new Cache(3,new HashMap<>(), new Node(0,0), new Node(0,0));
    }
}
