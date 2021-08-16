package com.example.quizzie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    TextView myname,myscore;
    Button playAgain,quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent=getIntent();
        String name=intent.getStringExtra("myname");
        String score=intent.getStringExtra("myscore");

        myname=(TextView)findViewById(R.id.name);
        myname.setText(name);

        myscore=(TextView)findViewById(R.id.score);
        playAgain=(Button)findViewById(R.id.playAgain);
        quit=(Button)findViewById(R.id.quit);



        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(""+Questions.correct);

        myscore.setText("Your score is:"+stringBuffer+"/10");

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.correct=0;
                Intent newIntent=new Intent(ResultActivity.this,MainActivity.class);
                startActivity(newIntent);
            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                moveTaskToBack(true);
            }
        });



    }
}
