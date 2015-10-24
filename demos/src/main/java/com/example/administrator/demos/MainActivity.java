package com.example.administrator.demos;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    static final String[] names={"ValueAnimatorTest测试","零售终端的可回收菜单测试（上下）"};
    public static final Class[] activities={ValueAnimatorTest.class,SaleCustomerMenuTest.class};
    private Context context =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView list=new ListView(this);
        list.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return names.length;
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
                    ((TextView) convertView).setTextSize(20);
                    ((TextView) convertView).setGravity(Gravity.CENTER);
                }
                ((TextView) convertView).setText(names[position]);

                return convertView;
            }
        });
        setContentView(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   Intent intent =new Intent(context,activities[position]);
                startActivity(intent);

            }
        });


    }

}
