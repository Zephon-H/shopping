package com.zephon.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.manager
 * @date 2020/6/24 下午7:09
 * @Copyright ©
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ManagerMain {
    public static void main(String[] args) {
        SpringApplication.run(ManagerMain.class,args);
    }
}
