package com.example.xunhu.trans.bean;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "acceptation",strict = false)
public class XMLAcceptation {
    @Text()
    private String acceptation;

    public String getAcceptation() {
        return acceptation;
    }

    public void setAcceptation(String acceptation) {
        this.acceptation = acceptation;
    }
}
