package com.example.applicationtest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res=getResources();

        Bundle data=getIntent().getExtras();
        if(data!=null){
            ((EditText) findViewById(R.id.nameInput)).setText(data.getString("name"));
            ((EditText) findViewById(R.id.firstNameInput)).setText(data.getString("firstName"));
            ((EditText) findViewById(R.id.yearsInput)).setText(data.getString("age"));
            ((EditText) findViewById(R.id.skillsInput)).setText(data.getString("skills"));
            ((EditText) findViewById(R.id.phoneInput)).setText(data.getString("phone"));
        }

        (findViewById(R.id.submitButton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        String name= ((EditText) findViewById(R.id.nameInput)).getText().toString();
                        String firstName= ((EditText) findViewById(R.id.firstNameInput)).getText().toString();
                        String age= ((EditText) findViewById(R.id.yearsInput)).getText().toString();
                        String skills= ((EditText) findViewById(R.id.skillsInput)).getText().toString();
                        String phone= ((EditText) findViewById(R.id.phoneInput)).getText().toString();

                        if(name.isEmpty() || firstName.isEmpty() || age.isEmpty() || skills.isEmpty() || phone.isEmpty()){
                            Toast.makeText(MainActivity.this, res.getString(R.string.dialogError), Toast.LENGTH_SHORT).show();
                        }
                        else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle(res.getString(R.string.dialogTitle));
                            builder.setMessage(res.getString(R.string.dialogQuestion));
                            builder.setCancelable(false);
                            builder.setPositiveButton(res.getString(R.string.dialogPositive), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MainActivity.this, res.getString(R.string.dialogSucces), Toast.LENGTH_SHORT).show();
                                    Bundle bundle=new Bundle();
                                    bundle.putString("name",name);
                                    bundle.putString("firstName",firstName);
                                    bundle.putString("age",age);
                                    bundle.putString("skills",skills);
                                    bundle.putString("phone",phone);
                                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                }
                            });
                            builder.setNegativeButton(res.getString(R.string.dialogNegative), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();
                        }
                    }
                });
        /*LinearLayout myLayout=new LinearLayout(this);

        myLayout.setOrientation(LinearLayout.VERTICAL);
        myLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        TextView nameText=new TextView(this);
        LinearLayout.LayoutParams myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,16,16,16);
        nameText.setPadding(8,8,8,8);
        nameText.setLayoutParams(myParams);
        nameText.setText("Name:");

        EditText nameEditText=new EditText(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,-15,16,0);
        nameEditText.setPadding(8,8,8,8);
        nameEditText.setLayoutParams(myParams);
        nameEditText.setHint("Please type your name");
        nameEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        TextView surnameText=new TextView(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,16,16,16);
        surnameText.setLayoutParams(myParams);
        surnameText.setText("Surname:");

        EditText surnameEditText=new EditText(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,-15,16,0);
        surnameEditText.setPadding(8,8,8,8);
        surnameEditText.setLayoutParams(myParams);
        surnameEditText.setHint("Please type your surname");
        surnameEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        TextView skillsText=new TextView(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,16,16,16);
        skillsText.setLayoutParams(myParams);
        skillsText.setText("Skills Area:");

        EditText skillsEditText=new EditText(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,-15,16,0);
        skillsEditText.setPadding(8,8,8,8);
        skillsEditText.setLayoutParams(myParams);
        skillsEditText.setHint("Please type your skills area");
        skillsEditText.setInputType(InputType.TYPE_CLASS_TEXT);

        TextView phoneText=new TextView(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,16,16,16);
        phoneText.setLayoutParams(myParams);
        phoneText.setText("Phone number:");

        EditText phoneEditText=new EditText(this);
        myParams=new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        myParams.setMargins(16,-15,16,0);
        phoneEditText.setPadding(8,8,8,8);
        phoneEditText.setLayoutParams(myParams);
        phoneEditText.setHint("Please type your phone number");
        phoneEditText.setInputType(InputType.TYPE_CLASS_PHONE);

        Button submitButton=new Button(this);
        myParams=new LinearLayout.LayoutParams(122,63);
        myParams.setMargins(180,95,0,0);
        submitButton.setLayoutParams(myParams);
        submitButton.setBackgroundColor(Color.parseColor("#6200ee"));
        submitButton.setText("Submit");
        submitButton.setTextColor(000);

        myLayout.addView(nameText);
        myLayout.addView(nameEditText);
        myLayout.addView(surnameText);
        myLayout.addView(surnameEditText);
        myLayout.addView(skillsText);
        myLayout.addView(skillsEditText);
        myLayout.addView(phoneText);
        myLayout.addView(phoneEditText);
        myLayout.addView(submitButton);

        setContentView(myLayout);*/
    }
}