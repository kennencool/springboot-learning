package com.kennen.springbootredis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kennen.springbootredis.pojo.User;
import com.kennen.springbootredis.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	@Autowired
	@Qualifier("redisTemplate") private RedisTemplate redisTemplate;
	@Autowired private RedisUtil redisUtil;

    @Test
    public void test() {
        // 操作常用的方法可以直接使用redisTemplate，redisTemplate.opsForValue 操作String; redisTemplate.opsForList 操作list
        // 其他类似 redisTemplate.opsForValue().xxx;  xxx为方法名
        redisTemplate.opsForValue().set("mykey","kuangshen");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
    }

    @Test
    public void test1() throws JsonProcessingException {
        // 但真实开发一般都使用json来传递对象
        User user = new User("狂神说",3);
        //String jsonUser = new ObjectMapper().writeValueAsString(user);
        //redisUtil.set("user", jsonUser);
        redisUtil.set("user",user);
        System.out.println(redisUtil.get("user"));
    }
}
