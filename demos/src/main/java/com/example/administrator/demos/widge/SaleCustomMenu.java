package com.example.administrator.demos.widge;

import android.content.Context;

import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Administrator on 2015/10/24.
 */
public class SaleCustomMenu  extends FrameLayout{
    public SaleCustomMenu(Context context) {
        this(context, null);
    }

    public SaleCustomMenu(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SaleCustomMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ViewDragHelper.create(this, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return false;
            }

            @Override
            public int clampViewPositionVertical(View child, int top, int dy) {
                return super.clampViewPositionVertical(child, top, dy);
            }
        });


    }


}
