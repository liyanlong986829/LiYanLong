package liyanlong.bwei.com.newstop.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.tauth.IUiListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import org.json.JSONObject;
import java.util.ArrayList;
import liyanlong.bwei.com.newstop.MainActivity;
import liyanlong.bwei.com.newstop.R;
import liyanlong.bwei.com.newstop.myadapter.MyBaseAdater;

/**
 * Created by Administrator on 2016/12/28.
 */

public class MyFagment_D extends Fragment implements View.OnClickListener {

    private ImageView view_a, view_b, view_c, view_dd, view_e, view_f, view_g;
    private TextView tv_e, tv_ff, tv_g, base_tv_a;
    private ListView listview;
    private boolean flag = false;
    private MainActivity mainActivity;
    private View view;
    private MyBaseAdater myBaseAdater;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private Tencent mtencent;
    private String APP_ID="1105924500";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_d, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //得到Mainactivity对象
        mainActivity = (MainActivity) getActivity();

        //创建出来SharedPreferences
        sp = getActivity().getSharedPreferences("sp", Context.MODE_PRIVATE);
        edit = sp.edit();
        //调用初始化控件方法
        initview();

    }

    //初始化控件方法
    private void initview() {
        view_a = (ImageView) view.findViewById(R.id.view_a);
        view_b = (ImageView) view.findViewById(R.id.view_b);
        view_c = (ImageView) view.findViewById(R.id.view_c);
        view_dd = (ImageView) view.findViewById(R.id.view_d);
        view_e = (ImageView) view.findViewById(R.id.view_e);
        view_f = (ImageView) view.findViewById(R.id.view_f);
        view_g = (ImageView) view.findViewById(R.id.view_g);
        tv_e = (TextView) view.findViewById(R.id.tv_e);
        tv_ff = (TextView) view.findViewById(R.id.tv_f);
        tv_g = (TextView) view.findViewById(R.id.tv_g);
        base_tv_a = (TextView) view.findViewById(R.id.base_tv_a);
        listview = (ListView) view.findViewById(R.id.listview);
        //给listview添加数据
        add_list();
        //判断当前是不是夜间模式状态
        if (sp.getBoolean("boo", true)) nightMode();
        //给夜间模式的图片添加监听
        view_f.setOnClickListener(this);
        view_b.setOnClickListener(this);


    }


    //添加数据
    private void add_list() {
        ArrayList<String> list = new ArrayList<>();
        list.add("消息通知");
        list.add("活动   ");
        list.add("头条商城");
        list.add("京东特卖");
        list.add("我要爆料");
        list.add("用户反馈");
        myBaseAdater = new MyBaseAdater(flag, list, getActivity());
        listview.setAdapter(myBaseAdater);
    }


    // 监听日间和夜间模式的方法
    private void OnClick(boolean flag) {
        if (flag == false) {
            //日间模式
            view.setBackgroundColor(Color.parseColor("#ffffff"));
            view_a.setImageResource(R.drawable.cellphoneicon_login_profile_normal);
            view_b.setImageResource(R.drawable.qq_allshare_normal);
            view_c.setImageResource(R.drawable.sinaicon_login_profile_normal);
            view_e.setImageResource(R.drawable.love_jokebar_textpage_normal);
            view_f.setImageResource(R.drawable.nighticon_leftdrawer_normal_night);
            view_g.setImageResource(R.drawable.settingicon_leftdrawer_normal_night);
            tv_e.setTextColor(Color.parseColor("#000000"));
            tv_ff.setTextColor(Color.parseColor("#000000"));
            tv_g.setTextColor(Color.parseColor("#000000"));
            base_tv_a.setBackgroundColor(Color.parseColor("#EAEAEA"));
            mainActivity.fromFragment(flag);
            myBaseAdater.setFlag(flag);
            listview.setDivider(new ColorDrawable(Color.BLACK));
            listview.setDividerHeight(1);
            myBaseAdater.notifyDataSetChanged();
            edit.putBoolean("boo", flag);
            edit.commit();
        } else {
            //调用夜间模式方法
            nightMode();
        }


    }

    //夜间模式
    private void nightMode() {
        view_a.setImageResource(R.drawable.cellphoneicon_login_profile_pressed);
        view_b.setImageResource(R.drawable.qqicon_login_profile_press);
        view_c.setImageResource(R.drawable.sinaicon_login_profile_pressed);
        view.setBackgroundColor(Color.parseColor("#4D4D4D"));
        view_e.setImageResource(R.drawable.love_jokebar_textpage_selected_normal_night);
        view_f.setImageResource(R.drawable.nighticon_leftdrawer_pressed);
        view_g.setImageResource(R.drawable.settingicon_leftdrawer_normal);
        tv_e.setTextColor(Color.parseColor("#ffffff"));
        tv_ff.setTextColor(Color.parseColor("#ffffff"));
        tv_g.setTextColor(Color.parseColor("#ffffff"));
        base_tv_a.setBackgroundColor(Color.parseColor("#4D4D4D"));
        //调用Activity的回调方法
        mainActivity.fromFragment(flag);
        //更改适配器的boolean值
        myBaseAdater.setFlag(flag);
        //设置listview边线的颜色
        listview.setDivider(new ColorDrawable(Color.WHITE));
        //设置listview边线的高度
        listview.setDividerHeight(1);
        //适配器刷新
        myBaseAdater.notifyDataSetChanged();
        //保存状态并提交
        edit.putBoolean("boo", flag).commit();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.view_f:
                // 判断更改boolean类型的值
                if (flag == true) {
                    flag = false;
                    // 调用日间和夜间模式的方法
                    OnClick(flag);
                } else {
                    flag = true;
                    // 调用日间和夜间模式的方法
                    OnClick(flag);
                }
                break;
            case R.id.view_b:
                /*Intent intent = new Intent(getActivity(), Activity_FramentD.class);
                startActivity(intent);*/
                mtencent=Tencent.createInstance(APP_ID,getActivity());
                view_b.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        // TODO Auto-generated method stub
                        //调用Tencent里面的登录方法
                        mtencent.login(getActivity(), "All", loginListener);
                    }
                });
                break;
        }
    }
    //实例化BaseUiListener
    IUiListener loginListener = new BaseUiListener() {
        @Override
        protected void doComplete(JSONObject values) {
            Log.d("SDKQQAgentPref", "AuthorSwitch_SDK:" + SystemClock.elapsedRealtime());
        }
    };

    /**
     *  第三方登录内部类实现IUiListener接口
     */

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {

            doComplete((JSONObject)response);
        }

        protected void doComplete(JSONObject values) {
            Log.i("miaojx",values.toString());
        }

        @Override
        public void onError(UiError e) {
            Log.i("miaojx",e.toString());
        }

        @Override
        public void onCancel() {

        }
    }
    @Override//重写Activity里面的onActivityResult方法
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode,resultCode,data,loginListener);
    }
}
