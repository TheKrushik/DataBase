package info.krushik.android.database;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private DataBaseHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //создаем БД
        mDBHelper = new DataBaseHelper(this);
    }

    public void OnClick(View v) {
        SQLiteDatabase db = mDBHelper.getWritableDatabase();

        Group group;
        Student student;

        switch (v.getId()) {
            case R.id.button:
                group = new Group("Number 1");
                long idGroup = mDBHelper.insertGroup(group);

                student = new Student(idGroup, "Ivan", "Ivanov", 22);
                long idStudent = mDBHelper.insertStudent(student);

                Toast.makeText(this, String.format("ID group:%s, ID student:%s", idGroup, idStudent), Toast.LENGTH_LONG).show();
                break;
            case R.id.button2:
                student = new Student("Petro", "Petrov", 33);
                student.id = 1;

                int uCount = mDBHelper.updateStudent(student);
                Toast.makeText(this, String.format("Updated %s students", uCount), Toast.LENGTH_LONG).show();
                break;
            case R.id.button3:
                ArrayList<Student> students = mDBHelper.getStudents();
                Toast.makeText(this, String.format("Students:%s", students.size()), Toast.LENGTH_LONG).show();
                break;
            case R.id.button4:
                student = mDBHelper.getStudent(1);

                if (student == null) {
                    Toast.makeText(this, "Student not found", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, student.FirstName, Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.button5:
                int dCount = mDBHelper.deleteStudent(1);
                Toast.makeText(this, String.format("Deleted %s students", dCount), Toast.LENGTH_LONG).show();
                break;
            case R.id.button7:
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
                break;
        }
    }
}
