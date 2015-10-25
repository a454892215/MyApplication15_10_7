package com.example.administrator.mydemo151025;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    Context context = this;
    private ListView listView;
    private TextView tv_down_up;
    private LinearLayout head;
    private ValueAnimator valueAnimator_open;
    private ValueAnimator valueAnimator_close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sale_customer_menu_test);
        listView = (ListView) findViewById(R.id.listView);
        tv_down_up = (TextView) findViewById(R.id.tv_down_up);
        head = (LinearLayout) findViewById(R.id.head);

        listView.setAdapter(new MyAdapter());
        //测量头的高度
        head.measure(0, 0);
        int head_height = head.getMeasuredHeight();
        //测量脚的高度
        tv_down_up.measure(0, 0);
        int tv_down_up_hieght = tv_down_up.getMeasuredHeight();
        // System.out.println("llpp:head.getHeight:" + head.getHeight());
        // System.out.println("llpp:tv_down_up.getHeight:" + tv_down_up.getHeight());

        //  Toast.makeText(context,"llpp:head.measuredHeight:" +measuredHeight,Toast.LENGTH_LONG).show();
        valueAnimator_open = ValueAnimator.ofInt(0, head_height);
        valueAnimator_open.setDuration(250);
        valueAnimator_open.setInterpolator(new DecelerateInterpolator());
        valueAnimator_open.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer animatedValue = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = head.getLayoutParams();
                layoutParams.height = animatedValue;
                head.setLayoutParams(layoutParams);
            }
        });

        valueAnimator_close = ValueAnimator.ofInt(head_height,0);
        valueAnimator_close.setDuration(250);
        valueAnimator_close.setInterpolator(new DecelerateInterpolator());
        valueAnimator_close.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Integer animatedValue = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = head.getLayoutParams();
                layoutParams.height = animatedValue;
                head.setLayoutParams(layoutParams);
            }
        });
    }
     boolean isClose=true;
    public void click(View view) {
     if(isClose){
         isClose=false;
         valueAnimator_close.start();

     }else{
         isClose=true;
        valueAnimator_open.start();
     }

    }

    @Override
    protected void onResume() {

        super.onResume();
        //  head.measure(0, 0);
        //  int measuredHeight = head.getMeasuredHeight();

        // System.out.println("llpp:head.getHeight:" + head.getHeight());
        // System.out.println("llpp:tv_down_up.getHeight:" + tv_down_up.getHeight());

        //  Toast.makeText(context,"llpp:head.measuredHeight:" +measuredHeight,Toast.LENGTH_LONG).show();

    }

    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = new TextView(context);

            }
            ((TextView) convertView).setText("hahaha" + position);
            ((TextView) convertView).setGravity(Gravity.CENTER);
            ((TextView) convertView).setTextSize(30);
            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
