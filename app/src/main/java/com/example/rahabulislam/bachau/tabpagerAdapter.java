package com.example.rahabulislam.bachau;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class tabpagerAdapter extends FragmentStatePagerAdapter {

    String[] tabarray = new String [] {"Location","Map View","Post Work","View Available Work"};
    Integer tabNumber = 3;

    public tabpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabarray[position];
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                Location Location1 = new Location();
                return  Location1;

            case 1:
                MapView MapView1 = new MapView();
                return MapView1;
            case 2:
                PostWork PostWork1 = new PostWork();
                return PostWork1;

        }

        return null;
    }

    @Override
    public int getCount() {
        return tabNumber;
    }
}