package liyanlong.bwei.com.newstop.readjson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/12/29.
 */

public class ReadJson {
    public static String read(InputStream in){
        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        byte[] bt=new byte[1024];
        int lenth;
        try {
            while((lenth=in.read(bt))!=-1){
                stream.write(bt,0,lenth);
            }
            String str=stream.toString();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
