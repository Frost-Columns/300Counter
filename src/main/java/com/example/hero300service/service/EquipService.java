package com.example.hero300service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hero300service.pojo.Equip;

import java.util.List;
import java.util.Map;

public interface EquipService extends IService<Equip> {

    Map<String, Equip> getEquipAll();

    List<int[]> getEquitCount(Integer eid, String[] attrs);
}
