package com.example.bmi_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.bmi_app.constants.AppConstants;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private RadioButton male;
    private RadioButton female;
    private EditText age;
    private EditText weight;
    private EditText feet;
    private EditText inch;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);//the XML file
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;

//        });
        //Toast.makeText(this, AppConstants.TOAST_MESSAGE, Toast.LENGTH_LONG).show();
        findView();
        setUpButtonClickListener();
    }

    private void setUpButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        // if(age!=null)
        String fetchedAge = age.getText().toString();
        String fetchedWeight = weight.getText().toString();
        String fetchedFeet = feet.getText().toString();
        String fetchedInch = inch.getText().toString();
        String gender;

        int fInch = Integer.parseInt(fetchedInch);
        int fAge = Integer.parseInt(fetchedAge);
        int fFeet = Integer.parseInt(fetchedFeet);
        int fWeight = Integer.parseInt(fetchedWeight);
        double heightInMeter = ((fFeet * 12) + fInch) * 0.0254;
        double bmi = fWeight / Math.pow(heightInMeter, 2);
        result.setText(String.format("Calculated BMI :: %.2f",bmi));
    }

    private void findView() {
        result = findViewById(R.id.text_view_result);
        male = findViewById(R.id.radio_button_male);
        female = findViewById(R.id.radio_button_female);
        age = findViewById(R.id.edit_text_age);
        weight = findViewById(R.id.edit_text_weight);
        feet = findViewById(R.id.edit_text_feet);
        inch = findViewById(R.id.edit_text_inch);
        calculateButton = findViewById(R.id.button_calculate);
    }
}