package com.example.quizzie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button submit;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit=(Button) findViewById(R.id.submit);
        name=(EditText) findViewById(R.id.name);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myname=name.getText().toString();
                Intent intent=new Intent(getApplicationContext(),Questions.class);
                intent.putExtra("myname",myname);
                startActivity(intent);
            }
        });
    }
}
