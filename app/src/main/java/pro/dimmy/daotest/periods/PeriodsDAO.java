package pro.dimmy.daotest.periods;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by user on 19.10.2016.
 */


public class PeriodsDAO extends BaseDaoImpl<Period, Integer>
{

    public PeriodsDAO(ConnectionSource connectionSource, Class<Period> dataClass) throws SQLException
    {
        super(connectionSource, dataClass);
    }



    public List<Period> getAllPeriods() throws SQLException
    {
        return this.queryForAll();
    }

}