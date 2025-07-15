package com.shourov.elk_stack_microservice_logging;

import com.shourov.elk_stack_microservice_logging.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@Slf4j
public class ElkStackMicroserviceLoggingApplication {

	@GetMapping("/getUser/{id}")
	public User getUserById(@PathVariable int id) {
		List<User> userList = getUserList();
		User user = userList.stream().filter(u -> u.getId() == id).findAny().orElse(null);
		if(user != null) {
			log.info("User found: {}", user);
			return user;
		} else {
			try {
				throw new Exception();
			} catch (Exception ex) {
				ex.printStackTrace();
				log.error("User not found with ID: {}", id);
			}
			return new User();
		}
	}

	private List<User> getUserList() {
		return List.of(
				User.build(1, "John"),
				User.build(2, "Alex"),
				User.build(3, "Bob"),
				User.build(4, "Tim")
		);
	}

	public static void main(String[] args) {
		SpringApplication.run(ElkStackMicroserviceLoggingApplication.class, args);
	}

}
