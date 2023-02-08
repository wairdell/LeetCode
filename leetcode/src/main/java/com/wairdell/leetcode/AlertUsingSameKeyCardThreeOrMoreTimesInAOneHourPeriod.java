package com.wairdell.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * author : fengqiao
 * date   : 2023/2/7 9:58
 * desc   : 警告一小时内使用相同员工卡大于等于三次的人 https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 */
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            int hour = time.charAt(0) * 10 + time.charAt(1);
            int minute = time.charAt(3) * 10 + time.charAt(4);
            int timeInt = hour * 60 + minute;
            List<Integer> integerList = map.get(name);
            if (integerList == null) {
                integerList = new ArrayList<>();
                map.put(name, integerList);
            }
            integerList.add(timeInt);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<Integer> integerList = entry.getValue();
            Collections.sort(integerList);
            for (int i = 2; i < integerList.size(); i++) {
                if (integerList.get(i) - integerList.get(i - 2) <= 60) {
                    result.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    /*public boolean compareTime(String time1, String time2) {
        String[] split1 = time1.split(":");
        int hour1 = Integer.parseInt(split1[0]);
        int minute1 = Integer.parseInt(split1[1]);
        String[] split2 = time2.split(":");
        int hour2 = Integer.parseInt(split1[0]);
        int minute2 = Integer.parseInt(split1[1]);
        if (hour2 < hour1) {
            return false;
        }
        if ((hour2 - hour1) * 60 + minute2 - minute1 > 60) {
            return false;
        }
        return true;
    }*/

    public static void main(String[] args) {
        System.out.println(new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().alertNames(
                new String[]{"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"},
                new String[]{"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"}));
        System.out.println(new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().alertNames(
                new String[]{"alice", "alice", "alice", "bob", "bob", "bob", "bob"},
                new String[]{"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}));
        System.out.println(new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().alertNames(
                new String[]{"john", "john", "john"},
                new String[]{"23:58", "23:59", "00:01"}));
        System.out.println(new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().alertNames(
                new String[]{"leslie", "leslie", "leslie", "clare", "clare", "clare", "clare"},
                new String[]{"13:00", "13:20", "14:00", "18:00", "18:51", "19:30", "19:49"}));
        System.out.println(new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().alertNames(
                new String[]{"a", "a", "a", "a", "a", "a", "b", "b", "b", "b", "b"},
                new String[]{"23:27", "03:14", "12:57", "13:35", "13:18", "21:58", "22:39", "10:49", "19:37", "14:14", "10:41"}));
        System.out.println(new AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod().alertNames(
                new String[]{"a", "a", "a", "a", "a", "b", "b", "b", "b", "b", "b"},
                new String[]{"23:20", "11:09", "23:30", "23:02", "15:28", "22:57", "23:40", "03:43", "21:55", "20:38", "00:19"}));
    }

}
