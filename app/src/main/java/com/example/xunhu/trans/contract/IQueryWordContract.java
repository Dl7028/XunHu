package com.example.xunhu.trans.contract;

import com.example.xunhu.trans.bean.XMLDict;

public class IQueryWordContract {

    public interface IView{
        void querySuccess(XMLDict x);
        void queryError(String msg);
    }

    public  interface IPresenter {
        //View层调用
        void querySuccess(XMLDict x);
        void queryError(String msg);

        //model层调用
        void queryWord(String word);
    }

    public interface IModel{
        void queryWord(String word);
    }

}
