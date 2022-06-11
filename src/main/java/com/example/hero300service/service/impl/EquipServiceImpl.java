package com.example.hero300service.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hero300service.counter.Counter;
import com.example.hero300service.counter.RedisThread;
import com.example.hero300service.mapper.EquipMapper;
import com.example.hero300service.pojo.Equip;
import com.example.hero300service.service.EquipService;
import com.example.hero300service.utils.JedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipServiceImpl extends ServiceImpl<EquipMapper, Equip> implements EquipService {

    @Autowired
    private Counter counter;
    @Autowired
    private JedisUtil jedisUtil;

    public Map<String, Equip> getEquipAll() {
        Map<String, Equip> map = new HashMap<>();
        for (Equip equip : this.list()) {
            map.put(equip.getEname(), equip);
        }
        return map;
    }

    public List<int[]> getEquitCount(Integer eid, String[] attrs) {
        Equip equip = this.getById(eid);
        if (equip == null) return null;

        String key = "" + eid;
        for (String attr : attrs) {
            key += attr;
        }
        List<int[]> list = null;
        if (jedisUtil.exists(key)) {
            list = JSONObject.parseArray(jedisUtil.get(key), int[].class);
        } else {
            list = counter.getCompResult(equip, attrs);
            whileRedis(key, list);
        }
        return list;
    }

    public void whileRedis(String key, List<int[]> list) {
        String value = JSONObject.toJSONString(list);
        RedisThread thread = new RedisThread(key, value, jedisUtil);
        thread.start();
    }
}