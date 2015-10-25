package com.example.administrator.demos;

import android.animation.ValueAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class ValueAnimatorActivity extends ActionBarActivity {
    ValueAnimator valueAnimator;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator_test);
        textView = (TextView)findViewById(R.id.text);


         valueAnimator=ValueAnimator.ofInt(0, 100);
         valueAnimator.setDuration(5000);
         valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer  value = (Integer) animation.getAnimatedValue();
                textView.setHeight(value);
                textView.setWidth(value);
            }
        });
    }

     public void click( View view){
         valueAnimator.start();


     }

}
