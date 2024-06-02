package com.javaclass.psmc.common.model.method;

public class MakePhoneNumber {

    public String formatPhoneNumber(String phoneNumber){
        String numbers = phoneNumber.replaceAll("[^0-9]", "");

        if(numbers.length()==10) {
            return numbers.substring(0, 3) + "-" + numbers.substring(3, 6) + "-" + numbers.substring(6);
        }
        else if(numbers.length()==9) {
            return numbers.substring(0,2)+"-"+numbers.substring(2,5)+"-"+numbers.substring(5);
        }
        else{
            return  numbers.substring(0,3)+"-"+numbers.substring(3,7)+"-"+numbers.substring(7);

        }
    }
}
