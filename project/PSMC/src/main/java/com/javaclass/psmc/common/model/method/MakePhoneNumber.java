package com.javaclass.psmc.common.model.method;

public class MakePhoneNumber {

    public String formatPhoneNumber(String phoneNumber){
        String numbers = phoneNumber.replaceAll("[^0-9]", "");

        if(numbers.length()==10) {
            return numbers.substring(0, 3) + "-" + numbers.substring(3, 6) + "-" + numbers.substring(6);
        }
        else{
            return  numbers.substring(0,3)+"-"+numbers.substring(3,7)+"-"+numbers.substring(7);

        }
    }
}
