package com.example.my_taobao;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.my_taobao.Base.SimpleActivity;
import com.example.my_taobao.module.fragment.HomeFragment;
import com.example.my_taobao.module.fragment.MessageFragment;
import com.example.my_taobao.module.fragment.MineFragment;
import com.example.my_taobao.module.fragment.ShopFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends SimpleActivity implements  NavigationBarView.OnItemSelectedListener {

    private final String TAG = "MainActivity";

    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private ShopFragment shopFragment;
    private MineFragment mineFragment;

    private Fragment[] fragments;

    private FragmentManager mFragmentManager;
    private FragmentTransaction mTransaction;


//    ActivityMainBinding activityMainBinding;

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(activityMainBinding.getRoot());
//        initView(savedInstanceState);
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

        fragments = new Fragment[]{homeFragment, messageFragment, shopFragment, mineFragment};

        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.mainContainer, homeFragment)
                .commit();

        bottomNavigationView = findViewById(R.id.bottomView);
        bottomNavigationView.setOnItemSelectedListener(this);
    }


    //初始化底部栏
    private void initTab() {
        Log.d(TAG, "initTab");

//        if (activityMainBinding != null) {
//            if (activityMainBinding.bottomView == null) {
//                Log.e(TAG, "bottomNavigationView is null");
//            } else {
//                activityMainBinding.bottomView.setOnItemSelectedListener(this);
//                Log.d(TAG, "bottomNavigationView initialized");
//            }
//        }

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
}
