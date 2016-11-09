package com.example.wasim.tabtry;

import android.content.DialogInterface;
import android.hardware.Camera;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   Spinner d1;
    // d1 = (Spinner)findViewById(R.id.spinner11);
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        d1 = (Spinner)findViewById(R.id.spinner11);
//         Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        getSupportFragmentManager().beginTransaction().replace(R.id.main_content,new MainFragment());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.aboutus)
        {
           AboutUs();
            return true;
        }

        if (id == R.id.aboutapp)
        {
          AboutAPP();
            return true;
        }

        return super.onOptionsItemSelected(item);





    }

    public  void AboutUs()
    {




        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("About US ");
        alertDialog.setIcon(R.drawable.dg);
        alertDialog.setMessage(" Why Digital Application? Digital Application’s Plans and Price has no hidden charges." +
                "We have all-inclusive prices and unbeatable value.\n  Other Companies promise to provide cheap solutions," +
                "but they charge extra as setup fees or higher renewal rates, or some hidden charges.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public  void AboutAPP()
    {




        AlertDialog alertDialog1 = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog1.setTitle("About App");
        alertDialog1.setIcon(R.drawable.logocamp);
        alertDialog1.setMessage("Unit Converter is a simple,fast and easy application that allows you to convert any number into another unit number anytime.\n   This application has friendly user interface with display messages so that user enter correct value according to the standard format.\n");
        alertDialog1.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog1.show();
    }


    /**
     * A placeholder fragment containing a simple view.
     */

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    MainFragment tab1Contacts = new MainFragment();
                    return tab1Contacts;
                case 1:
                    TimeFragment timeFragment = new TimeFragment();
                    return timeFragment;

                case 2:
                    AreaFragment areaFragment = new AreaFragment();
                    return areaFragment;
                case 3:
                   VolumeFragment volumeFragment= new VolumeFragment();
                    return volumeFragment;
                case 4:
                    TemperatureFragment temperatureFragment= new TemperatureFragment();
                    return temperatureFragment;
                case 5:
                    WeightFragment weightFragment= new WeightFragment();
                    return weightFragment;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Length";
                case 1:
                    return "Time";
                case 2:
                    return "Area";
                case 3:
                    return "Volume";
                case 4:
                    return "Temperature";
                case 5:
                    return "Weight";

            }
            return null;
        }
    }
}
