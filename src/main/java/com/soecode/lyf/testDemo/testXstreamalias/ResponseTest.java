package com.soecode.lyf.testDemo.testXstreamalias;

/**
 * Created by llh on 2017-12-14 18:56
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.sql.Timestamp;


@XStreamAlias("Response")
public class ResponseTest {

    @XStreamAlias("returncode")
    private int resultCode;

    @XStreamAlias("time")
    private Timestamp time;

    @XStreamAlias("returnmessage")
    private String resultMessage;

    @XStreamAlias("status")
    private int state;

    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }



}