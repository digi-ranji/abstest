package com.abs.vote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import redis.clients.jedis.Jedis; 
import redis.clients.jedis.JedisPool; 
@SpringBootApplication
@RestController
public class VoteApplication {
	
	private  Jedis jedis = null;
	


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
	@GetMapping("/chkredis")
	public String checkRedis() {
		String msg="Error Connecting Redis";
		try 
		{
			if ( jedis == null)
				jedis = new Jedis("redisroute-abspoc.apps.lnk.phciclab.net", 6379);
			msg = msg + "Step 1"; 
			jedis.set("key1", "Value1");
			msg = msg + "Step 2"; 
			msg = "Success Key retrived is " + jedis.get("key1");
		}
		catch(Exception ex)
		{
			
		}
		return msg;
	}
}
