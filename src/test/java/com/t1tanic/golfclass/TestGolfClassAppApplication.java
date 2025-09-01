package com.t1tanic.golfclass;

import org.springframework.boot.SpringApplication;

public class TestGolfClassAppApplication {

    public static void main(String[] args) {
        SpringApplication.from(GolfClassAppApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
