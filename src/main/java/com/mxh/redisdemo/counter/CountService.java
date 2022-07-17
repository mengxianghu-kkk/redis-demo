package com.mxh.redisdemo.counter;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CountService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public void init(String key, Long count) {
        stringRedisTemplate.opsForValue().set(key, String.valueOf(count));
    }

    public void subtract(String key, Long count) {
        stringRedisTemplate.opsForValue().increment(key, -count);
    }
}
