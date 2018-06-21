package com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.impl;

import com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.IProduct1;

/**
 * Created by llh on 2018-06-21
 */
class Product1 implements IProduct1 {
    @Override
    public void show() {
        System.out.println("这是1型产品");
    }
}