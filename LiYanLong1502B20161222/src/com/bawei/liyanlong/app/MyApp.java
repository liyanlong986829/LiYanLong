package com.bawei.liyanlong.app;

import utils.CommenUtil;

import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import android.app.Application;
import android.content.Context;
/**
 *         2016/12/22
 * @author Administrator
 * 
 * 
 *  优先运行的ImageLoader类
 *  
 *  
 */

public class MyApp extends Application {
	private Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		
		context=this;
		initImageLoader();
		
	}

	private void initImageLoader() {
		 ImageLoaderConfiguration config = new ImageLoaderConfiguration  
				    .Builder(context)  
				    .memoryCacheExtraOptions(480, 800) 
//				   
				    .threadPoolSize(3)
				    .threadPriority(Thread.NORM_PRIORITY - 2)  
				    .denyCacheImageMultipleSizesInMemory()  
				    .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) 
				    .memoryCacheSize( (int)(Runtime.getRuntime().maxMemory()/8))    
				    .discCacheSize(50 * 1024 * 1024)    
				    .tasksProcessingOrder(QueueProcessingType.LIFO)  
				    .discCacheFileCount(100) 
				    .defaultDisplayImageOptions(DisplayImageOptions.createSimple())  
				    .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) 
				    .writeDebugLogs()  
				    .build(); 
		 
		    
		     ImageLoader.getInstance().init(config);
		    CommenUtil.getOptions();
	}
}
