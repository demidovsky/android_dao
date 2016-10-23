package pro.dimmy.daotest.periods;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by user on 19.10.2016.
 */

@DatabaseTable(tableName = "Periods")
public class Period {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(dataType = DataType.STRING)
    private String text;

    @DatabaseField
    private int month;

    @DatabaseField
    private int year;


    public Period() { }

    public Period(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }
}