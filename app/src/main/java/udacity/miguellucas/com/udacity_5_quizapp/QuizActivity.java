package udacity.miguellucas.com.udacity_5_quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Miguel Lucas on 06/02/2018.
 */

public class QuizActivity extends AppCompatActivity {

    RadioGroup rg1;
    RadioGroup rg2;
    RadioGroup rg3;
    RadioGroup rg4;
    RadioGroup rg5;
    RadioGroup rg6;
    RadioGroup rg7;
    RadioGroup rg8;
    RadioGroup rg9;
    RadioGroup rg10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        rg4 = (RadioGroup) findViewById(R.id.radioGroup4);
        rg5 = (RadioGroup) findViewById(R.id.radioGroup5);
        rg6 = (RadioGroup) findViewById(R.id.radioGroup6);
        rg7 = (RadioGroup) findViewById(R.id.radioGroup7);
        rg8 = (RadioGroup) findViewById(R.id.radioGroup8);
        rg9 = (RadioGroup) findViewById(R.id.radioGroup9);
        rg10 = (RadioGroup) findViewById(R.id.radioGroup10);
        rg1.clearCheck();
        rg2.clearCheck();
        rg3.clearCheck();
        rg4.clearCheck();
        rg5.clearCheck();
        rg6.clearCheck();
        rg7.clearCheck();
        rg8.clearCheck();
        rg9.clearCheck();
        rg10.clearCheck();

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg2, rg1);
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg1, rg2);
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg4, rg3);
            }
        });

        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg3, rg4);
            }
        });


        rg5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg6, rg5);
            }
        });

        rg6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg5, rg6);
            }
        });



        rg7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg8, rg7);
            }
        });

        rg8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg7, rg8);
            }
        });



        rg9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg10, rg9);
            }
        });

        rg10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(rg9, rg10);
            }
        });
    }

    public void resetGroups(final RadioGroup g1, final RadioGroup g2) {
        g1.setOnCheckedChangeListener(null);
        g1.clearCheck();
        g1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                resetGroups(g2,g1);

            }
        });
    }

    public void submit(View v){
        int score = 0;

        int answerQuestion1 = rg1.getCheckedRadioButtonId();
        if (answerQuestion1 == 2){
            score++;
        }

        int answerQuestion2 = rg3.getCheckedRadioButtonId();
        if (answerQuestion2 == 5){
            score++;
        }

        int answerQuestion3 = rg6.getCheckedRadioButtonId();
        if (answerQuestion3 == 11){
            score++;
        }

        int answerQuestion4 = rg8.getCheckedRadioButtonId();
        if (answerQuestion4 == 16){
            score++;
        }

        int answerQuestion5 = rg10.getCheckedRadioButtonId();
        if (answerQuestion5 == 20 || answerQuestion5 == 19){
            score++;
        }

        if (score == 5){
            Toast.makeText(this, getString(R.string.success), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.try_again, score), Toast.LENGTH_SHORT).show();
        }

    }
}
