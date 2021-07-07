package sg.edu.rp.c346.id20025732.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.editTextTextName);
        etgpa = findViewById(R.id.editTextTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etname.getText().toString();
        Float gpa = Float.parseFloat(etgpa.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefedit = prefs.edit();
        prefedit.putString("Name", strName);
        prefedit.putFloat("GPA", gpa);
        prefedit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String strname = prefs.getString("Name","John");
        float floatgpa = prefs.getFloat("GPA", 3.0f);

        etname.setText(strname);
        etgpa.setText(floatgpa + "");



    }

}
