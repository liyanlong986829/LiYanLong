package my_adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bean.MyBean;
import gongjiaochaxun.liyanlong.com.day_0372gongjiao.R;

/**
 * Created by Administrator on 2016/12/11.
 */

public class MyAdapter extends BaseAdapter {
    private ArrayList<MyBean> list;
    private Context cotext;

    public MyAdapter(ArrayList<MyBean> list, Context cotext) {
        this.list = list;
        this.cotext = cotext;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHoder hoder=null;
        if(view==null){
            view=View.inflate(cotext, R.layout.baseadapter,null);
            hoder=new ViewHoder();
            hoder.company= (TextView) view.findViewById(R.id.company);
            hoder.name_1= (TextView) view.findViewById(R.id.name_1);
            hoder.front_name= (TextView) view.findViewById(R.id.front_name);
            hoder.terminal_name= (TextView) view.findViewById(R.id.terminal_name);
            hoder.stationNum= (TextView) view.findViewById(R.id.stationNum);
            hoder.name= (TextView) view.findViewById(R.id.name);
            view.setTag(hoder);
        }else {
            hoder = (ViewHoder) view.getTag();
        }
        MyBean bean = list.get(i);
        hoder.company.setText("公交公司名称："+bean.company);
        hoder.name_1.setText("公交路线及公交车编码："+bean.name_1);
        hoder.front_name.setText("启动站："+bean.front_name);
        hoder.terminal_name.setText("终点站："+bean.terminal_name);

            hoder.stationNum.setText("当前站数："+bean.stationdes.get(0).stationNum);
            hoder.name.setText("当前站名："+bean.stationdes.get(0).name);
            hoder.stationNum.setText("当前站数："+bean.stationdes.get(1).stationNum);
            hoder.name.setText("当前站名："+bean.stationdes.get(1).name);



        return view;
    }
    class ViewHoder{
        TextView name_1,front_name,terminal_name,company;
        TextView name,stationNum;
    }
}
