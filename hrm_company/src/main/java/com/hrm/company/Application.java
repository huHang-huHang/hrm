package com.hrm.company;

import com.hrm.common.utils.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.hrm")
@EnableTransactionManagement(proxyTargetClass = true)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
