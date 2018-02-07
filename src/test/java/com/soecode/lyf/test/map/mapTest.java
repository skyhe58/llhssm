package com.soecode.lyf.test.map;

import org.apache.commons.collections.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by llh on 2018-01-10 11:40
 */
public class mapTest {
    public static void main(String[] args) {
        System.out.println(convert());
    }

    public static Map convert (){
        Map param = new HashMap();
        param.put("kjnd",2017);
        param.put("kjqj",12);
        param.put("zbbm",2111111111);
        System.out.println("map-1-="+param);
        mapTransMap(param);
        System.out.println("map-2-="+param+","+ MapUtils.getString(param,"kjnd"));
        return param;
    }
    private static Map<String,String> mapTransMap(Map<String,String> params){
        Map<String,String> zbzParam = new HashMap<>(params);
        System.out.println("------"+zbzParam);
        Long bbh= 123L;
        params.put("bbh",String.valueOf(bbh));
        return params;

    }

}
