package bean;

import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/11.
 */

public class MyBean {

  public String  name_1,front_name,terminal_name,company;
  public ArrayList<MyBean_A> stationdes;
    public static class MyBean_A{
        public String  name,stationNum;
    }

}
