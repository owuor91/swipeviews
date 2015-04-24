package com.example.teeshirt.swipeviews;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class DevicePagerAdapter extends FragmentPagerAdapter{
    String[] devices;
    String[] deviceDescription;

    public DevicePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        Resources resources = context.getResources();
        devices = resources.getStringArray(R.array.devices);
        deviceDescription = resources.getStringArray(R.array.device_description);
    }

    @Override
    public Fragment getItem(int i) {
        Bundle bundle = new Bundle();
        bundle.putString(DeviceFragment.DescriptionKey,deviceDescription[i]);
        bundle.putInt(DeviceFragment.ImageIDKey, getDeviceImageID(i));

        DeviceFragment deviceFragment = new DeviceFragment();
        deviceFragment.setArguments(bundle);
        return deviceFragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return devices[position];
    }

    @Override
    public int getCount() {
        return devices.length ;
    }

    private int getDeviceImageID(int i){
        int id = 0;
        switch (i){
            case 0:
                id = R.drawable.coin;
                break;
            case 1:
                id = R.drawable.coin2;
                break;
            case 2:
                id = R.drawable.coin3;
                break;
        }
        return id;
    }
}
