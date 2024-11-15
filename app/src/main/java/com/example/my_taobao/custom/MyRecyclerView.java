package com.example.my_taobao.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerView extends RecyclerView {

    private float startX;
    private float startY;
    private int touchSlop = 50;// 设定滑动判断的阈值
    private boolean isAtTop = false; // 标记是否在顶部

    public MyRecyclerView(@NonNull Context context) {
        super(context);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop(); // 使用系统阈值
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // 记录手指按下时的初始 x 和 y 坐标
                startX = e.getX();
                startY = e.getY();
                // 检查是否滑动到顶部
                isAtTop = isAtTop();
                break;

            case MotionEvent.ACTION_MOVE:
                // 获取当前触点的位置
                float endX = e.getX();
                float endY = e.getY();
                float distanceX = Math.abs(endX - startX);
                float distanceY = Math.abs(endY - startY);

                if (distanceY > touchSlop && distanceY > distanceX) {
                    if (endY > startY && isAtTop) {
                        // 向下滑动且在顶部，触发下拉刷新
                        return false; // 不拦截，交给 SwipeRefreshLayout 处理
                    } else if (distanceX > touchSlop && distanceX > distanceY) {
                        // 水平滑动，拦截事件交给 ViewPager2 处理
                        return true;
                    }
                }
                break;
        }
        return super.onInterceptTouchEvent(e);
    }
    // 判断 RecyclerView 是否在顶部
    private boolean isAtTop() {
        if (getLayoutManager() != null && getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager layoutManager = (LinearLayoutManager) getLayoutManager();
            int firstVisiblePosition = layoutManager.findFirstCompletelyVisibleItemPosition();
            return firstVisiblePosition == 0;
        }
        return false;
    }
}
