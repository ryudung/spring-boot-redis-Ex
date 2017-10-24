package com.example.redistest.service;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisService {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valusOperations;

    @Resource(name="redisTemplate")//string value
    private SetOperations<String, String> setOperations;

    @Resource(name="redisTemplate")//set 기능
    private ZSetOperations<String, String> zSetOperations;

    @Resource(name="redisTemplate")//map 기능
    private HashOperations<String, String, String> hashOperations;

    @Resource(name="redisTemplate")//list 기능
    private ListOperations<String, String> listOperations;

    public Long getVisitCount() {
        Long count = 0L;
        try {
            valusOperations.increment("visitor:count", 1);
            count = Long.valueOf(valusOperations.get("visitor:count"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return count;
    }
}
