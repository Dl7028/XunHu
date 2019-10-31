package com.example.test05.trans.presenter;

/**
 * 搜索单词的BasePresenter层
 * @param <V>
 */
public class QueryWordsBasePresenter<V>  {
    private V view;

    public void attachView(V view){
        this.view = view;
    }

    public void detachView(){
        view = null;
    }

    public V getMvpView(){
        return view;
    }

    public boolean isAttachView(){
        return view != null;
    }
}
