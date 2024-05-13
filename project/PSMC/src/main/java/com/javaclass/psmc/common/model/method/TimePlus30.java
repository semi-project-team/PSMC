package com.javaclass.psmc.common.model.method;

import java.util.Map;

public class TimePlus30 {



    public String[] timeFormat(String start){
        int[] time = extractTime(start);
        int hour = time[0];
        int min = time[1];
        String timeHour = String.format("%02d:%02d",hour,min);
        String  timeHalfHour;
        if(min<30){
            timeHalfHour = String.format("%02d:%02d", hour, 30);
        }
        else{
            hour = (hour + 1) % 24; // 24시간 형식으로 계산하기 위해 나머지 연산을 수행합니다.
            timeHalfHour = String.format("%02d:%02d", hour, 0);
        }
        
        return new String[]{timeHour,timeHalfHour};
    }

    public int[] extractTime(String start){
        String[] parts = start.split(":");
        int hour =Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);

        return new int[]{hour,min};
    }


}
