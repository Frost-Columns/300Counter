package com.example.hero300service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hero300service.mapper.CostMapper;
import com.example.hero300service.pojo.Cost;
import com.example.hero300service.service.CostService;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl extends ServiceImpl<CostMapper, Cost> implements CostService {
}
