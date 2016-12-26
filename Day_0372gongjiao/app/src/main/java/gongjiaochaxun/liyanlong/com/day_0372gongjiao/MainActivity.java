package gongjiaochaxun.liyanlong.com.day_0372gongjiao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import mysacytasc.Mysayntasc;


public class MainActivity extends AppCompatActivity {
    private String str="0372";
    private String num="22";
    private String path="http://op.juhe.cn/189/bus/busline?dtype=&city="+str+"&bus="+num+"&key=df111af715a71a4f59161269a2cb6a1e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView= (ListView) findViewById(R.id.listview);
        new Mysayntasc(listView,this).execute(path);

    }
}
