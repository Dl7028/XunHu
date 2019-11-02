package com.example.xunhu.trans.model;

import android.util.Log;

import com.example.xunhu.trans.bean.XMLDict;
import com.example.xunhu.trans.contract.IQueryWordContract;
import com.example.xunhu.trans.iApiService.QueryWordApiService;
import com.example.xunhu.util.RetrofitManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
                .queryWord(word)
                .enqueue(new Callback<XMLDict>() {
                    @Override
                    public void onResponse(Call<XMLDict> call, Response<XMLDict> response) {
                        if(response.body()!=null){
                         XMLDict xmlDict = new XMLDict(response.body().getNum(),response.body().getId(),
                                    response.body().getName(),response.body().getKey(),response.body().getPsList(),
                                    response.body().getPronList(),response.body().getPosList(),response.body().getAcceptationList(),
                                    response.body().getSentList());
                            /*XMLDict xmlDict = new XMLDict(response.body().getNum(),response.body().getId(),
                                    response.body().getName(),response.body().getKey(),response.body().getPsList(),
                                    response.body().getPsEn(),response.body().getPronEn(),response.body().getPsAm(),response.body().getPronAm(),response.body().getPosList(),response.body().getAcceptationList(),
                                    response.body().getSentList());*/
                            mPresenter.querySuccess(xmlDict);


                        }
                    }

                    @Override
                    public void onFailure(Call<XMLDict> call, Throwable t) {
                        mPresenter.queryError("查词失败");
                        Log.d("model","查词失败-----------"+t.getMessage()+"       " );
                    }

                });

    }
}
