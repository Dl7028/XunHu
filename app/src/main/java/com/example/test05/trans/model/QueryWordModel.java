package com.example.test05.trans.model;

import com.example.test05.trans.contract.IQueryWordContract;
import com.example.test05.trans.iApiService.QueryWordApiService;
import com.example.test05.util.RetrofitManager;

/**
 * mvp模式下查找单词的model层
 */

public class QueryWordModel implements IQueryWordContract.IModel {

    private IQueryWordContract.IPresenter mPresenter;

    public QueryWordModel(IQueryWordContract.IPresenter presenter){
        mPresenter = presenter;
    }




    @Override
    public void queryWord(String word) {
        RetrofitManager.getInstance()
                .createRs(QueryWordApiService.class)
                .queryWord(word);
               // .enqueue( );
    }
}
