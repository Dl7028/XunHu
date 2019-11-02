package com.example.xunhu.trans.bean;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * xml解析的句子集合
 */
@Root(name = "sent",strict = true)
public class XMLSent {
    @Element(name = "orig",required = true)
    private String orig;
    @Element(name = "trans",required = true)
    private String trans;

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }
}
