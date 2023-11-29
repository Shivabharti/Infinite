package com.java.cols;


import java.util.Optional;  
public class OptionalEx2 {  
    public static void main(String[] args) {  
        String[] str = new String[10];        
        str[5] = "SELF LOVE IS IMPORTANT";
        Optional<String> checkNull = Optional.ofNullable(str[5]);  
        if(checkNull.isPresent()){  
            String lowercaseString = str[5].toLowerCase();  
            System.out.print(lowercaseString);  
        }else  
            System.out.println("String value is not present");  
    }  
} 