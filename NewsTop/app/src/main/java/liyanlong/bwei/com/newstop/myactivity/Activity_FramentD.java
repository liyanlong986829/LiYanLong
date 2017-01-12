package liyanlong.bwei.com.newstop.myactivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import liyanlong.bwei.com.newstop.R;

/**
 * Created by Administrator on 2017/1/3.
 */

public class Activity_FramentD extends Activity implements View.OnClickListener {
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,16}$";
    private TextView shortTxt, longTxt, text, txtOpenOrClose, window_tv;
    private LinearLayout linearLayout;
    //是否初始化，防止无限制的判断信息是否过长
    private boolean isInit = false, m = true, mm = true, mmm = true;
    private static final String CLOSE = "▲查看全部";
    private static final String OPEN = "▽收起全部";
    private EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragmentd);
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
        initViews();

    }

    private void initViews() {
        user = (EditText) findViewById(R.id.user);
        //setEditText(user);
        password = (EditText) findViewById(R.id.password);
        // setEditText(password);
        linearLayout = (LinearLayout) findViewById(R.id.id_linearLayout);
        shortTxt = (TextView) findViewById(R.id.id_textview);
        longTxt = (TextView) findViewById(R.id.id_textview2);
        text = (TextView) findViewById(R.id.id_textview3);
        txtOpenOrClose = (TextView) findViewById(R.id.id_openOrClose);
        Button bt = (Button) findViewById(R.id.login);
        txtOpenOrClose.setOnClickListener(this);
        shortTxt.setOnClickListener(this);
        text.setOnClickListener(this);
        longTxt.setOnClickListener(this);
        bt.setOnClickListener(this);

        //添加回调方法，此方法在每次绘制视图的时候回调，如点击展开时就会调用此方法。
        ViewTreeObserver observer = linearLayout.getViewTreeObserver();
        observer.addOnPreDrawListener(onPreDrawListener);
    }

    /**
     * 视图绘制回调方法
     */
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener = new ViewTreeObserver.OnPreDrawListener() {

        @Override
        public boolean onPreDraw() {
            // TODO Auto-generated method stub
            //如果已经初始化布局，则不执行后面的方法
            if (isInit) {
                return true;
            }
            isInit = true;
            return true;
        }
    };

    /**
     * 单击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.id_openOrClose:
                //如果显示的是 展开
                if (txtOpenOrClose.getText().equals(OPEN)) {
                    //修改为 收起
                    txtOpenOrClose.setText(CLOSE);
                    //隐藏短文字的文本框
                    shortTxt.setVisibility(View.GONE);
                    longTxt.setVisibility(View.GONE);
                    text.setVisibility(View.GONE);
                } else if (txtOpenOrClose.getText().equals(CLOSE)) {
                    txtOpenOrClose.setText(OPEN);
                    shortTxt.setVisibility(View.VISIBLE);
                    longTxt.setVisibility(View.VISIBLE);
                    text.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.id_textview:
                if (m == true) {
                    m = false;
                    shortTxt.setText("▽访问你的腾讯微博资料");
                } else if (m == false) {
                    m = true;
                    shortTxt.setText("▲访问你的腾讯微博资料");
                }
                break;
            case R.id.id_textview2:
                if (mm == true) {
                    mm = false;
                    longTxt.setText("▽分享内容到腾讯微博");
                } else if (mm == false) {
                    mm = true;
                    longTxt.setText("▲分享内容到腾讯微博");
                }
                break;
            case R.id.id_textview3:
                if (mmm == true) {
                    mmm = false;
                    text.setText("▽获得您的微博好友信息");
                } else if (mmm == false) {
                    mmm = true;
                    text.setText("▲获得您的微博好友信息");
                }
                break;
            case R.id.login:
                String str_user = user.getText().toString();
                String str_password = password.getText().toString();

                //给账号设置指定的类型
                Pattern p = Pattern.compile("[1-9][0-9]{4,12}");
                Matcher m_user = p.matcher(str_user);

                //给密码设置指定的类型
                Pattern pp = Pattern.compile("^[a-zA-Z0-9]{6,16}$");
                Matcher m_password_p = pp.matcher(str_password);

                if (m_user.matches()&&m_password_p.matches()) {
                   Toast.makeText(Activity_FramentD.this, "输入sssssssssssssssss的是数字", Toast.LENGTH_SHORT).show();
                 } else {
                     showPopwindow("请输入正确的账号或密码");
                }


        break;
        }
        }

    /**
     * 显示popupWindow
     */
    private void showPopwindow(String sss) {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(this.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.popwindowlayout, null);
        window_tv = (TextView) view.findViewById(R.id.wind_tv);

        window_tv.setText(sss);
        window_tv.setTextColor(Color.parseColor("#000000"));

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0xb0000000);
        window.setBackgroundDrawable(dw);


        // 设置popWindow的显示和消失动画
        // window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAtLocation(Activity_FramentD.this.findViewById(R.id.frament_acrivity),
                Gravity.HORIZONTAL_GRAVITY_MASK, 300, 20);
    }

    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }
}