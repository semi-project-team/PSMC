package com.javaclass.psmc.common.model.method;

import java.time.LocalDate;

public class MenuHandling {

    private static int day;
    private static LocalDate date;

    public void setDay(int day){
        this.day=day;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public int minusDay(){
        --day;
        this.date =this.date.minusDays(1);

        if(day<=0){
            day=7;
        }


        return day;
    }

    public int plusDay(){
        ++day;
        if(day>7){
            day=1;
        }
        this.date=this.date.plusDays(1);


        return day;
    }
}
