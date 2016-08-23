package info.krushik.android.database;

public class Student {
    public static final String TABLE_NAME = "Students";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ID_GROUP = "_idGroup";
    public static final String COLUMN_FIRST_NAME = "FirstName";
    public static final String COLUMN_LAST_NAME = "LastName";
    public static final String COLUMN_AGE = "Age";

    public long id;
    public long idGroup;

    public String FirstName;
    public String LastName;
    public long Age;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
    }

    public Student(long idGroup, String firstName, String lastName, int age) {
        this.idGroup = idGroup;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Age = age;
    }
}
