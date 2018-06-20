package com.soecode.lyf.designModel.factoryMode.SimpleFactory;

/**
 * Created by llh on 2018-06-20
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        /**
         * 简单工厂模式
         */
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_GK);
        noodles.desc();
    }
}
