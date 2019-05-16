package com.zzc.paramtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ParamTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParamTestApplication.class, args);
    }
}
