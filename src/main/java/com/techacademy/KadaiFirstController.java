package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{yyyymmdd}")
    public String dispDayOfWeek(@PathVariable String yyyymmdd) { 
        
        String yyyy = yyyymmdd.substring(0,4); 
        String mm = yyyymmdd.substring(4,6);
        String dd = yyyymmdd.substring(6,8);
        
        int a = Integer.parseInt(yyyy);
        int b = Integer.parseInt(mm);
        int c = Integer.parseInt(dd);
        
        LocalDate ld = LocalDate.of(a,b,c);
        DayOfWeek w = ld.getDayOfWeek();
        DateTimeFormatter formmater = DateTimeFormatter.ofPattern("EEEE", Locale.ENGLISH);
        String sdf = formmater.format(w);
        
        return "実行結果：" + sdf;
        }
    
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "実行結果：" + res;
    }
        
    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "実行結果：" + res;
    }
        
    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
         int res = 0;
         res = val1 * val2;
         return "実行結果：" + res;
    }
    
    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
         int res = 0;
         res = val1 / val2;
         return "実行結果：" + res;
}
}
