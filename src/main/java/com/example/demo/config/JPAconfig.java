package com.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by 10742 on 2018/1/1.
 */
@Configuration
@EnableJpaRepositories("com.example.demo.service")
@EntityScan("com.example.demo.entity")
public class JPAconfig {
}
