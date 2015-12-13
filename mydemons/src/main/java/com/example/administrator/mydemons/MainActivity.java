package com.example.administrator.mydemons;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {
    Context context=this;
    private Object[][] items={
            {"相册",MyAlbumActivity.class}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = new ListView(this);
        setContentView(listView);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"hhhhh",Toast.LENGTH_LONG).show();
        Intent intent =new Intent(this,(Class)items[position][1]);
        startActivity(intent);
    }

    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return items.length;
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
            if(convertView==null){
                convertView= new TextView(context);
                ((TextView) convertView).setGravity(Gravity.CENTER);
                ((TextView) convertView).setTextSize(20);
            }
            ((TextView) convertView).setText((String)items[position][0]);

            return convertView;
        }
    }
}
