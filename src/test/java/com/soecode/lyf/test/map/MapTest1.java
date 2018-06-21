package com.soecode.lyf.test.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MapTest1 {

    @Test
    public void list(){
        List list = new ArrayList();
        for (int j = 0; j < 5; j++) {
            list.add(j);
            System.out.println(list);
        }
    }

    @Test
    public void map(){
        Map<String,String> map = new HashMap();
        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");

        String a = map.get("4").toString();
        System.out.println(a);
    }

    @Test
    public void equals(){
        String str = null;
        if (str.equals("Hello World!")){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
}


}
