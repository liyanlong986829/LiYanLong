package com.bawei.liyanlong.adapter;

import java.util.ArrayList;

import com.bawei.liyanlong.R;
import com.bawei.liyanlong.bean.Bean_B;
import com.bawei.liyanlong.bean.MyBean;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyBaseAdapter extends BaseAdapter {
	
    private Context context;
    private ArrayList<Bean_B> list=new MyBean().data.get(2).notice;
    
	public MyBaseAdapter(ArrayList<Bean_B> list, Context context) {
		super();
		this.list = list;
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View view, ViewGroup arg2) {
		Viewholder holder=null;
		if(view==null){
			view=View.inflate(context, R.layout.activity_base, null);
			holder=new Viewholder();
			holder.url=(ImageView) view.findViewById(R.id.im_age);
			holder.categoryTitle=(TextView) view.findViewById(R.id.tv1);
			holder.detectionItem=(TextView) view.findViewById(R.id.tv2);
			view.setTag(holder);
		}else {
			holder=(Viewholder) view.getTag();
		}
		Bean_B bean_B =list.get(arg0);
		holder.categoryTitle.setText(bean_B.noticeDescription);
		holder.detectionItem.setText(bean_B.noticeTitle);
		ImageLoader.getInstance().displayImage(bean_B.url, holder.url);
		return view;
	}
   class Viewholder{
	   TextView categoryTitle,detectionItem;
	   ImageView url;
   }
}
