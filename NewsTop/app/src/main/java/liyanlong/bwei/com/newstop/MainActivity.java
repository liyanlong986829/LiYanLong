package liyanlong.bwei.com.newstop;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import liyanlong.bwei.com.newstop.fragment.MyFagment_A;
import liyanlong.bwei.com.newstop.fragment.MyFagment_B;
import liyanlong.bwei.com.newstop.fragment.MyFagment_C;
import liyanlong.bwei.com.newstop.fragment.MyFagment_D;


public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private ImageView t1, t2, t3, t4;
    private TextView tv1, tv2, tv3, tv4;
    private Fragment fragment_a, fragment_b, fragment_c, fragment_d;
    private boolean flag;
    private FragmentTransaction ddtion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tion = manager.beginTransaction();
        fragment_a = new MyFagment_A();
        tion.add(R.id.ll, fragment_a).show(fragment_a).commit();
        fromFragment(flag);


    }

    /*   //添加4个fragment
       private void add_FragmentMessage() {

           fragment_a=new MyFagment_A();
           fragment_b=new MyFagment_B();
           fragment_c=new MyFagment_C();
           fragment_d=new MyFagment_D();
           FragmentManager manager = getSupportFragmentManager();
           FragmentTransaction tion = manager.beginTransaction();

           tion.add(R.id.ll, fragment_a).show(fragment_a).
                   add(R.id.ll,fragment_b).hide(fragment_b).
                   add(R.id.ll,fragment_c).hide(fragment_c).
                   add(R.id.ll,fragment_d).hide(fragment_d);
                   tion.commit();
       }*/
    //初始化控件及监听
    private void initview() {
        t1 = (ImageView) findViewById(R.id.t1);
        t2 = (ImageView) findViewById(R.id.t2);
        t3 = (ImageView) findViewById(R.id.t3);
        t4 = (ImageView) findViewById(R.id.t4);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv4 = (TextView) findViewById(R.id.tv4);

        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
        t4.setOnClickListener(this);

    }

    //图片的事件监听
    @Override
    public void onClick(View view) {
        //创建出来事物
        ddtion = getSupportFragmentManager().beginTransaction();
        //调用方法隐藏所有的fragment
        hide_Fragment(ddtion);
        switch (view.getId()) {
            //点击某个fragment显示
            case R.id.t1:
                t1.setImageResource(R.drawable.b_newhome_tabbar_press);
                t2.setImageResource(R.drawable.b_newvideo_tabbar);
                t3.setImageResource(R.drawable.b_newcare_tabbar);
                t4.setImageResource(R.drawable.b_newmine_tabbar);
                tv1.setTextColor(Color.parseColor("#8B5742"));
                tv2.setTextColor(Color.parseColor("#838B83"));
                tv3.setTextColor(Color.parseColor("#838B83"));
                tv4.setTextColor(Color.parseColor("#838B83"));

                //替换显示为Fragment
                if (fragment_a != null) {
                    ddtion.show(fragment_a);
                }


                break;
            case R.id.t2:
                tv2.setTextColor(Color.parseColor("#8B5742"));
                tv3.setTextColor(Color.parseColor("#838B83"));
                tv4.setTextColor(Color.parseColor("#838B83"));
                tv1.setTextColor(Color.parseColor("#838B83"));
                t2.setImageResource(R.drawable.b_newvideo_tabbar_press);
                t1.setImageResource(R.drawable.b_newhome_tabbar);
                t3.setImageResource(R.drawable.b_newcare_tabbar);
                t4.setImageResource(R.drawable.b_newmine_tabbar);
                if (fragment_b == null) {
                    fragment_b = new MyFagment_B();
                    ddtion.add(R.id.ll, fragment_b);
                } else {
                    ddtion.show(fragment_b);
                }

                break;
            case R.id.t3:

                tv3.setTextColor(Color.parseColor("#8B5742"));
                tv2.setTextColor(Color.parseColor("#838B83"));
                tv4.setTextColor(Color.parseColor("#838B83"));
                tv1.setTextColor(Color.parseColor("#838B83"));
                t3.setImageResource(R.drawable.b_newcare_tabbar_press);
                t1.setImageResource(R.drawable.b_newhome_tabbar);
                t2.setImageResource(R.drawable.b_newvideo_tabbar);
                t4.setImageResource(R.drawable.b_newmine_tabbar);


                if (fragment_c == null) {
                    fragment_c = new MyFagment_C();
                    ddtion.add(R.id.ll, fragment_c);
                } else {
                    ddtion.show(fragment_c);
                }

                break;
            case R.id.t4:

                tv4.setTextColor(Color.parseColor("#8B5742"));
                tv3.setTextColor(Color.parseColor("#838B83"));
                tv2.setTextColor(Color.parseColor("#838B83"));
                tv1.setTextColor(Color.parseColor("#838B83"));
                t4.setImageResource(R.drawable.b_newmine_tabbar_press);
                t3.setImageResource(R.drawable.b_newcare_tabbar);
                t1.setImageResource(R.drawable.b_newhome_tabbar);
                t2.setImageResource(R.drawable.b_newvideo_tabbar);


                if (fragment_d == null) {
                    fragment_d = new MyFagment_D();
                    ddtion.add(R.id.ll, fragment_d);
                } else {
                    ddtion.show(fragment_d);
                }

                break;
        }
        //提交
        ddtion.commit();
    }

    //隐藏所有fragment的方法
    private void hide_Fragment(FragmentTransaction fragmentTransaction) {
        if (fragment_a != null) {
            fragmentTransaction.hide(fragment_a);
        }
        if (fragment_b != null) {
            fragmentTransaction.hide(fragment_b);
        }
        if (fragment_c != null) {
            fragmentTransaction.hide(fragment_c);
        }
        if (fragment_d != null) {
            fragmentTransaction.hide(fragment_d);
        }
    }


    //让Fragment_D调用的方法用来传递是否为夜间模式
    public void fromFragment(boolean b) {
        flag = b;

        ((MyFagment_A) fragment_a).fromFragment_A(flag);

        Log.d("Log", flag + "Main____BBBBBB");
        if (b == true) {
            //夜间模式
            View view = findViewById(R.id.main_ll);
            view.setBackgroundColor(Color.parseColor("#4D4D4D"));
        } else {
            //日间模式
            View view = findViewById(R.id.main_ll);
            view.setBackgroundColor(Color.parseColor("#D9D9D9"));
        }

    }


}
