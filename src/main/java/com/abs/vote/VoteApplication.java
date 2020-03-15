package com.abs.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import redis.clients.jedis.Jedis; 

@SpringBootApplication
@RestController
public class VoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteApplication.class, args);
	}
	@RequestMapping(value = "/welcome") 
	public String sayWelcome()  
	{ 
		return "Hello Voters";  
	}  
	@RequestMapping(value = "/showvote") 
	public String showVote()  
	{ 
		return "Your Candidate is Leading v1.1 ";  
	}  
	@GetMapping("/addvote/{v_id}")
	public String addVote(@PathVariable String v_id) {
		

		return v_id+"1";
	}
	@GetMapping("/getvote/{c_id}")
	public String getVote(@PathVariable String c_id) {
		

		return c_id+"100";
	}
}
