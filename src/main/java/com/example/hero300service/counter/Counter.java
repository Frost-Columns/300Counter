package com.example.hero300service.counter;

import com.example.hero300service.pojo.Cost;
import com.example.hero300service.pojo.Equip;
import com.example.hero300service.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Counter {

    private static CostService costService;

    private static Map<String, Cost> costMap = new HashMap<>();

    @Autowired
    public void setCostService(CostService costService) {
        Counter.costService = costService;
        costMap.put("gjl", costService.getById("gjl"));
        costMap.put("fsqd", costService.getById("fsqd"));
        costMap.put("bjl", costService.getById("bjl"));
        costMap.put("wlhj", costService.getById("wlhj"));
        costMap.put("fskx", costService.getById("fskx"));
        costMap.put("smz", costService.getById("smz"));
        costMap.put("flz", costService.getById("flz"));
        costMap.put("smhf", costService.getById("smhf"));
        costMap.put("flhf", costService.getById("flhf"));
        costMap.put("gjsd", costService.getById("gjsd"));
    }

    public List<int[]> getCompResult(Equip equip, String[] attrs) {
        switch( attrs.length) {
            case 2 :
                return compLong2(attrs, equip);
            case 3 :
                return compLong3(attrs, equip);
            case 4 :
                return compLong4(attrs, equip);
        }
        return null;
    }

    private List<int[]> compLong2(String[] attrs, Equip equip) {
        int countAll = 1500;
        List<int[]> list = new ArrayList<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i=1; i<countAll; i++) {
            map1.put(i, compSx(attrs[0], equip, i));
        }
        for(int i=1; i<countAll; i++) {
            map2.put(i, compSx(attrs[1], equip, i));
        }
        for(int i=1;i<countAll; i++) {
            for(int j=1; j<countAll-i; j++) {
                if( (map1.get(i) + map2.get(j)) == getTotalValue(equip) ) {
                    int[] reult = {i, j};
                    list.add(reult);
                }
            }
        }
        return list;
    }

    private List<int[]> compLong3(String[] attrs, Equip equip) {
        int countAll = 1500;
        List<int[]> list = new ArrayList<>();
        List<Integer[]> list12;
        Map<Integer, List> cmap12 = new HashMap<>();
        Map<Integer,Integer> cmap1 = new HashMap<>();
        Map<Integer,Integer> cmap2 = new HashMap<>();
        for(int i=1; i<countAll; i++) {
            cmap1.put(i, compSx(attrs[1], equip, i));
        }
        for(int i=1; i<countAll; i++) {
            cmap2.put(i, compSx(attrs[2], equip, i));
        }
        int key = 0;
        for(int i=1;i<countAll; i++) {
            for(int j=1; j<countAll-i; j++) {
                key = cmap1.get(i) + cmap2.get(j);
                Integer[] itg = {i, j};
                if( cmap12.containsKey(key) ) {
                    cmap12.get(key).add(itg);
                }else {
                    list12 = new ArrayList<>();
                    list12.add(itg);
                    cmap12.put(key, list12);
                }
            }
        }
        for(int i=1; i<countAll; i++) {
            int sn = getTotalValue(equip) - compSx(attrs[0], equip, i);
            if( cmap12.containsKey(sn) ) {
                for(int j=0; j<cmap12.get(sn).size(); j++) {
                    int[] result = {i, ((Integer[])cmap12.get(sn).get(j))[0], ((Integer[])cmap12.get(sn).get(j))[1]};
                    list.add(result);
                }
            }
        }
        return list;
    }

    private List<int[]> compLong4(String[] attrs, Equip equip) {
        int countAll = 1500;
        List<int[]> list = new ArrayList<>();
        List<Integer[]> list12;
        Map<Integer, List> map12 = new HashMap<>();
        Map<Integer,Integer> map0 = new HashMap<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        Map<Integer,Integer> map3 = new HashMap<>();
        for(int i=1; i<countAll; i++) {
            map0.put(i, compSx(attrs[0], equip, i));
        }
        for(int i=1; i<countAll; i++) {
            map1.put(i, compSx(attrs[1], equip, i));
        }
        for(int i=1; i<countAll; i++) {
            map2.put(i, compSx(attrs[2], equip, i));
        }
        for(int i=1; i<countAll; i++) {
            map3.put(i, compSx(attrs[3], equip, i));
        }
        int key = 0;
        for(int i=1;i<countAll; i++) {
            for(int j=1; j<countAll-i; j++) {
                key = map2.get(i) + map3.get(j);
                Integer[] itg = {i, j};
                if( map12.containsKey(key) ) {
                    map12.get(key).add(itg);
                }else {
                    list12 = new ArrayList<>();
                    list12.add(itg);
                    map12.put(key, list12);
                }
            }
        }
        for(int i=1; i<countAll; i++) {
            for(int j=1; j<countAll-i; j++) {
                int sn = getTotalValue(equip) - map0.get(i) - map1.get(j);
                if( map12.containsKey(sn) ) {
                    for(int k=0; k<map12.get(sn).size(); k++) {
                        int[] result = {i, j, ((Integer[])map12.get(sn).get(k))[0], ((Integer[])map12.get(sn).get(k))[1]};
                        list.add(result);
                    }
                }
            }
        }

        return list;

    }

    /**
     * 根据选项名称选择计算方法
     * @param attr count
     * @return int 所需价值
     */
    private int compSx(String attr, Equip equip, int count) {
        int n = 0;
        switch (attr) {
            case "gjl":
                n = Algorithm.getCost(costMap.get("gjl"), equip.getGjl(), count);
                break;
            case "fsqd":
                n = Algorithm.getCost(costMap.get("fsqd"), equip.getFsqd(), count);
                break;
            case "bjl":
                n = Algorithm.getCost(costMap.get("bjl"), equip.getBjl(), count);
                break;
            case "wlhj":
                n = Algorithm.getCost(costMap.get("wlhj"), equip.getWlhj(), count);
                break;
            case "fskx":
                n = Algorithm.getCost(costMap.get("fskx"), equip.getGjl(), count);
                break;
            case "smz":
                n = Algorithm.getCost(costMap.get("smz"), equip.getSmz(), count);
                break;
            case "flz":
                n = Algorithm.getCost(costMap.get("flz"), equip.getFlz(), count);
                break;
            case "smhf":
                n = Algorithm.getCost(costMap.get("smhf"), equip.getSmhf(), count);
                break;
            case "flhf":
                n = Algorithm.getCost(costMap.get("flhf"), equip.getFlhf(), count);
                break;
            case "gjsd":
                n = Algorithm.getCost(costMap.get("gjsd"), equip.getGjsd(), count);
                break;
        }
        return n;
    }

    private int getTotalValue(Equip equip) {
        int count = 0;
        count += equip.getGjl() * costMap.get("gjl").getCostOne();
        count += equip.getFsqd() * costMap.get("fsqd").getCostOne();
        count += equip.getBjl() * costMap.get("bjl").getCostOne();
        count += equip.getWlhj() * costMap.get("wlhj").getCostOne();
        count += equip.getFskx() * costMap.get("fskx").getCostOne();
        count += equip.getSmz() * costMap.get("smz").getCostOne();
        count += equip.getFlz() * costMap.get("flz").getCostOne();
        count += equip.getSmhf() * costMap.get("smhf").getCostOne();
        count += equip.getFlhf() * costMap.get("flhf").getCostOne();
        count += equip.getGjsd() * costMap.get("gjsd").getCostOne();
        return count;
    }

}
