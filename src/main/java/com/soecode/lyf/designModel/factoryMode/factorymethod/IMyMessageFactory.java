package com.soecode.lyf.designModel.factoryMode.factorymethod;

/**
 * 工厂方法模式_工厂接口
 *
 * Created by llh on 2018-06-20
 */
public interface IMyMessageFactory {

    public IMyMessage createMessage(String messageType);

}