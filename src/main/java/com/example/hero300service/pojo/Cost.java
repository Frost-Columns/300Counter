package com.example.hero300service.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cost")
public class Cost {
    @TableId
    private String id;
    private Integer costOne;
    private Integer countTwo;
    private Integer costTwo;
    private Integer countThree;
    private Integer costThree;
    private Integer countFour;
    private Integer costFour;
    private Integer countFive;
    private Integer costFive;
    private Integer costSix;
}
