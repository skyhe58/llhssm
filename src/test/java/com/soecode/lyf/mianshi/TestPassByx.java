package com.soecode.lyf.mianshi;


/**
 * @author llh @date 2018/6/26
 */
public class TestPassByx {
    public static void main(String[] args) {
        TestPassByx t = new TestPassByx();
        t.first();
    }

    public void first(){
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v,i);
        System.out.println("first : " + v.i);
    }

    public void second(Value v, int i){
        i = 0;
        v.i = 20;
        Value val = new Value();
        v = val;
        System.out.println("second : " +v.i + "  " + i);
    }
}

class Value{
    public int i = 15;
}
