package pro.dimmy.daotest.records;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by user on 19.10.2016.
 */

@DatabaseTable(tableName = "Records")
public class Record {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(dataType = DataType.STRING)
    private String text;

    @DatabaseField
    private int type;

    @DatabaseField(canBeNull = false)
    private int sum;

    @DatabaseField
    private int date;

    @DatabaseField
    private int sort;

    @DatabaseField
    private int period_id;

    @DatabaseField
    private int from_account_id;

    @DatabaseField
    private int to_account_id;

    @DatabaseField
    private int done;




    public Record() { }
    public Record(String text)
    {
        this.text = text;
    }


    public String getText()
    {
        return text;
    }
}
