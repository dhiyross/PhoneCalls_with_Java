package com.example.phonecalls;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
Button btn_call;
    EditText ed_nomor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_call = (Button) findViewById(R.id.btn_call);
        ed_nomor = (EditText) findViewById(R.id.ed_telp);

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeCall();
            }
        });
    }
    protected void makeCall(){
        Log.i("Make Call", "");
        String telp = ed_nomor.getText().toString();
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:"+telp));
        try {
            startActivity(phoneIntent);
            finish();
            Log.i("Finished making call...", "");
        } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(MainActivity.this, "Call invalid, please try again later.");
            Toast.LENGTH_SHORT).show();
        }
    }
}