package liyanlong.bwei.com.newstop.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import liyanlong.bwei.com.newstop.R;
import liyanlong.bwei.com.newstop.bean.FragmentA_MyBean;
import liyanlong.bwei.com.newstop.myadapter.FragmentA_BaseAdater_B;
import liyanlong.bwei.com.newstop.readjson.ReadJson;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MyFagment_A extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private View view;
    private ArrayList<String> list_a = new ArrayList<>();
    private FragmentManager manager;
    private ArrayList<Fragment> fragment_list = new ArrayList<>();
    //private Map<String, ArrayList<ArrayList<Fragment>>> mMap;
    private String path = "https://c.m.163.com/nc/article/list/T1348649079062/0-20.html";
    private String source;
    private boolean flag;
    private ArrayList<FragmentA_MyBean> lis;
    private Handler han = new Handler() {

        @Override
        public void handleMessage(Message msg) {

            //循环遍历拿到Bean类里面的source值
            for (int i = 0; i < lis.size(); i++) {
                source =  lis.get(i).source;

                if(source.equals("网易原创")){
                    ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) msg.obj;
                    HoneChildFragment_FragmentA childFragment = new HoneChildFragment_FragmentA();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list", list);
                    childFragment.setArguments(bundle);
                    fragment_list.add(childFragment);
                    list_a.add(source);
                }else if(source.equals("网易体育")){
                    ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) msg.obj;
                    HoneChildFragment_FragmentA childFragment = new HoneChildFragment_FragmentA();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list", list);
                    childFragment.setArguments(bundle);
                    fragment_list.add(childFragment);
                    list_a.add(source);
                }else if(source.equals("扬子晚报")){
                    ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) msg.obj;
                    HoneChildFragment_FragmentA childFragment = new HoneChildFragment_FragmentA();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list", list);
                    childFragment.setArguments(bundle);
                    fragment_list.add(childFragment);
                    list_a.add(source);
                }else if(source.equals("KEWELL25")){
                    ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) msg.obj;
                    HoneChildFragment_FragmentA childFragment = new HoneChildFragment_FragmentA();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list", list);
                    childFragment.setArguments(bundle);
                    fragment_list.add(childFragment);
                    list_a.add(source);
                }else if(source.equals("君子好逑")){
                    ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) msg.obj;
                    HoneChildFragment_FragmentA childFragment = new HoneChildFragment_FragmentA();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list", list);
                    childFragment.setArguments(bundle);
                    fragment_list.add(childFragment);
                    list_a.add(source);
                }else if(source.equals("肆客足球")){
                    ArrayList<FragmentA_MyBean> list = (ArrayList<FragmentA_MyBean>) msg.obj;
                    HoneChildFragment_FragmentA childFragment = new HoneChildFragment_FragmentA();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("list", list);
                    childFragment.setArguments(bundle);
                    fragment_list.add(childFragment);
                    list_a.add(source);
                }
                }

            //tabLayout设置模式
            tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            //viewpager绑定适配器
            viewpager.setAdapter(new FragmentA_BaseAdater_B(manager, fragment_list, list_a));
            //把tabLayout关联到viewpager
            tabLayout.setupWithViewPager(viewpager);

        }
    };



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);
        if(flag == true){
            //夜间模式
            // View viewa = View.inflate(getActivity(), R.layout.fragment_a,null);
            view.setBackgroundColor(Color.parseColor("#4D4D4D"));
        }else {
            //日间模式
            //View viewa = View.inflate(getActivity(), R.layout.fragment_a,null);
            view.setBackgroundColor(Color.parseColor("#ffffff"));
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  boo = getArguments().getBoolean("main");

        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewpager = (ViewPager) view.findViewById(R.id.fragmenta_viewPager);
        manager = getActivity().getSupportFragmentManager();
        getJson();
        fromFragment_A(flag);

    }


    public void getJson() {

        new Thread() {


            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(3000);
                    if (connection.getResponseCode() == 200) {
                        InputStream input = connection.getInputStream();
                        String read = ReadJson.read(input);
                        JSONObject object = new JSONObject(read);
                        JSONArray array = object.optJSONArray("T1348649079062");
                        lis =  new Gson().fromJson(array.toString(), new TypeToken<ArrayList<FragmentA_MyBean>>() {
                        }.getType());
                        Message message = Message.obtain();
                        message.obj = lis;
                        han.sendMessage(message);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
    //让Fragment_D调用的方法用来传递是否为夜间模式
    public void fromFragment_A(boolean b){
        flag=b;
        new HoneChildFragment_FragmentA().fromHoneChildFragment_FragmentA(flag);
    }

}