package com.example.xunhu.trans.bean;

import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

/**
 * XML解析中的pos时态集合
 */
@Root(name = "pos",strict = false)
public class XMLPos {
    @Text()
    private String pos;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
