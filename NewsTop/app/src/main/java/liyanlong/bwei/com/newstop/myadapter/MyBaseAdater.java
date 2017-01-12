package liyanlong.bwei.com.newstop.myadapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import liyanlong.bwei.com.newstop.R;
import liyanlong.bwei.com.newstop.bean.MyBean;

/**
 * Created by Administrator on 2016/12/28.
 */
public class MyBaseAdater extends BaseAdapter {
    private ArrayList<String> list;
    private Context text;
    private boolean flag;
    public MyBaseAdater(boolean flag,ArrayList<String> list, Context text) {
        this.list = list;
        this.text = text;
        this.flag=flag;
    }
    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
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
        view=View.inflate(text, R.layout.base,null);
        TextView tv= (TextView) view.findViewById(R.id.base_tv);
        tv.setText(list.get(i));
        if(flag == false){
            tv.setTextColor(Color.parseColor("#000000"));
        }else
            tv.setTextColor(Color.parseColor("#ffffff"));
        return view;
    }
}
