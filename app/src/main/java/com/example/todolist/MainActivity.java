package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mTitleText;
    private EditText mBodyText;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTitleText = (EditText) findViewById(R.id.editText_titleInput);
        mBodyText = (EditText) findViewById(R.id.editText_container);
        save = (Button) findViewById(R.id.button_save);

        SharedPreferences prefs = getSharedPreferences("information", MODE_PRIVATE);
        String title = prefs.getString("title", "");
        String body = prefs.getString("body", "");

        mTitleText.setText(title);
        mBodyText.setText(body);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveState();
            }
        });

    }

    private void saveState() {
        String title = mTitleText.getText().toString();
        String body = mBodyText.getText().toString();

        SharedPreferences.Editor editor = getSharedPreferences("information", MODE_PRIVATE).edit();
        editor.putString("title", title);
        editor.putString("body", body);

        editor.commit();

        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
    }
}