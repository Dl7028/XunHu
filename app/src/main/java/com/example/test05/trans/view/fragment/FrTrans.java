package com.example.test05.trans.view.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test05.R;
import com.example.test05.trans.contract.IQueryWordContract;
import com.example.test05.trans.presenter.QueryWordsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.test05.trans.ActHome.manager;

/**
 * 翻译页面的fragment
 */

public class FrTrans extends Fragment implements IQueryWordContract.IView {

    @BindView(R.id.trans_word)
    TextView mTextView;
    private static final String TAG = "FrTrans";
    private IQueryWordContract.IPresenter mpresenter;

    private Unbinder unbinder;
    private FrHistory frHistory;
    private FrTrans frTrans;
    private String word;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_trans, container, false);
        unbinder = ButterKnife.bind(this, view);                    //fragment中使用BUtterKnife        Log.d(TAG,"进入FrTans");
        initView();




        return view;
    }

    /**
     * 初始化界面
     */
    private void initView(){

        Bundle bundle = getArguments();
        if(bundle!=null) {
            word = bundle.getString("FrTrans");     //碎片间的信息传递，word是从FrHistory接收而来的
        }

        mpresenter = new QueryWordsPresenter();
        mpresenter.queryWord(word);     //mvp模式下访问网络获取数据
    }


    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
    }



    /**
     * 传递信息的方法
     * @param text
     * @return
     */
    public static FrTrans newInstance(String text) {
        FrTrans f = new FrTrans();
        Bundle args = new Bundle();
        args.putString("FrTrans", text);
        f.setArguments(args);
        return f;
    }

    public void setQuery(String str){

    }




    @Override
    public void querySuccess(String word) {

    }

    @Override
    public void queryError(String msg) {

    }
}
