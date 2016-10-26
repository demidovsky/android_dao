package pro.dimmy.daotest.accounts;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import pro.dimmy.daotest.HelperFactory;
import pro.dimmy.daotest.R;

public class AccountsActivity extends Fragment
{
    private static final int REQUEST_ADD_ID = 1;
    List<Account> accountList = null;
    AccountsDAO accountsDao;
    ListView accountListView;
    AccountAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.activity_accounts, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        setAccountsAdapter(view);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.button_account_add);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getContext(), AccountAddActivity.class);
                startActivityForResult(intent, REQUEST_ADD_ID);
            }
        });
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        setAccountsAdapter();


        setToolbar();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.button_account_add);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), AccountAddActivity.class);
                startActivityForResult(intent, REQUEST_ADD_ID);
            }
        });
    }*/





    private void setToolbar()
    {
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/
    }





    private void setAccountsAdapter(View view)
    {

        accountListView = (ListView) view.findViewById(R.id.list_accounts);

        try
        {
            accountsDao = HelperFactory.getHelper().getAccountDAO();
            accountList = accountsDao.getAllAccounts();
        } catch (SQLException e) { e.printStackTrace(); }


        if (accountList != null)
        {
            adapter = new AccountAdapter(
                    getContext(),
                    // android.R.layout.simple_list_item_1,
                    R.layout.item_account,
                    accountList
            );

            accountListView.setAdapter(adapter);

            Toast.makeText(getContext(), "Accounts: " + accountList.size(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getContext(), "No accounts", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String text = "...";

        if (resultCode == Activity.RESULT_OK)
        {
            text = data.getStringExtra(AccountAddActivity.NAME_EXTRA);
            Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
        }


        try
        {
            AccountsDAO accountsDao = HelperFactory.getHelper().getAccountDAO();
            accountsDao.create(new Account(text));

        }
        catch (SQLException e) { e.printStackTrace(); }


        adapter.add(new Account(text));

        adapter.notifyDataSetChanged();

    }
}
