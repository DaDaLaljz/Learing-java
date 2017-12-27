package com.example.dell.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentURL extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_url);
        Button bn = (Button)findViewById(R.id.bn);
        final EditText et = (EditText)findViewById(R.id.et);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* String edittext=et.getText().toString();
                String data = edittext;
                Uri uri = Uri.parse(data);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);*/
                String url=et.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });
    }
}
