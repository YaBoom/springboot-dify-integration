package com.zhuyt.spring.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @className: StudyApplication
 * @Description: TODO
 * @author: zhuyt
 * @date: 25/10/21 10:58
 */
@SpringBootApplication
public class StudyApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudyApplication.class, args);

    }

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
