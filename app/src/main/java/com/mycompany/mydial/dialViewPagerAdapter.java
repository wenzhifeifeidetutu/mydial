package com.mycompany.mydial;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Administrator on 2017/5/31.
 */

public class dialViewPagerAdapter extends FragmentPagerAdapter {
    private Context mycotext;

    public dialViewPagerAdapter(Context context ,FragmentManager fm) {
        super(fm);
        mycotext  = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new DialFragment();
        }else {
            return new ConnectorFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mycotext.getString(R.string.dial);

        }else {
            return mycotext.getString(R.string.connection);
        }
    }
}
