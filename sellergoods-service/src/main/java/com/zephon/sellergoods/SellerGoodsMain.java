package com.zephon.sellergoods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.swing.*;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.sellergoods
 * @date 2020/6/24 下午6:58
 * @Copyright ©
 */
@SpringBootApplication
@EnableEurekaClient
public class SellerGoodsMain {
    public static void main(String[] args) {
        SpringApplication.run(SellerGoodsMain.class);
    }
}
