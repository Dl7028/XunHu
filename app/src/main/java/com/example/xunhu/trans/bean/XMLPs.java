package com.example.xunhu.trans.bean;

import androidx.annotation.NonNull;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * 对应xml解析的ps标签
 */
@Root(name = "ps",strict = false)
public class XMLPs {

    @Text()
    private String ps;

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }
}
