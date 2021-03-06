package com.scys.friendbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FriendboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendboxApplication.class, args);
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "hello";
	}
}
