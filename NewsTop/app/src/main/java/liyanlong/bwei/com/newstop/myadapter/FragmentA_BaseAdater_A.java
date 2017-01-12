package liyanlong.bwei.com.newstop.myadapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;

import java.util.ArrayList;

import liyanlong.bwei.com.newstop.R;
import liyanlong.bwei.com.newstop.bean.FragmentA_MyBean;

/**
 * Created by Administrator on 2016/12/28.
 */
public class FragmentA_BaseAdater_A extends BaseAdapter {

    private ArrayList<FragmentA_MyBean> list;
    private Context text;
    private boolean flag;

    public FragmentA_BaseAdater_A(boolean flag,ArrayList<FragmentA_MyBean> list, Context text) {
        this.list = list;
        this.text = text;
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag() {
        return flag;
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

        ViewHolder holder=null;
        if(view == null){
            view = View.inflate(text, R.layout.fragment_a_base,null);
            holder = new ViewHolder();
            holder.title = (TextView) view.findViewById(R.id.fragment_a_base_title);
            holder.digest = (TextView) view.findViewById(R.id.fragment_a_base_digest);
            holder.ptime = (TextView) view.findViewById(R.id.fragment_a_base_ptime);
            holder.imgsrc = (ImageView) view.findViewById(R.id.fragment_a_base_imgsrc);
            holder.imgsrca = (ImageView) view.findViewById(R.id.fragment_a_base_imgsrc_a);
            holder.imgsrcb = (ImageView) view.findViewById(R.id.fragment_a_base_imgsrc_b);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }



        FragmentA_MyBean myBean2 = list.get(i);

            holder.title.setText(myBean2.title);
            holder.digest.setText(myBean2.digest);
            holder.ptime.setText(myBean2.ptime);
            ImageLoader.getInstance().displayImage(myBean2.imgsrc,holder.imgsrc);

            if(myBean2.imgextra!=null&&myBean2.imgextra.size()==2){
                ImageLoader.getInstance().displayImage(myBean2.imgextra.get(0).imgsrc,holder.imgsrca);
                ImageLoader.getInstance().displayImage(myBean2.imgextra.get(1).imgsrc,holder.imgsrcb);
            }
           if(flag == true){
               holder.title.setTextColor(Color.parseColor("#ffffff"));
               holder.digest.setTextColor(Color.parseColor("#ffffff"));
               holder.ptime.setTextColor(Color.parseColor("#ffffff"));
           }else {
               holder.title.setTextColor(Color.parseColor("#000000"));
               holder.digest.setTextColor(Color.parseColor("#000000"));
               holder.ptime.setTextColor(Color.parseColor("#000000"));
           }
        return view;
    }
    class ViewHolder{
        TextView title,digest,ptime;
        ImageView imgsrc,imgsrca,imgsrcb;
    }
}
