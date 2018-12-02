package com.netcracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@EnableAutoConfiguration
@SpringBootApplication
public class PhoneShopServer {

    public static void main(String [] args){

        ConfigurableApplicationContext context = SpringApplication.run(PhoneShopServer.class, args);
    }
}
