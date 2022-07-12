package com.example.a3month1hw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private Button  btnNext;
private EditText etGmail;
private EditText eTheme;
private EditText etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btn_next);
        etGmail = findViewById(R.id.et_gmails);
        eTheme = findViewById(R.id.et_soobotybtt);
        etMessage = findViewById(R.id.et_soobshenie);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",eTheme.getText().toString(), null));
                intent.putExtra(Intent.EXTRA_EMAIL, etGmail.getText().toString());
                intent.putExtra(Intent.EXTRA_SUBJECT, eTheme.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, etMessage.getText().toString());
                startActivity(Intent.createChooser(intent, "send"));
            }
        });
    }
}