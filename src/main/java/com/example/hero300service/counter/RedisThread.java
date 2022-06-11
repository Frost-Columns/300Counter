package com.example.hero300service.counter;

import com.example.hero300service.utils.JedisUtil;

public class RedisThread extends Thread{

    private String key;

    private String value;

    private JedisUtil jedisUtil;

    public RedisThread(String key, String value, JedisUtil jedisUtil) {
        this.key = key;
        this.value = value;
        this.jedisUtil = jedisUtil;
    }

    @Override
    public void run() {
        jedisUtil.set(key, value);
    }
}
