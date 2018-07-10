package com.example.a300273215.admin;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

import ORM.RequestOrder;

/**
 * Created by 300272368 on 7/7/2018.
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;
    SparseArray<Fragment> lookupFrags = new SparseArray<Fragment>();

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;

    }



    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();
                lookupFrags.put(position, tab1);
                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2( );
                lookupFrags.put(position, tab2);
                return tab2;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        lookupFrags.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment GetFrag(int position) {
        return lookupFrags.get(position);
    }
}
