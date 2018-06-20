package com.soecode.lyf.designModel.factoryMode.factorymethod;

import com.soecode.lyf.designModel.factoryMode.factorymethod.impl.MyAbstractMessage;

/**
 * 工厂方法模式_oa待办产品
 *
 * Created by llh on 2018-06-20
 */
public class MyMessageOaTodo extends MyAbstractMessage {

    @Override
    public void sendMesage() throws Exception {
        // TODO Auto-generated method stub
        if (null == getMessageParam()|| null == getMessageParam().get("OAUSERNAME")|| "".equals(getMessageParam().get("OAUSERNAME"))) {
            throw new Exception("发送OA待办,需要传入OAUSERNAME参数");// 为了简单起见异常也不自定义了
        }// 这里的参数需求就比较多了不一一处理了

        System.out.println("我是OA待办，发送通知给" + getMessageParam().get("OAUSERNAME"));
    }

}