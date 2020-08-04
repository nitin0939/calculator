package com.example.calculatordemo.bean;

import ch.lambdaj.function.convert.Converter;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(usesCustomDelimiterSyntax(text)){
            return splitUsingCustomDelimiterSyntax(text);
        }else {
            return splitUsingNewLinesAndCommas(text);
        }
    }

    private static boolean usesCustomDelimiterSyntax(String text) {
        return text.startsWith("//");
    }

    private static String[] splitUsingNewLinesAndCommas(String text) {
        String tokens[]=text.split(",|\n");
        return tokens;
    }

    private static String[] splitUsingCustomDelimiterSyntax(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);
        return numbers.split(Pattern.quote(customDelimiter));
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
