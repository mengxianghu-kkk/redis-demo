package com.mxh.redisdemo.lock;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class LockService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public Boolean lock(String key) {
        return stringRedisTemplate.opsForValue().setIfAbsent(key, "", 60, TimeUnit.SECONDS);
    }

    public Boolean unLock(String key) {
        return stringRedisTemplate.delete(key);
    }
}
