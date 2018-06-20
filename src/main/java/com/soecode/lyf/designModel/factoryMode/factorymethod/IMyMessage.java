package com.soecode.lyf.designModel.factoryMode.factorymethod;

import java.util.Map;

/**
 * 工厂方法模式_产品接口
 *
 * Created by llh on 2018-06-20
 */
public interface IMyMessage {

    public Map<String, Object> getMessageParam();

    public void setMessageParam(Map<String, Object> messageParam);

    public void sendMesage() throws Exception;// 发送通知/消息

}
