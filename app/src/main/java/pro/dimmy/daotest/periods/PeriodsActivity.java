package pro.dimmy.daotest.periods;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pro.dimmy.daotest.R;
import pro.dimmy.daotest.accounts.AccountAddActivity;

public class PeriodsActivity extends Fragment
{

    private static final int REQUEST_ADD_ID = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_periods, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.button_period_add);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), PeriodAddActivity.class);
                startActivityForResult(intent, REQUEST_ADD_ID);
            }
        });
    }

    /*@Override
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
    }*/
}
