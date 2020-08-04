package com.example.calculatordemo.bean;

import ch.lambdaj.function.convert.Converter;

import java.util.List;

import static ch.lambdaj.Lambda.*;
public class Calculator {
    public static int add(String text){
        if(text.isEmpty()){
            return 0;
        }else{
            String[] tokens=tokenize(text);
            List<Integer> numbers = convert(tokens, toInt());
            return sum(numbers).intValue();
        }
    }

    private static String[] tokenize(String text) {
        String tokens[]=text.split(",|\n");
        return tokens;
    }

    private static Converter<String, Integer> toInt(){
        return new Converter<String,Integer>() {
            public Integer convert(String s) {
            return toInt(s);
        }
        };
    }

    private static int toInt(String text) {
        return Integer.parseInt(text);
    }
}
