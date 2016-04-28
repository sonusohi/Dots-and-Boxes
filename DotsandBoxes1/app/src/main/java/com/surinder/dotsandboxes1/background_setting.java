package com.surinder.dotsandboxes1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by navpreet on 2/25/2016.
 */
public class background_setting extends Activity implements View.OnClickListener {
    @Nullable
    Activity activity;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment1_layout, container, false);
        ImageButton b1= (ImageButton) findViewById(R.id.imageButton10);
        ImageButton b2= (ImageButton) findViewById(R.id.imageButton14);
        b1.setOnClickListener(background_setting.this);
        b2.setOnClickListener(background_setting.this);
        return rootview;
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton10:
                Toast.makeText(this, "nav1", Toast.LENGTH_LONG).show();
// handle button A click;
                break;
            case R.id.imageButton14:
                Toast.makeText(this, "nav2", Toast.LENGTH_LONG).show();
// handle button B click;
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }
    }
}
