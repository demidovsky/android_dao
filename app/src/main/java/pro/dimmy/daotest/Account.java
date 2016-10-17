package pro.dimmy.daotest;


import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by ddemidovskiy on 17.10.2016.
 */

@DatabaseTable(tableName = "Accounts")
public class Account
{
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    private String name;

    @DatabaseField()
    private int lim;

    @DatabaseField()
    private int sort;

    public Account() { }
    public Account(String name)
    {
        this.name = name;
    }


    public String getName()
    {
        return name;
    }
}
