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
import java.net.URI;
import redis.clients.jedis.JedisShardInfo;

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
	@GetMapping("/chkredis")
	public String checkRedis() {
		String msg="Error Connecting Redis";
		try 
		{
			  JedisShardInfo shardInfo = new JedisShardInfo("http://redisroute-default.apps.lnk.phciclab.net");
			  shardInfo.setPassword("admin");

			  Jedis jedis = new Jedis(shardInfo);
			  msg = msg + "Step 1"; 
			  jedis.set("key1", "Value1");
			  msg = msg + "Step 2"; 
			  msg = msg + "Step 3" + jedis.get("key1") ; 
		}
		catch(Exception ex)
		{
			
		}
		return msg;
	}
}
