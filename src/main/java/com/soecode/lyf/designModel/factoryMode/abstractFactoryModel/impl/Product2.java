package com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.impl;

import com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.IProduct2;

/**
 * Created by llh on 2018-06-21
 */
class Product2 implements IProduct2 {
    @Override
    public void show() {
        System.out.println("这是2型产品");
    }
}