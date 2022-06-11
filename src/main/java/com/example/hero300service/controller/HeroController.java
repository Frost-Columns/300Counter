package com.example.hero300service.controller;

import com.example.hero300service.service.EquipService;
import com.example.hero300service.utils.ResultVO;
import com.example.hero300service.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroController {

    @Autowired
    private EquipService equipService;

    @GetMapping("/equip")
    public ResultVO getEquipAll() {
        return ResultVOUtil.success(equipService.getEquipAll(), equipService.count());
    }

    @PostMapping("/equip")
    public ResultVO getEquipCount(Integer eid, String[] attrs) {
        return ResultVOUtil.success(equipService.getEquitCount(eid, attrs), 0L);
    }
}
