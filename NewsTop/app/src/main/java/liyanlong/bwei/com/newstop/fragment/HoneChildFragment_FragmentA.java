package liyanlong.bwei.com.newstop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import liyanlong.bwei.com.newstop.R;
import liyanlong.bwei.com.newstop.bean.FragmentA_MyBean;
import liyanlong.bwei.com.newstop.myadapter.FragmentA_BaseAdater_A;

/**
 * Created by Administrator on 2016/12/30.
 */

public class HoneChildFragment_FragmentA extends Fragment {

    private View view;
    private boolean flag;
    private FragmentA_BaseAdater_A adater_a;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.honchildfragment_fragmenta,container,false);
        fromHoneChildFragment_FragmentA(flag);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) getArguments().getSerializable("list");
        ListView listView = (ListView) view.findViewById(R.id.honchild_listview);

        for(int i=0;i<list.size();i++){
            if(list.get(i).source.equals("网易原创")){
                adater_a = new FragmentA_BaseAdater_A(flag, list, getActivity());
                listView.setAdapter(adater_a);

                if (flag == true){
                    adater_a.setFlag(flag);
                }else {
                    adater_a.setFlag(flag);
                }
            }else if(list.get(i).source.equals("网易体育")){
                listView.setAdapter(new FragmentA_BaseAdater_A(flag,list,getActivity()));
                if (flag == true){
                    adater_a.setFlag(flag);
                }else {
                    adater_a.setFlag(flag);
                }
            }else if(list.get(i).source.equals("扬子晚报")){
                listView.setAdapter(new FragmentA_BaseAdater_A(flag,list,getActivity()));
            }else if(list.get(i).source.equals("KEWELL25")){
                listView.setAdapter(new FragmentA_BaseAdater_A(flag,list,getActivity()));
            }else if(list.get(i).source.equals("君子好逑")){
                listView.setAdapter(new FragmentA_BaseAdater_A(flag,list,getActivity()));
            }else if(list.get(i).source.equals("肆客足球")){
                listView.setAdapter(new FragmentA_BaseAdater_A(flag,list,getActivity()));
            }
        }


    }
    //让Fragment_A调用的方法用来传递是否为夜间模式
    public void fromHoneChildFragment_FragmentA(boolean b){
        flag = b;

    }
}
