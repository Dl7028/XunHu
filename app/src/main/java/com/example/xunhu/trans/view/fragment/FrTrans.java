package com.example.xunhu.trans.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.xunhu.R;
import com.example.xunhu.trans.bean.XMLDict;
import com.example.xunhu.trans.contract.IQueryWordContract;
import com.example.xunhu.trans.presenter.QueryWordsBasePresenter;
import com.example.xunhu.trans.presenter.QueryWordsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.xunhu.trans.ActMain.manager;

/**
 * 翻译页面的fragment
 */

public class FrTrans extends Fragment implements IQueryWordContract.IView, View.OnClickListener {

    @BindView(R.id.trans_word)
    TextView mKeyTv;
    @BindView(R.id.ps_en_button)
    TextView mPsEnTv;
    @BindView(R.id.ps_am_button)
    TextView mPsAmTv;
    @BindView(R.id.trans_acceptation)
    TextView mAcceptationTv;
    @BindView(R.id.trans_sent)
    TextView mSentTv;
    @BindView(R.id.trans_back)
    ImageButton mBackBtn;
    @BindView(R.id.trans_searchView)
    SearchView mSearchView;


    private static final String TAG = "FrTrans";
    private QueryWordsBasePresenter mpresenter;

    private Unbinder unbinder;
   /* private FrHistory frHistory;
    private FrTrans frTrans;
    private FrHome frHome;
    private FrPersonal frPersonal;*/
    private String word;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_trans, container, false);
        unbinder = ButterKnife.bind(this, view);                    //fragment中使用BUtterKnife
        initView();


        return view;
    }

    /**
     * 初始化界面
     */
    private void initView(){

        mSearchView.setSubmitButtonEnabled(true);  //设置显示搜索按钮
        mSearchView.setIconifiedByDefault(false); //设置不自动缩小为图标，点搜索框就出现软键盘
        //隐藏RearchView的搜索图标
        int magId = getResources().getIdentifier("android:id/search_mag_icon",null, null);
        ImageView magImage =  mSearchView.findViewById(magId);
        magImage.setLayoutParams(new LinearLayout.LayoutParams(0, 0));

        Bundle bundle = getArguments();
        if(bundle!=null) {
            word = bundle.getString("FrTrans");            //碎片间的信息传递，word是从FrHistory接收而来的
        }
        mpresenter = new QueryWordsPresenter();
        mpresenter.attachView(this);                            //添加绑定视图
        ((QueryWordsPresenter) mpresenter).queryWord(word);     //mvp模式下访问网络获取数据
        mBackBtn.setOnClickListener(this);                       //返回按钮点击事件
    }


    @Override
    public void onDestroyView() {
        if (unbinder != null) {
            unbinder.unbind();
        }
        super.onDestroyView();
        mpresenter.detachView();        //解除绑定
    }



    /**
     * 传递信息的方法
     * @param text 传输的信息
     * @return
     */
    public static FrTrans newInstance(String text) {
        FrTrans f = new FrTrans();
        Bundle args = new Bundle();
        args.putString("FrTrans", text);
        f.setArguments(args);
        return f;
    }


    /**
     * 查词成功返回的数据
     * @param x XMLDict实例
     */
    @Override
    public void querySuccess(XMLDict x) {
        updateView(x);
    }

    /**
     * 查词失败回调的方法
     * @param msg
     */
    @Override
    public void queryError(String msg) {

    }

    /**
     * 查词访问数据后更新ui
     * @param x 已经解析好的XMLDict实例
     */
    private void updateView(XMLDict x){
        mKeyTv.setText(x.getKey());
        //两个发音，英式和美式
        if(x.getPsList()!=null) {
            mPsEnTv.setText(x.getPsList().get(0).getPs());
            mPsAmTv.setText(x.getPsList().get(1).getPs());
        }
        StringBuilder acceptationBuilder = new StringBuilder();
        if(x.getPosList()!=null) {
            for(int i=0;i<x.getPosList().size();i++){

                acceptationBuilder.append(x.getPosList().get(i).getPos());
                if(x.getAcceptationList()!=null){
                    acceptationBuilder.append(x.getAcceptationList().get(i).getAcceptation());
                }
            }
        }
        StringBuilder sentBuilder = new StringBuilder();
        if(x.getSentList()!=null){
            for (int i=0;i<x.getSentList().size();i++){
                sentBuilder.append(x.getSentList().get(i).getOrig());
                sentBuilder.append(x.getSentList().get(i).getTrans());
            }
        }
        //单词的形态
        mAcceptationTv.setText(acceptationBuilder);
        //查词结果的句子
        mSentTv.setText(sentBuilder);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.trans_back:
                FragmentTransaction f = manager.beginTransaction();
                f.replace(R.id.frame_layout,new FrHistory());
                f.addToBackStack(null);
                f.commit();
        }
    }

}
