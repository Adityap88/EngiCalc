package com.aditya.engicalc;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import UnitConverter.areaFrag;
import UnitConverter.distanceFrag;
import UnitConverter.massFrag;
import UnitConverter.pressureFrag;
import UnitConverter.speedFrag;
import UnitConverter.temperatureFrag;
import UnitConverter.volumeFrag;


public class unit_converter extends Fragment {


    Adapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.ic_centimeter,
            R.drawable.ic_area,
            R.drawable.ic_weight,
            R.drawable.ic_volume,
            R.drawable.ic_speed
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_unit_converter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new Adapter(getChildFragmentManager());
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        //viewPager.setAdapter(new myPagerAdapter(getFragmentManager(),0));
        viewPager.setAdapter(adapter);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }

        viewPager.setCurrentItem(0);
        tabLayout.getTabAt(0).getIcon().setColorFilter(Color.parseColor("#FF9800"), PorterDuff.Mode.SRC_IN);


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(Color.parseColor("#FF9800"), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.setTabIconTint(ColorStateList.valueOf(getResources().getColor(R.color.TabUnselectedColor)));
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                tab.getIcon().setColorFilter(Color.parseColor("#FF9800"), PorterDuff.Mode.SRC_IN);

            }
        });

    }


    public static class Adapter extends FragmentStatePagerAdapter {

        String[] titles = {"Distance", "Area", "Mass", "Volume", "Speed"};

        public Adapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new distanceFrag();
                case 1:
                    return new areaFrag();
                case 2:
                    return new massFrag();
                case 3:
                    return new volumeFrag();
                case 4:
                    return new speedFrag();
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
