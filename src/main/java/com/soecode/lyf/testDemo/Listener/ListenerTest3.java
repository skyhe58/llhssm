package com.soecode.lyf.testDemo.Listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Created by llh on 2018-02-03 13:40
 */

@Component
@PropertySource("test.properties")
public class ListenerTest3 implements ApplicationListener<EventTest> {

    @Value("${name1}")
    String name;

    @Override
    public void onApplicationEvent(EventTest event) {
        if (event.getMessage().equals(name)) {
            System.out.println("you need to find " + event.getMessage() + ",yes, I'am " + name);
        } else {
            System.out.println("you need to find " + event.getMessage() + ",but I'am not " + event.getMessage() + ",I'am " + name);
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}