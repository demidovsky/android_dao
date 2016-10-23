package pro.dimmy.daotest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import pro.dimmy.daotest.accounts.AccountsActivity;
import pro.dimmy.daotest.periods.PeriodsActivity;
import pro.dimmy.daotest.records.RecordsActivity;

/**
 * Created by user on 19.10.2016.
 */

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        setToolbar();

        HelperFactory.setHelper(getApplicationContext());

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        Fragment fragment = null;
        Class fragmentClass;


        switch (item.getItemId())
        {
            case R.id.nav_accounts:
            {
                Intent intent = new Intent(getApplicationContext(), AccountsActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.nav_month:
            {
                Intent intent = new Intent(getApplicationContext(), RecordsActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.nav_year:
            {
                Intent intent = new Intent(getApplicationContext(), PeriodsActivity.class);
                startActivity(intent);

                break;
            }
            case R.id.nav_month_template:
            {
                // Intent intent = new Intent(getApplicationContext(), .class);
                // startActivity(intent);
                break;
            }
        }


       /* try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

        // Highlight the selected item has been done by NavigationView
        menuItem.setChecked(true);
        // Set action bar title
        setTitle(menuItem.getTitle());
        // Close the navigation drawer
        mDrawer.closeDrawers();*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    // TODO: 19.10.2016 заменить на onPause?
    @Override
    protected void onDestroy()
    {
        HelperFactory.releaseHelper();
        super.onDestroy();
    }




    private void setToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
