package com.example.applicationtest;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle data=getIntent().getExtras();
        setContentView(R.layout.activity_display);
        Resources res=getResources();

        TextView nameView=findViewById(R.id.nameView);
        TextView firstNameView=findViewById(R.id.firstNameView);
        TextView AgeView=findViewById(R.id.AgeView);
        TextView skillsView=findViewById(R.id.skillsView);
        TextView phoneView=findViewById(R.id.phoneView);

        String name=res.getString(R.string.name)+data.getString("name");
        String firstName=res.getString(R.string.surname)+data.getString("firstName");
        String age=res.getString(R.string.age)+data.getString("age");
        String skills=res.getString(R.string.skills)+data.getString("skills");
        String phone=res.getString(R.string.phone)+data.getString("phone");

        nameView.setText(name);
        firstNameView.setText(firstName);
        AgeView.setText(age);
        skillsView.setText(skills);
        phoneView.setText(phone);

        (findViewById(R.id.returnButton)).
                setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(DisplayActivity.this,MainActivity.class);
                        intent.putExtras(data);
                        startActivity(intent);
                    }
                });

        (findViewById(R.id.confirmButton))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(DisplayActivity.this,CallActivity.class);
                        intent.putExtras(data);
                        startActivity(intent);
                    }
                });



    }
}
