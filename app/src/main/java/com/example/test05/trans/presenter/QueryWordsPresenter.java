package com.example.test05.trans.presenter;

import com.example.test05.trans.contract.IQueryWordContract;
import com.example.test05.trans.model.QueryWordModel;

/**
 * mvp模式下查找单词的presenter层
 */

public class QueryWordsPresenter extends QueryWordsBasePresenter<IQueryWordContract.IView> implements IQueryWordContract.IPresenter {

    private IQueryWordContract.IModel mModel;

    public QueryWordsPresenter(){
        mModel = new QueryWordModel(this);
    }





    /**
     * 查词
     */
    @Override
    public void queryWord(String word) {
        mModel.queryWord(word);
    }


    /**
     * 查词成功返回数据
     * @param data
     */
    @Override
    public void querySuccess(String data) {
        if(isAttachView()){
            getMvpView().querySuccess(data);
        }
    }

    /**
     * 查词失败返回信息
     * @param msg
     */
    @Override
    public void queryError(String msg) {
        if(isAttachView()){
            getMvpView().querySuccess("访问服务器错误");
        }
    }


}
