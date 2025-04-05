package com.order.io;

import org.springframework.boot.SpringApplication;

public class TestIoApplication {

	public static void main(String[] args) {
		SpringApplication.from(IoApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
