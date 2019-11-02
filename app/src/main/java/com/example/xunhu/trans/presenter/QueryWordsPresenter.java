package com.example.xunhu.trans.presenter;

import android.util.Log;

import com.example.xunhu.trans.bean.XMLDict;
import com.example.xunhu.trans.contract.IQueryWordContract;
import com.example.xunhu.trans.model.QueryWordModel;

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
     * @param x
     */
    @Override
    public void querySuccess(XMLDict x) {
        if(isAttachView()){
            getMvpView().querySuccess(x);
            Log.d("presenter访问数据成功",""+x.getKey()+x.getId());

        }

    }

    /**
     * 查词失败返回信息
     * @param msg
     */
    @Override
    public void queryError(String msg) {
        if(isAttachView()){
            getMvpView().queryError("访问服务器错误");
        }
    }


}
