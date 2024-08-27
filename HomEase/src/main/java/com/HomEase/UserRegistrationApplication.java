package com.HomEase;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.HomEase.entity.User;
import com.HomEase.repo.UserRepository;

@SpringBootApplication
public class UserRegistrationApplication implements CommandLineRunner {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LocalDateTime date=LocalDateTime.now();
		User user=new User( null, "tom", passwordEncoder.encode("tom"),"tom@gmail.com","8004759654","CUSTOMER");
	}

}
