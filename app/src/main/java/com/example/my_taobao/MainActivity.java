package com.example.my_taobao;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_taobao.Base.SimpleActivity;
import com.example.my_taobao.Home.mvp.HomeFragment;
import com.example.my_taobao.Message.MessageFragment;
import com.example.my_taobao.Mine.MineFragment;
import com.example.my_taobao.Shop.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends SimpleActivity implements  NavigationBarView.OnItemSelectedListener {

    private static final long TIME = 2000;
    private final String TAG = "MainActivity";

    private boolean isExit = false;

    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private ShopFragment shopFragment;
    private MineFragment mineFragment;

    private Fragment[] fragments;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;


    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainContainer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mFragmentManager = getSupportFragmentManager();
        mTransaction = mFragmentManager.beginTransaction();
        Log.d(TAG, "initView");
        initTab();
        initFragment();
    }


    // 加载Fragment
    private void initFragment() {
        homeFragment = new HomeFragment();
        messageFragment = new MessageFragment();
        shopFragment = new ShopFragment();
        mineFragment = new MineFragment();

        fragments = new Fragment[]{homeFragment, homeFragment, homeFragment, homeFragment};

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.mainContainer, homeFragment)
                .commit();

        bottomNavigationView.setOnItemSelectedListener(this);
    }


    //初始化底部栏
    private void initTab() {
        Log.d(TAG, "initTab");
        bottomNavigationView = findViewById(R.id.bottomView);
    }


    //初始化监听
    @Override
    protected void initListener() {

    }


    //底部栏选择监听
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.home_page) {
            switchFragment(fragments[0]);
        } else if (item.getItemId() == R.id.message_page) {
            switchFragment(fragments[1]);
        } else if (item.getItemId() == R.id.shoppingcart_page) {
            switchFragment(fragments[2]);
        } else {
            switchFragment(fragments[3]);
        }

        return true;
    }

    //切换Fragment
    private void switchFragment(Fragment targetFragment) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!targetFragment.isAdded()) {
            transaction.add(R.id.mainContainer, targetFragment);
        }
        for (Fragment fragment : fragments) {
            if (fragment != targetFragment) {
                transaction.hide(fragment);
            }
        }
        transaction.show(targetFragment);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByTwoClick();      //调用双击退出函数
        }
        return false;
    }

    private void exitByTwoClick() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(this, "再按一次返回键退出淘宝", Toast.LENGTH_SHORT).show();
            Timer tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, TIME);
        } else {
            System.exit(0);
        }
    }
}
