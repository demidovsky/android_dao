package pro.dimmy.daotest.accounts;

import java.sql.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.util.List;

/**
 * Created by ddemidovskiy on 17.10.2016.
 */


public class AccountsDAO extends BaseDaoImpl<Account, Integer>
{

    public AccountsDAO(ConnectionSource connectionSource, Class<Account> dataClass) throws SQLException
    {
        super(connectionSource, dataClass);
    }



    public List<Account> getAllAccounts() throws SQLException
    {
        return this.queryForAll();
    }

}
