package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class PracticalTest01SecondaryActivity extends AppCompatActivity {

    Button okButton;
    Button cancelButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_secondary);

        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);
        editText = findViewById(R.id.editText3);

        Intent intent = getIntent();
        int sum = intent.getIntExtra(Constants.SUM, 0);
        editText.setText(String.valueOf(sum));

        // toast on ok button
        okButton.setOnClickListener(view -> {
            Intent intentToParent = new Intent();
            setResult(RESULT_OK, intentToParent);
            finish();
        });

        // toast on cancel button

        cancelButton.setOnClickListener(view -> {
            Intent intentToParent = new Intent();
            setResult(RESULT_CANCELED, intentToParent);
            finish();
        });



    }
}