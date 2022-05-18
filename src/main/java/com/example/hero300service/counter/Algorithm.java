package com.example.hero300service.counter;

import com.example.hero300service.pojo.Cost;

public class Algorithm {

    /**
     * @param cost 属性
     * @param eqCount 装备基础值
     * @param count 加点点数
     * @return Integer 所需价值
     */
    public static Integer getCost(Cost cost, Integer eqCount, Integer count) {
        int jz = 0;
        for(int i=1; i<=count; i++) {
            if( i <= eqCount ) {
                jz += cost.getCostOne();
            }else if( i < (eqCount + cost.getCountTwo()) && cost.getCountTwo() != 0 ) {
                jz += cost.getCostTwo();
            }else if( i < (eqCount + cost.getCountThree()) && cost.getCountThree() != 0 ) {
                jz += cost.getCostThree();
            }else if( i < (eqCount + cost.getCountFour()) && cost.getCountFour() != 0 ) {
                jz += cost.getCostFour();
            }else if( i < (eqCount + cost.getCountFive()) && cost.getCountFive() != 0 ) {
                jz += cost.getCostFive();
            }else {
                jz += cost.getCostSix();
            }
        }
        return jz;
    }
}
