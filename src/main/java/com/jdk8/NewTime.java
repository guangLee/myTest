package com.jdk8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class NewTime {

    public static void main(String[] args) {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "Runoob";
        Integer result = null;

        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");

        }catch(ScriptException e){
            System.out.println("执行脚本错误: "+ e.getMessage());
        }

        System.out.println(result.toString());

        // 获取当前的日期时间
//        LocalDateTime currentTime = LocalDateTime.now();
//        System.out.println("当前时间: " + currentTime);
//
//        LocalDate date1 = currentTime.toLocalDate();
//        System.out.println("date1: " + date1);
//
//        Month month = currentTime.getMonth();
//        int day = currentTime.getDayOfMonth();
//        int seconds = currentTime.getSecond();
//
//        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);
//
//        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
//        System.out.println("date2: " + date2);
//
        // 12 december 2014
//        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 31);
//        System.out.println("date3: " + date3);
//
//        // 22 小时 15 分钟
//        LocalTime date4 = LocalTime.of(22, 15);
//        System.out.println("date4: " + date4);

        // 解析字符串
//        LocalTime date5 = LocalTime.parse("20:15:30");
//        System.out.println("date5: " + date5);
    }
}
