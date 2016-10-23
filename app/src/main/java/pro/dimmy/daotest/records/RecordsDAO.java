package pro.dimmy.daotest.records;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by user on 19.10.2016.
 */



public class RecordsDAO extends BaseDaoImpl<Record, Integer>
{

    public RecordsDAO(ConnectionSource connectionSource, Class<Record> dataClass) throws SQLException
    {
        super(connectionSource, dataClass);
    }



    public List<Record> getAllRecords() throws SQLException
    {
        return this.queryForAll();
    }

}