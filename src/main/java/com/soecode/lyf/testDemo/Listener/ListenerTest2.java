package com.soecode.lyf.testDemo.Listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by llh on 2018-02-03 11:58
 * 还有一个细节在于，信号灯对行人，是一对多的关系，那么这里的事件是否确实如此呢？为了验证，我便再写一个监听，再new一个行人，其他一切不变。
 */

@Component
public class ListenerTest2 implements ApplicationListener<EventTest> {

    @Override
    public void onApplicationEvent(EventTest event) {
        System.out.println("test2:" + event.getMessage());
    }
}