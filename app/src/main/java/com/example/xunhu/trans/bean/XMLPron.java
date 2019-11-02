package com.example.xunhu.trans.bean;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * xml解析中的发音地址
 */
@Root(name = "pron",strict = false)
public class XMLPron {
    @Text()
    private String pron;

    public void setPron(String pron) {
        this.pron = pron;
    }

    public String getPron() {
        return pron;
    }
}
