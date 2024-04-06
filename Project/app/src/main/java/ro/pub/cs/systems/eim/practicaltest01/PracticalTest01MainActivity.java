package ro.pub.cs.systems.eim.practicaltest01;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01MainActivity extends AppCompatActivity {

    Button navigateToSecondaryActivityButton;
    Button clickMeButton;
    Button clickMeTooButton;
    EditText leftEditText;
    EditText rightEditText;

    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);

        navigateToSecondaryActivityButton = findViewById(R.id.navigateToSecondaryActivityButton);
        clickMeButton = findViewById(R.id.pressMeButton);
        clickMeTooButton = findViewById(R.id.pressMeTooButton);
        leftEditText = findViewById(R.id.editTextLeft);
        rightEditText = findViewById(R.id.editTextRight);

        leftEditText.setText("0");
        rightEditText.setText("0");

        clickMeButton.setOnClickListener(view -> {
            String leftEditTextValue = leftEditText.getText().toString();
            int leftNumber = Integer.parseInt(leftEditTextValue);
            leftEditText.setText(String.valueOf(leftNumber + 1));
        });

        clickMeTooButton.setOnClickListener(view -> {
            String rightEditTextValue = rightEditText.getText().toString();
            int rightNumber = Integer.parseInt(rightEditTextValue);
            rightEditText.setText(String.valueOf(rightNumber + 1));
        });

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == RESULT_OK) {
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "CANCELED", Toast.LENGTH_LONG).show();
            }
        });

        navigateToSecondaryActivityButton.setOnClickListener(view -> {
            int sum = Integer.parseInt(leftEditText.getText().toString()) + Integer.parseInt(rightEditText.getText().toString());

            Intent intent = new Intent(getApplicationContext(), PracticalTest01SecondaryActivity.class);
            intent.putExtra(Constants.SUM, sum);

            activityResultLauncher.launch(intent);
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(Constants.LEFT_COUNT, leftEditText.getText().toString());
        savedInstanceState.putString(Constants.RIGHT_COUNT, rightEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.LEFT_COUNT)) {
            leftEditText.setText(savedInstanceState.getString(Constants.LEFT_COUNT));
        } else {
            leftEditText.setText("0");
        }
        if (savedInstanceState.containsKey(Constants.RIGHT_COUNT)) {
            rightEditText.setText(savedInstanceState.getString(Constants.RIGHT_COUNT));
        } else {
            rightEditText.setText("0");
        }
    }
}