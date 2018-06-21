package com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.impl;

import com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.IFactory;
import com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.IProduct1;
import com.soecode.lyf.designModel.factoryMode.abstractFactoryModel.IProduct2;

/**
 * Created by llh on 2018-06-21
 */
public class Factory implements IFactory {
    @Override
    public IProduct1 createProduct1() {
        return new Product1();
    }
    @Override
    public IProduct2 createProduct2() {
        return new Product2();
    }
}
