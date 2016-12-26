package com.bawei.liyanlong;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.bawei.liyanlong.adapter.MyBaseAdapter;
import com.bawei.liyanlong.bean.Bean_B;
import com.bawei.liyanlong.bean.MyBean;
import com.google.gson.Gson;
import com.lidroid.xutils.DbUtils;




public class MyFragment_Activity extends Activity {
	 String path="http://mock.eoapi.cn/success/cjTiF8H7R6Dw4fmRsuUS3H7ZPaVUJzRW";
	private ListView listView;
	private DbUtils create;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.f_activity);
		listView = (ListView) findViewById(R.id.listView);
		ConnectivityManager  manager = (ConnectivityManager)this.getSystemService(this.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		if(networkInfo!=null&&networkInfo.isAvailable()){
			int type = networkInfo.getType();
			if(type==ConnectivityManager.TYPE_WIFI){
              Toast.makeText(this,"当前为wifi", 0).show();
              
			}else
			{
				AlertDialog.Builder builder=new Builder(this);
				builder.setMessage("是否继续访问");
				builder.setPositiveButton("继续",new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

					}
				});
				builder.setPositiveButton("取消",new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
                        finish();
					}
				});
				builder.show();
			}
		}

		create = DbUtils.create(this, "mytable");
		getJson();
	}
	
	
	
	
	private void getJson() {
		new Thread(){
			public void run() {
				try {
					URL url=new URL(path);
					HttpURLConnection connection=(HttpURLConnection) url.openConnection();
					
					if(connection.getResponseCode()==200){
						InputStream in= connection.getInputStream();
						ByteArrayOutputStream stream=new ByteArrayOutputStream();
						int lenth=0;
						byte[] bs=new byte[1024];
						while((lenth=in.read(bs))!=-1){
							stream.write(bs, 0, lenth);
						}
						
						  MyBean bean = new Gson().fromJson(stream.toString(), MyBean.class);
						  final ArrayList<Bean_B> list=bean.data.get(2).notice;
						  create.saveAll(list);
						  runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
                                	listView.setAdapter(new MyBaseAdapter(list, MyFragment_Activity.this));					
							}
						});
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
		}.start();
		
	}
	
}
