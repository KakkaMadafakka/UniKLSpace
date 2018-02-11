package com.example.phobo.uniklspace.Home;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.phobo.uniklspace.Tab1;
import com.example.phobo.uniklspace.Tab2;
import com.example.phobo.uniklspace.Tab3;


/**
 * Created by ash on 10/2/2018.
 */
import java.util.ArrayList;
import java.util.List;

public class Pager extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();

    public Pager(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

}