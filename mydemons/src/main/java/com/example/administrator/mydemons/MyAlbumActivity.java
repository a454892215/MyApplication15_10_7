package com.example.administrator.mydemons;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;

import com.example.administrator.mydemons.utils.LogUtils;



public class MyAlbumActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView=new TextView(this);
        textView.setText("童奥华");
        textView.setTextSize(15);
        setContentView(textView);
        getImages();
    }

    /**
     * 利用ContentProvider扫描手机中的图片，此方法在运行在子线程中
     */
    private void getImages() {
        //显示进度条
      //  mProgressDialog = ProgressDialog.show(this, null, "正在加载...");

        new Thread(new Runnable() {

            @Override
            public void run() {
                Uri mImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                ContentResolver mContentResolver = MyAlbumActivity.this.getContentResolver();

                //只查询jpeg和png的图片
                Cursor mCursor=null;
                try{
                    mCursor  = mContentResolver.query(mImageUri, null,
                            MediaStore.Images.Media.MIME_TYPE + "=? or "
                                    + MediaStore.Images.Media.MIME_TYPE + "=?",
                            new String[] { "image/jpeg", "image/png" }, MediaStore.Images.Media.DATE_MODIFIED);

                }catch (Exception e){

                    LogUtils.e("llpp"+e.toString());
                }


                if(mCursor == null){
                    LogUtils.e("llpp:查询图片的mCursor == null");
                    return;
                }

                while (mCursor.moveToNext()) {
                    //获取图片的路径
                    String path = mCursor.getString(mCursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));
                         LogUtils.i("llpp:图片的路径是:"+path);
                    //获取该图片的父路径名
                  //  String parentName = new File(path).getParentFile().getName();


                    //根据父路径名将图片放入到mGruopMap中
                 /*   if (!mGruopMap.containsKey(parentName)) {
                        List<String> chileList = new ArrayList<String>();
                        chileList.add(path);
                        mGruopMap.put(parentName, chileList);
                    } else {
                        mGruopMap.get(parentName).add(path);
                    }*/
                }

                //通知Handler扫描图片完成
              //  mHandler.sendEmptyMessage(SCAN_OK);
                mCursor.close();
            }
        }).start();

    }


}
