package com.code.abhishek.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.*;
import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
   private Button true1,false1,next1;
    TextView tv;
    int rn;
    private static final String TAG = "QuizActivity";
static final String STATE="number";
    int flag=0;
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Inside OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Inside OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Inside OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        rn=savedInstanceState.getInt(STATE);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE,rn);
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "Inside onSaveInstance");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    true1=(Button)findViewById(R.id.truebutton);
        false1=(Button)findViewById(R.id.falsebutton);
        next1=(Button)findViewById(R.id.nextbutton);
       tv=(TextView) findViewById(R.id.textView2);
        if(savedInstanceState!=null){
            rn=savedInstanceState.getInt(STATE);
        }else {
            Random n = new Random();
            rn = n.nextInt(1000) + 1;
        }
        tv.setText("Is " + Integer.toString(rn) + " a prime number?");

        next1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
Random n=new Random();
        rn=n.nextInt(1000)+1;
        tv.setText("Is " +Integer.toString(rn)+ " a prime number?");
    }
});
         true1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 flag=0;
               for(int i=2;i<rn;i++){
                   if(rn%i==0){
                       Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
                       flag=1;
                       break;
                   }


               }
if (flag==0){
    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
}


             }
         });
false1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        flag=0;
        for(int i=2;i<rn;i++){
            if(rn%i==0){
                Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                flag=1;
                break;
            }
        }
        if (flag==0){
            Toast.makeText(getApplicationContext(),"Incorrect",Toast.LENGTH_SHORT).show();
        }
    }
});


    }
}
