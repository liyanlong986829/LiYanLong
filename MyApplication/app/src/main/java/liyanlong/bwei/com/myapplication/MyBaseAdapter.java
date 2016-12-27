package liyanlong.bwei.com.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/27.
 */


public class MyBaseAdapter extends BaseAdapter {
    ArrayList<String> list;
    Context context;
    boolean flag;

    public MyBaseAdapter(ArrayList<String> list, Context context, boolean flag) {
        this.context = context;
        this.list = list;
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public  void setFlag(boolean flag) {
       this.flag = flag;
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
        view = View.inflate(context,R.layout.layout_base,null);
        TextView v = (TextView) view.findViewById(R.id.tv);
        v.setText(list.get(i));
        if(flag == true){
            v.setTextColor(Color.parseColor("#ffffff"));
        }else
            v.setTextColor(Color.parseColor("#000000"));
        return view;
    }
}
