package com.javaclass.psmc.common.model.method;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FindTimeCode {

    public List<Integer> CantTimeCode(LocalTime start, LocalTime end){
        List<Integer> code = new ArrayList<>();

        for(int i = 1 ; i<17;i++){
            LocalTime startCode = LocalTime.parse(startCode(i));
            LocalTime endCode = LocalTime.parse(endCode(i));

            if(!(endCode.isBefore(start) || endCode.equals(start) || startCode.isAfter(end) || startCode.equals(end))){
                code.add(i);
            }
        }

        return code;
    }

    public String startCode(int i){
        String time ="";
        switch (i){
            case 1: time="09:00"; break;
            case 2: time="09:30"; break;
            case 3: time="10:00"; break;
            case 4: time="10:30"; break;
            case 5: time="11:00"; break;
            case 6: time= "11:30"; break;
            case 7: time="13:00"; break;
            case 8: time="13:30"; break;
            case 9: time="14:00"; break;
            case 10: time="14:30"; break;
            case 11: time="15:00"; break;
            case 12: time="15:30"; break;
            case 13: time="16:00"; break;
            case 14: time="16:30"; break;
            case 15: time="17:00"; break;
            case 16: time="17:30"; break;
        }

        return time;
    }

    public String endCode(int i){
        String time ="";
        switch (i){
            case 1: time="09:30"; break;
            case 2: time="10:00"; break;
            case 3: time="10:30"; break;
            case 4: time="11:00"; break;
            case 5: time="11:30"; break;
            case 6: time= "12:00"; break;
            case 7: time="13:30"; break;
            case 8: time="14:00"; break;
            case 9: time="14:30"; break;
            case 10: time="15:00"; break;
            case 11: time="15:30"; break;
            case 12: time="16:00"; break;
            case 13: time="16:30"; break;
            case 14: time="17:00"; break;
            case 15: time="17:30"; break;
            case 16: time="18:00"; break;
        }

        return time;
    }
}
