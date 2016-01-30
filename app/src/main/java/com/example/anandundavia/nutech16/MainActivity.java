package com.example.anandundavia.nutech16;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    String clubList[];
    DrawerLayout clubDrawerLayout;
    ListView clubDrawerList;
    ActionBar actionBar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clubList = getResources().getStringArray(R.array.clublist);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, clubDrawerLayout, R.string.DrawerClose, R.string.DrawerClose);
        clubDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        clubDrawerList = (ListView) findViewById(R.id.left_drawer);
        clubDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, clubList));
        clubDrawerList.setOnItemClickListener(new MyDrawerListener());
        clubDrawerList.setItemChecked(0, true);
        clubDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        loadFragment(0);
    }

    private void loadFragment(int n)
    {
        Fragment frag;

        if (n == 0)
        {
            frag = new HomeFragment();
        } else
        {
            frag = new Euphoria();
        }
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, frag);
        fragmentTransaction.commit();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (clubDrawerLayout.isDrawerOpen(clubDrawerList))
        {
            clubDrawerLayout.closeDrawer(clubDrawerList);

        } else
        {
            clubDrawerLayout.openDrawer(clubDrawerList);
        }
        return super.onOptionsItemSelected(item);
    }

    class MyDrawerListener implements ListView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            if (position == 0)
                setTitle(getResources().getString(R.string.app_name));
            else
            {
                setTitle(clubList[position]);
            }
            loadFragment(position);
            clubDrawerLayout.closeDrawer(clubDrawerList);
        }
    }



}
