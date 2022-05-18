package com.example.hero300service.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("equip")
public class Equip {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String ename;
    private Integer gjl;
    private Integer fsqd;
    private Integer bjl;
    private Integer wlhj;
    private Integer fskx;
    private Integer smz;
    private Integer flz;
    private Integer smhf;
    private Integer flhf;
    private Integer gjsd;
}
