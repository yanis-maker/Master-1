package com.example.applicationtest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

public class CallActivity extends AppCompatActivity {

    private static final int REQUEST_CALL=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Bundle data=getIntent().getExtras();
        String phone=data.getString("phone");

        (findViewById(R.id.callButton))
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(ContextCompat.checkSelfPermission(CallActivity.this,
                                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            ActivityCompat.requestPermissions(CallActivity.this,
                                    new String[] {Manifest.permission.CALL_PHONE},REQUEST_CALL);
                        }
                        else {
                            Uri phone_number = Uri.parse("tel:"+phone);
                            Intent intent = new Intent(Intent.ACTION_CALL, phone_number);
                            startActivity(intent);
                        }
                    }
                });



    }
}
