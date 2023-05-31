package com.testing.examdetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,subject,grade,marks;
    Button save,display;
    TextView out;
    DBhandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameID);
        subject=findViewById(R.id.subjectID);
        grade=findViewById(R.id.gradeID);
        marks=findViewById(R.id.marksID);
        save=findViewById(R.id.saveID);
        display=findViewById(R.id.DisplayID);
        out=findViewById(R.id.viewID);

        db=new DBhandler(MainActivity.this,"student",null,1);


        //save data
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sname=name.getText().toString();
                String Subj=subject.getText().toString();
                String Grad=grade.getText().toString();
                String mark=marks.getText().toString();

             long recordid= db.saveDate(sname,Subj,Grad,mark);//calling save logic

                if(recordid>0){
                    Toast.makeText(getApplicationContext(),"Saved data",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Saved data",Toast.LENGTH_LONG).show();
                }


            }
        });

        //display data
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result=db.getData();

                out.setText(result);



            }
        });


    }



}