package readjson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import bean.MyBean;

/**
 * Created by Administrator on 2016/12/11.
 */

public class ReadJson {
    public static ArrayList<MyBean> read(InputStream in){
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        int leth=0;
        byte[] bs=new byte[1024];
        try {
            while ((leth=in.read(bs))!=-1){
                outputStream.write(bs,0,leth);
            }
            JSONObject object=new JSONObject(outputStream.toString());
            JSONArray json = object.optJSONArray("result");
            ArrayList<MyBean>  list=new Gson().fromJson(json.toString(),new TypeToken<ArrayList<MyBean>>(){}.getType());
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
