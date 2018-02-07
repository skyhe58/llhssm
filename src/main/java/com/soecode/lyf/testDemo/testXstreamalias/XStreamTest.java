package com.soecode.lyf.testDemo.testXstreamalias;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.mapper.ClassAliasingMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by llh
 */
public class XStreamTest {

    public static void main(String[] args) {


        List<RequestTest> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
   /*
            List<RequestTest> list = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
            RequestTest requestTest = new RequestTest();
            requestTest.setReturnMessage("ok");
            requestTest.setStatus(200);
            requestTest.setReqTime("2013-09-22 00:00:00.0");
            list.add(requestTest);*/

            RequestTest requestTest = new RequestTest();
            requestTest.setReturnMessage("ok");
            requestTest.setStatus(200);
            requestTest.setReqTime("2013-09-22 00:00:00.0");
            list.add(requestTest);


        }

//        XStreamTest test = new XStreamTest(list);
        XStream xstream = new XStream();
        ClassAliasingMapper mapper = new ClassAliasingMapper(xstream.getMapper());
//        mapper.addClassAlias("tag", String.class);
        xstream.alias("RequestTest",RequestTest.class);
//        xstream.alias("Test",XStreamTest.class);
//        xstream.registerLocalConverter(XStreamTest.class, "tags", new CollectionConverter(mapper));
//        xstream.alias("", java.util.List.class);

        System.out.println(xstream.toXML(list));

        String a = xstream.toXML(list).toString();
        System.out.println("===="+a.substring(6,a.length()));




      /*  String request = XstreamUtil.objectToXml(list);
        System.out.println(request);
        ResponseTest responseTest =XstreamUtil.xmlToObject(request, ResponseTest.class);
        System.out.println(responseTest);*/

        //1
         /*   RequestTest requestTest = new RequestTest();
            requestTest.setReturnMessage("ok");
            requestTest.setStatus(200);
            requestTest.setReqTime("2013-09-22 00:00:00.0");
        String request = XstreamUtil.objectToXml(requestTest);
        System.out.println(request);
        ResponseTest responseTest =XstreamUtil.xmlToObject(request, ResponseTest.class);
        System.out.println(responseTest);*/

    }
        public List<RequestTest> casss = new ArrayList<>();
        public XStreamTest(List list) {
            casss.addAll(list);
        }
}