package liyanlong.bwei.com.newstop.myadapter;


import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;



import java.util.ArrayList;


/**
 * Created by Administrator on 2016/12/28.
 */
public class FragmentA_BaseAdater_B extends FragmentStatePagerAdapter {


    private ArrayList<Fragment> fragment_list;
    private ArrayList<String> list;
    private boolean flag;
    public FragmentA_BaseAdater_B(FragmentManager fm, ArrayList<Fragment> fragment_list, ArrayList<String> list) {
        super(fm);
        this.fragment_list = fragment_list;
        this.list = list;
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_list.get(position);
    }

    @Override
    public int getCount() {
        return fragment_list.size();
    }

}
