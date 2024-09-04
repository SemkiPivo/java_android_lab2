package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    TextView mainTextView;
    Button addButton, retractButton;
    ImageButton revertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainTextView = findViewById(R.id.textView);
        addButton = findViewById(R.id.add_button);
        retractButton = findViewById(R.id.retract_button);
        revertButton = findViewById(R.id.revert_button);

        mainTextView.setText(score + "\nРаз");
        addButton.setOnClickListener(clickListener);
        retractButton.setOnClickListener(clickListener);
        revertButton.setOnClickListener(clickListener);


    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view == addButton) score++;
            if (view == retractButton) score--;
            if (view == revertButton) score = 0;

            String text = "Раз";
            if ((((Math.abs(score) % 10) == 2)
                    || ((Math.abs(score) % 10) == 3)
                    || ((Math.abs(score) % 10) == 4))
                    && (score < 10 || score > 20) ){
                text = "Раза";
            }

            mainTextView.setText(score + "\n" + text);
        }
    };

}