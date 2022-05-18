package com.example.hero300service.controller;

import com.example.hero300service.counter.Counter;
import com.example.hero300service.pojo.Equip;
import com.example.hero300service.service.EquipService;
import com.example.hero300service.utils.ResultVO;
import com.example.hero300service.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HeroController {

    @Autowired
    private EquipService equipService;
    @Autowired
    private Counter counter;

    @GetMapping("/equip")
    public ResultVO getEquipAll() {
        Map<String, Equip> map = new HashMap<>();
        for (Equip equip : equipService.list()) {
            map.put(equip.getEname(), equip);
        }
        return ResultVOUtil.success(map, equipService.count());
    }

    @PostMapping("/equip")
    public ResultVO getEquipCount(Integer eid, String[] attrs) {
        Equip equip = equipService.getById(eid);
        if (equip == null) return null;
        return ResultVOUtil.success(counter.getCompResult(equip, attrs), 0L);
    }
}
