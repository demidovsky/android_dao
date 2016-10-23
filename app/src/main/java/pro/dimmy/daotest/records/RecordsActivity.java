package pro.dimmy.daotest.records;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pro.dimmy.daotest.R;
import pro.dimmy.daotest.periods.PeriodAddActivity;

public class RecordsActivity extends AppCompatActivity {

    private static final int REQUEST_ADD_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_record_add);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), RecordAddActivity.class);
                startActivityForResult(intent, REQUEST_ADD_ID);
            }
        });
    }
}
