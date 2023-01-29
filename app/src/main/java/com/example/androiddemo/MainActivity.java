package com.example.androiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText edFirstName, edLastName, edEmail, edPhoneNumber, edPostalAddress,
            edMultilineText, edNumber, edTime, edDate;
    private AutoCompleteTextView autoCity;
    private Button btnSubmit;

    private String[] arrCity = {"Ahmedabad","Vadodara","Bharuch","Surat","Surendranagar","Vapi",
            "Allhabad","Visnagar"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        edEmail = findViewById(R.id.edEmail);
        edPhoneNumber = findViewById(R.id.edPhoneNumber);
        edPostalAddress = findViewById(R.id.edPostalAddress);
        edMultilineText = findViewById(R.id.edMultilineText);
        edNumber = findViewById(R.id.edNumber);
        edTime = findViewById(R.id.edTime);
        edDate = findViewById(R.id.edDate);
        autoCity = findViewById(R.id.autoCity);
        autoCity.setThreshold(1);
        ArrayAdapter<String> arrAdapterCity = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,arrCity);
        autoCity.setAdapter(arrAdapterCity);


        btnSubmit = btnSubmit.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = edFirstName.getText().toString();
                String Lastname = edLastName.getText().toString();
                String email = edEmail.getText().toString();
                String phoneNumber = edPhoneNumber.getText().toString();
                int number = Integer.parseInt(edNumber.getText().toString());
                String time = edTime.getText().toString();
                String date = edDate.getText().toString();
                String city = autoCity.getText().toString();



                if(firstName.equals(null)){
                    edFirstName.setError("Enter First Name");
                } else if (Lastname.equals(null)) {
                    edLastName.setError("Enter Last Name");
                } else if (email.equals(null)) {
                    edEmail.setError("Enter Email");
                } else if (phoneNumber.equals(null)) {
                    edPhoneNumber.setError("Enter Phone Number");
                } else if (time.equals(null)) {
                    edTime.setError("Enter Time");
                } else if (date.equals(null)) {
                    edDate.setError("Enter Date");
                } else if (city.equals(null)) {
                    autoCity.setError("Enter City");
                }

                Toast.makeText(MainActivity.this, ""+firstName+","+Lastname+","+email+
                        ","+phoneNumber+","+number+","+time+","+date+","+city,
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}