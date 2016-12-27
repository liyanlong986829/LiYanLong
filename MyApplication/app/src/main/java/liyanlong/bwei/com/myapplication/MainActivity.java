package liyanlong.bwei.com.myapplication;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listview;
    private ImageView im;
    private boolean flag = false;

    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private MyBaseAdapter myBaseAdapter;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.listView);
        im = (ImageView) findViewById(R.id.iv);
        sp = this.getSharedPreferences("sp",MODE_PRIVATE);
        view = findViewById(R.id.activity_main);
        edit = sp.edit();
        add_dd();
        im_on();
       }

    private void im_on() {
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(flag == true){
                    flag = false;
                    im.setImageResource(R.drawable.q);
                    set_ll(flag);
                    myBaseAdapter.setFlag(flag);
                    listview.setDivider(new ColorDrawable(Color.BLACK));
                    listview.setDividerHeight(1);
                    myBaseAdapter.notifyDataSetChanged();
                } else {
                    flag = true;
                    im.setImageResource(R.drawable.w);
                    set_ll(flag);
                    myBaseAdapter.setFlag(flag);
                    listview.setDivider(new ColorDrawable(Color.WHITE));
                    listview.setDividerHeight(1);
                    myBaseAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void add_dd() {
        ArrayList<String> list = new ArrayList<>();

        for (int i=0;i<50;i++){

            list.add("当前数据是"+i);
        }
        myBaseAdapter = new MyBaseAdapter(list, this,flag);
        listview.setAdapter(myBaseAdapter);
    }

    private void set_ll(boolean dd){
            if(dd == true) {
                view.setBackgroundColor(Color.BLACK);
            }else {
                view.setBackgroundColor(Color.WHITE);
            }
        }

    }


