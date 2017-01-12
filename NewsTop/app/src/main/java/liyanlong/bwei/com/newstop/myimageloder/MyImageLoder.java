package liyanlong.bwei.com.newstop.myimageloder;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by Administrator on 2016/12/30.
 */

public class MyImageLoder extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration ilc=ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(ilc);
    }
}
