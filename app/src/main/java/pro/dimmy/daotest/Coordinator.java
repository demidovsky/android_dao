package pro.dimmy.daotest;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.design.widget.FloatingActionButton;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ddemidovskiy on 17.10.2016.
 */

public class Coordinator extends AppCompatActivity
{
    public static final int REQUEST_ADD_ID = 1;

    List<Account> accountList = null;
    AccountDAO accountDao;
    ListView accountListView;
    AccountAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator);


        HelperFactory.setHelper(getApplicationContext());


        setAccountsAdapter();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.action_button);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Toast.makeText(getApplicationContext(), "Replace with your own action", Toast.LENGTH_LONG).show();

                // Создаем Intent на запуск детальной Activity
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);

                // Добавляем туда нужные данные - имя, номер в контейнере и рейтинг
                // intent.putExtra(SAINT_NAME, saint);
                // intent.putExtra(SAINT_ID, position);
                // intent.putExtra(SAINT_RATING, s.getRating());

                // Запускаем Activity и подписываемся на получение результата
                startActivityForResult(intent, REQUEST_ADD_ID);
            }
        });








    }

    private void setAccountsAdapter()
    {
        accountListView = (ListView) findViewById(R.id.list_accounts);

        try
        {
            accountDao = HelperFactory.getHelper().getAccountDAO();
            accountList = accountDao.getAllAccounts();
        } catch (SQLException e) { e.printStackTrace(); }


        if (accountList != null)
        {
            adapter = new AccountAdapter(
                    this,
                    // android.R.layout.simple_list_item_1,
                    R.layout.item_account,
                    accountList
            );

            accountListView.setAdapter(adapter);

            Toast.makeText(this, "Accounts: " + accountList.size(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "No accounts", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        // if (resultCode == RESULT_OK)
        // {
            String text = data.getStringExtra(AddActivity.NAME_EXTRA);
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        // }


        try
        {
            AccountDAO accountDao = HelperFactory.getHelper().getAccountDAO();
            accountDao.create(new Account(text));

        }
        catch (SQLException e) { e.printStackTrace(); }


        adapter.add(new Account(text));

        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onDestroy()
    {
        HelperFactory.releaseHelper();
        super.onDestroy();
    }


}
