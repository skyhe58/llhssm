package com.soecode.lyf.designModel.factoryMode.abstractFactoryModel;

import com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.impl.Factory;

/**
 * Created by llh on 2018-06-21
 */
public class ClientTest {
    public static void main(String[] args){
        IFactory factory = new Factory();
        factory.createProduct1().show();
        factory.createProduct2().show();
    }
}