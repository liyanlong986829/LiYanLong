package utils;


import com.bawei.liyanlong.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class CommenUtil {
	public static DisplayImageOptions getOptions(){
		 DisplayImageOptions options;  
		 options = new DisplayImageOptions.Builder()  
		  .showImageOnLoading(R.drawable.ic_launcher) //����ͼƬ�������ڼ���ʾ��ͼƬ  
		  .showImageForEmptyUri(R.drawable.ic_launcher)//����ͼƬUriΪ�ջ��Ǵ����ʱ����ʾ��ͼƬ  
		 .showImageOnFail(R.drawable.ic_launcher)  //����ͼƬ����/��������д���ʱ����ʾ��ͼƬ
		 .cacheInMemory(true)//�������ص�ͼƬ�Ƿ񻺴����ڴ���  
		 .cacheOnDisc(true)//�������ص�ͼƬ�Ƿ񻺴���SD����  
		 .considerExifParams(true)  //�Ƿ���JPEGͼ��EXIF��������ת����ת��
		 .imageScaleType(ImageScaleType.EXACTLY)//����ͼƬ����εı��뷽ʽ��ʾ  
		 .cacheOnDisk(true)

		 .resetViewBeforeLoading(true)//����ͼƬ������ǰ�Ƿ����ã���λ  
//		 .displayer(new RoundedBitmapDisplayer(20))//�Ƿ�����ΪԲ�ǣ�����Ϊ����  
		 .displayer(new FadeInBitmapDisplayer(100))//�Ƿ�ͼƬ���غú���Ķ���ʱ��  ,���䶯��
		 .build();//
		 
		 return options;
	}
}
