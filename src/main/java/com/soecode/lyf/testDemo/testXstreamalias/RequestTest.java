package com.soecode.lyf.testDemo.testXstreamalias;

/**
 * Created by llh on 2017-12-14 18:52
 */

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


@XStreamAlias("Response")
public class RequestTest {

    @XStreamAlias("returncode")
    private String returnCode;

    @XStreamAlias("returnmessage")
    private String returnMessage;

    @XStreamAlias("status")
    private int status;

    @XStreamAlias("time")
    private String reqTime;

//    private List testList;

    public String getReturnCode() {

        return returnCode;

    }

    public void setReturnCode(String returnCode) {

        this.returnCode = returnCode;

    }

    public String getReturnMessage() {

        return returnMessage;

    }

    public void setReturnMessage(String returnMessage) {

        this.returnMessage = returnMessage;

    }

    public int getStatus() {

        return status;

    }

    public void setStatus(int status) {

        this.status = status;

    }

    public String getReqTime() {

        return reqTime;

    }

    public void setReqTime(String reqTime) {

        this.reqTime = reqTime;
    }

    @Override

    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }


}