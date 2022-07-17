package com.mxh.redisdemo.controller;

import com.mxh.redisdemo.counter.CountService;
import com.mxh.redisdemo.lock.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private LockService lockService;
    @Autowired
    private CountService countService;

    @GetMapping("lock")
    public void lock() {
        String key = "lock";
        lockService.lock(key);
        lockService.unLock(key);
    }

    @GetMapping("count")
    public void count() {
        String key = "count";
        countService.init(key, 100l);
        countService.subtract(key, 50l);
    }
}
