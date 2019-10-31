package com.example.test05.trans.contract;

public class IQueryWordContract {

    public interface IView{
        void querySuccess(String data);
        void queryError(String msg);
    }

    public  interface IPresenter {
        //View层调用
        void querySuccess(String data);
        void queryError(String msg);

        //model层调用
        void queryWord(String word);
    }

    public interface IModel{
        void queryWord(String word);
    }

}
