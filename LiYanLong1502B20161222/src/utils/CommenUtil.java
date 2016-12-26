package utils;


import com.bawei.liyanlong.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class CommenUtil {
	public static DisplayImageOptions getOptions(){
		 DisplayImageOptions options;  
		 options = new DisplayImageOptions.Builder()  
		  .showImageOnLoading(R.drawable.ic_launcher) //设置图片在下载期间显示的图片  
		  .showImageForEmptyUri(R.drawable.ic_launcher)//设置图片Uri为空或是错误的时候显示的图片  
		 .showImageOnFail(R.drawable.ic_launcher)  //设置图片加载/解码过程中错误时候显示的图片
		 .cacheInMemory(true)//设置下载的图片是否缓存在内存中  
		 .cacheOnDisc(true)//设置下载的图片是否缓存在SD卡中  
		 .considerExifParams(true)  //是否考虑JPEG图像EXIF参数（旋转，翻转）
		 .imageScaleType(ImageScaleType.EXACTLY)//设置图片以如何的编码方式显示  
		 .cacheOnDisk(true)

		 .resetViewBeforeLoading(true)//设置图片在下载前是否重置，复位  
//		 .displayer(new RoundedBitmapDisplayer(20))//是否设置为圆角，弧度为多少  
		 .displayer(new FadeInBitmapDisplayer(100))//是否图片加载好后渐入的动画时间  ,渐变动画
		 .build();//
		 
		 return options;
	}
}
