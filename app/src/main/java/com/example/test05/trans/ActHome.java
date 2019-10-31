package com.example.test05.trans;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test05.R;
import com.example.test05.trans.view.fragment.FrHistory;
import com.example.test05.trans.view.fragment.FrHome;
import com.example.test05.trans.view.fragment.FrPersonal;
import com.example.test05.trans.view.fragment.FrTrans;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 按钮组RadioGroup程序整体框架
 */

public class ActHome extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {


    //butterknife注解处理器框架
    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.tab_home)
    RadioButton tabHome;
    @BindView(R.id.tab_trans)
    RadioButton tabTrans;
    @BindView(R.id.tab_personal)
    RadioButton tabPersonal;
    @BindView(R.id.tab_bar)
    RadioGroup tabBar;

    public final static String ACTION_EXIT_SYSTEM = "sys_exit";

    public static FragmentManager manager;
    private FragmentTransaction transaction;

    private FrHome frHome;
    private FrTrans frTrans;
    private FrHistory frHistory;
    private FrPersonal frPersonal;
    private long mExitTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);                        //注解处理器的使用
        RadioButton tabHome = (RadioButton) tabBar.getChildAt(0);
        tabHome.setChecked(true);                            //一开始就跳转到主页
        tabBar.setOnCheckedChangeListener(this);             //按钮组点击事件
        initFragment();
    }

    //初始化碎片
    private void initFragment() {
        manager = getSupportFragmentManager();                 //获取到FragmentManager
        transaction = manager.beginTransaction();              //开启一个事务
        frHome = new FrHome();                                //获取主页fragment实例
        transaction.add(R.id.frame_layout,frHome);           //向容器中加入Fragment
        transaction.commit();                                //提交事务
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.tab_home:
                FragmentTransaction ft1 = manager.beginTransaction();
                hideAll(ft1);
                if (frHome!=null){                          //新建实例前先判断实例是否为null
                    ft1.show(frHome);
                }else {
                    frHome=new FrHome();
                    ft1.add(R.id.frame_layout,frHome);
                }
                ft1.commit();
                break;
            case R.id.tab_trans:
                FragmentTransaction ft2 = manager.beginTransaction();
                hideAll(ft2);
                if (frHistory !=null){
                    ft2.show(frHistory);
                }else {
                    frHistory = new FrHistory();
                    ft2.add(R.id.frame_layout, frHistory);
                }
                ft2.commit();
                break;
            case R.id.tab_personal:
                FragmentTransaction ft3 = manager.beginTransaction();
                hideAll(ft3);
                if (frPersonal!=null){
                    ft3.show(frPersonal);
                }else {
                    frPersonal = new FrPersonal();
                    ft3.add(R.id.frame_layout, frPersonal);
                }
                ft3.commit();
                break;
        }
    }

    /**
     * 隐藏所有fragment
      * @param ft FragmentTransaction对象
     */
    private void hideAll(FragmentTransaction ft){
        if (ft==null){
            return;
        }
        if (frHome!=null){
            ft.hide(frHome);
        }
        if (frTrans !=null){
            ft.hide(frTrans);
        }
        if (frPersonal!=null){
            ft.hide(frPersonal);
        }if(frHistory!=null){
            ft.hide(frHistory);
        }
    }

    /**
     * 双击返回退出程序
     */
    @Override
    public void onBackPressed() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(ActHome.this,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onExit(ActHome.this);
                }
            }, 500);
        }
    }

    /**
     * 完全退出程序方法
     * @param context 上下文
     */
    public static void onExit(final Context context) {
        try {
            Intent intent = new Intent();
            intent.setAction(context.getApplicationContext().getPackageName() + ACTION_EXIT_SYSTEM);
            context.sendBroadcast(intent);        //发送广播
//             MobclickAgent.onKillProcess(context);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    System.exit(0);       //退出程序
                }
            }, 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

