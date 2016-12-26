package mysacytasc;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import bean.MyBean;
import my_adapter.MyAdapter;
import readjson.ReadJson;

/**
 * Created by Administrator on 2016/12/11.
 */

public class Mysayntasc extends AsyncTask<String,Void,ArrayList<MyBean>> {
    private ListView listview;
    private Context cotext;

    public Mysayntasc(ListView listview, Context cotext) {
        this.listview = listview;
        this.cotext = cotext;
    }

    @Override
    protected ArrayList<MyBean> doInBackground(String... strings) {
        String str=strings[0];
        ArrayList<MyBean> json = getJson(str);
        return json;
    }
    public ArrayList<MyBean> getJson(String str){
        try {
            URL url=new URL(str);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(3000);
           if(connection.getResponseCode()==200){
               InputStream inputStream = connection.getInputStream();
               ArrayList<MyBean> read = ReadJson.read(inputStream);
               return read;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(ArrayList<MyBean> list) {
        super.onPostExecute(list);
        listview.setAdapter(new MyAdapter(list,cotext));
    }




}
