package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText website, phone;
    String TAGNAME = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        website = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
    }
    public void close_app(View V){

        close_app(V);
    }
    public void go_to_website(View view) {
        String s = website.getText().toString();
        Log.e(TAGNAME, "go_to_website"+ s);
        if (!s.startsWith("https://") && !s.startsWith("http://")){
            s = "http://" + s;
        }

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
        startActivity(intent);
    }

    public void call_to_phone(View view) {
        String phone_number  = phone.getText().toString();
        Log.e(TAGNAME, phone_number);

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+phone_number));

       if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions

           // Log.e("MainActivity after2", phone_number);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
           // return;
           requestPermissions();
       }
       else {
           Log.e(TAGNAME, "caa_to_phone else");
           startActivity(intent);
       }
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
    }
}
