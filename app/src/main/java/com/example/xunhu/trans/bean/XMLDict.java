package com.example.xunhu.trans.bean;

import android.widget.LinearLayout;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * 对应xml解析的dict标签
 */
@Root(name="dict",strict = false)
public class XMLDict {
    @Attribute(name="num",required = false)
    private String num;
    @Attribute(name="id",required = false)
    private String id;
    @Attribute(name = "name",required = false)
    private String name;
    @Element(name = "key",required = true)
    private String key;

    //发音，有两个
    @ElementList(entry = "ps",inline = true,required = false)
    private List<XMLPs> psList;
    //发音地址，有两个
    @ElementList(entry = "pron",inline = true,required = false)
    private List<XMLPron> pronList;
    //单词的形态，有三个
    @ElementList(entry = "pos",inline = true,required = false)
    private List<XMLPos> posList;
    //单词基本释义，有两个
    @ElementList(entry = "acceptation",inline = true,required = false)
    private List<XMLAcceptation> acceptationList;

    //句子集合
    @ElementList(entry = "sent",inline = true,required = false)
    private List<XMLSent> sentList;

    public String getNum() {
        return num;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public List<XMLPs> getPsList() {
        return psList;
    }

    public List<XMLPron> getPronList() {
        return pronList;
    }

    public List<XMLPos> getPosList() {
        return posList;
    }

    public List<XMLAcceptation> getAcceptationList() {
        return acceptationList;
    }

    public List<XMLSent> getSentList() {
        return sentList;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPsList(List<XMLPs> psList) {
        this.psList = psList;
    }

    public void setPronList(List<XMLPron> pronList) {
        this.pronList = pronList;
    }

    public void setPosList(List<XMLPos> posList) {
        this.posList = posList;
    }

    public void setAcceptationList(List<XMLAcceptation> acceptationList) {
        this.acceptationList = acceptationList;
    }

    public void setSentList(List<XMLSent> sentList) {
        this.sentList = sentList;
    }

    public XMLDict(){
        super();
    }

    public XMLDict(String num, String id, String name, String key, List<XMLPs> psList, List<XMLPron> pronList, List<XMLPos> posList, List<XMLAcceptation> acceptationList, List sentList) {
        this.num = num;
        this.id = id;
        this.name = name;
        this.key = key;
        this.psList = psList;
        this.pronList = pronList;
        this.posList = posList;
        this.acceptationList = acceptationList;
        this.sentList = sentList;
    }


}
