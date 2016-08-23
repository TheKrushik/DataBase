package info.krushik.android.database;

public class Group {
    public static final String TABLE_NAME = "Groups";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NUMBER = "Number";

    public long id;
    public String Number;

    public Group(String number) {
        this.Number = number;
    }
}
