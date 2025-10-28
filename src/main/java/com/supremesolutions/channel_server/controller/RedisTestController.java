package com.supremesolutions.channel_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")  // Add this line
public class RedisTestController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/test-redis")
    public String testRedis() {
        try {
            redisTemplate.opsForValue().set("channel:test", "Hello from Channel Server!");
            String value = redisTemplate.opsForValue().get("channel:test");
            return "✅ Redis Connected (Channel Server)! Value: " + value;
        } catch (Exception e) {
            return "❌ Redis connection failed: " + e.getMessage();
        }
    }
}
