package pro.dimmy.daotest.periods;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pro.dimmy.daotest.R;
import pro.dimmy.daotest.accounts.AccountAddActivity;

public class PeriodsActivity extends AppCompatActivity {

    private static final int REQUEST_ADD_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periods);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_period_add);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), PeriodAddActivity.class);
                startActivityForResult(intent, REQUEST_ADD_ID);
            }
        });
    }
}
