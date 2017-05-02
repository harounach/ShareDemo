package com.ach.haroun.fujitsu.sharedemo;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mEditText;
    Button mShareButton;
    String mMessage = "Message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.et_message_id);
        mShareButton = (Button) findViewById(R.id.share_button_id);
        mShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessage = mEditText.getText().toString();
                String mimeType = "text/plain";
                String title = "Learning how to share";
                Context context = MainActivity.this;

                Intent intent = ShareCompat.IntentBuilder.from(MainActivity.this)
                        .setChooserTitle(title)
                        .setType(mimeType)
                        .setText(mMessage)
                        .getIntent();
                mEditText.setText("");
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                }

            }
        });
    }
}
