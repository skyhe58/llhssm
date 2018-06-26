package com.soecode.lyf.designModel.factoryMode.factorymethod.impl;

import com.soecode.lyf.designModel.factoryMode.factorymethod.IMyMessage;

import java.util.Map;

/**
 * 工厂方法模式_虚拟产品类
 *
 * Created by llh on 2018-06-20
 */
public abstract class MyAbstractMessage implements IMyMessage {

    private Map<String, Object> messageParam;// 这里可以理解为生产产品所需要的原材料库。最好是个自定义的对象，这里为了不引起误解使用Map。

    @Override
    public Map<String, Object> getMessageParam() {
        return messageParam;
    }

    @Override
    public void setMessageParam(Map<String, Object> messageParam) {
        this.messageParam = messageParam;
    }
}