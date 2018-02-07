package com.soecode.lyf.testDemo.testXstreamalias;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.mapper.ClassAliasingMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llh on 2017-12-18 16:17
 */
public class Test {
    public List<String> tags = new ArrayList<String>();
    public List<String> notags = new ArrayList<String>();
    public Test(String tag, String tag2) {
        tags.add(tag); tags.add(tag2);
        notags.add(tag); notags.add(tag2);
    }
    public static void main(String[] args) {
        Test test = new Test("foo", "bar");
        XStream xstream = new XStream();

        ClassAliasingMapper mapper = new ClassAliasingMapper(xstream.getMapper());
        mapper.addClassAlias("tag", String.class);
        xstream.registerLocalConverter(Test.class, "tags", new CollectionConverter(mapper));

        System.out.println(xstream.toXML(test));
    }
}