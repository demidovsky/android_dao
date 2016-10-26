package pro.dimmy.daotest.records;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import pro.dimmy.daotest.R;

public class RecordAddActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_add);
        setTitle("Добавить запись");


        TabHost tabHost = (TabHost) findViewById(R.id.tab_host_record_add);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tab1");
        tabSpec.setContent(R.id.tab_out);
        tabSpec.setIndicator("Out");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.tab_in);
        tabSpec.setIndicator("In");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.tab_move);
        tabSpec.setIndicator("Move");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag4");
        tabSpec.setContent(R.id.tab_fix);
        tabSpec.setIndicator("Fix");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

    }
}
