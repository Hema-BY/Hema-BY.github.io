package com.example.quizzie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    RadioGroup ansGroup;
    RadioButton ans1,ans2,ans3,ans4;
    TextView ques;
    Button next;
    String questions[]={"Who is the current president of India",
            "Who was the first women president of India",
            "What is the national motto of India",
            "Which is the national song of India",
            "What is the name of India's national aquatic animal",
            "Which state is known as India's spice garden",
            "Who is the father of Mathematics in India",
            "IST refers to the local time in which city",
            "Who is the first person to receive Bharat Ratna from Karnataka ",
            "Which is the state animal of Karnataka"};

    String answers[]={"Ramnath Kovind",
            "Pratibha Patil",
            "Satyamev Jayate",
            "Vande Mataram",
            "River Dolphin",
            "Kerala",
            "Aryabhata",
            "Allahabad",
            "Sir M Vishweshvariah",
            "Asiatic Elephant"};

    String options[]={"Rajnath Singh","Narendra Modi","Ramnath Kovind","Amit Shah",
            "Indira Gandhi","Smriti Irani","Nirmala Seetharaman","Pratibha Patil",
            "Satyamev Jayate","Vande Mataram","Jana Gana Mana","Balidaan",
            "Jana Gana Mana","Vande Mataram","Jaya Bharatha","Maa Tujhe Salaam",
            "Shark","Dolphin","River Dolphin","Blue Whale",
            "Karanataka","Kerala","Andra Pradesh","Tamil Nadu",
            "Aryabhata","Sushutra","Ramanujan","C.V Raman",
            "Allahabad","Delhi","Mumbai","Kolkata",
            "Girish Karnad","Kuvempu","Sir M Vishweshvariah","D.V Gundappa",
            "Asiatic Elephant","Deer","Bear","Tiger"};

    int i=0;
    public static int correct=0, wrong=0,marks=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);




        ques=(TextView)findViewById(R.id.que);
        ansGroup=(RadioGroup)findViewById(R.id.rad_group);

        ans1=(RadioButton)findViewById(R.id.radiobutton1);
        ans2=(RadioButton)findViewById(R.id.radiobutton2);
        ans3=(RadioButton)findViewById(R.id.radiobutton3);
        ans4=(RadioButton)findViewById(R.id.radiobutton4);
        next=(Button)findViewById(R.id.next);
        ques.setText(questions[i]);
        ans1.setText(options[0]);
        ans2.setText(options[1]);
        ans3.setText(options[2]);
        ans4.setText(options[3]);

        Intent intent=getIntent();
        final String name=intent.getStringExtra("myname");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ansGroup.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Please select an option to proceed",Toast.LENGTH_LONG).show();
                    return;
                }
                RadioButton selAnswer=(RadioButton) findViewById(ansGroup.getCheckedRadioButtonId());
                String answer=selAnswer.getText().toString();

                Toast.makeText(getApplicationContext(),answer,Toast.LENGTH_LONG).show();

                if(answer.equals(answers[i])){
                    correct++;
                }
                else{
                    wrong++;
                }

                i++;


                if(i<questions.length){
                    ques.setText(questions[i]);
                    ans1.setText(options[i*4]);
                    ans2.setText(options[i*4 +1]);
                    ans3.setText(options[i*4 +2]);
                    ans4.setText(options[i*4 +3]);
                }
                else{
                    marks=correct;
                    Intent intentResult = new Intent(getApplicationContext(),ResultActivity.class);
                    intentResult.putExtra("myname",name);
                    intentResult.putExtra("myscore",correct);
                    startActivity(intentResult);
                }
                ansGroup.clearCheck();
            }
        });
    }
}