package br.com.podce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Victor Alexsander
 */
@SpringBootApplication
@EnableDiscoveryClient
public class  AdmApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdmApplication.class, args);
    }
}