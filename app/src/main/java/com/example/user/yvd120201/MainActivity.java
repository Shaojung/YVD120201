package com.example.user.yvd120201;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText editText;
    TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = getSharedPreferences("mydata", MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.editText);
        tv2 = (TextView) findViewById(R.id.textView2);
    }

    public void clickWrite(View v)
    {
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("name", editText.getText().toString());
        ed.commit();
    }

    public void clickRead(View v)
    {
        String str = sp.getString("name", "Default");
        tv2.setText(str);
    }

    public void clickSettings(View v)
    {
        Intent it = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(it);
    }

    public void clickRead2(View v)
    {
        SharedPreferences sp2 = getSharedPreferences(getPackageName() + "_preferences", MODE_PRIVATE);
        String str = sp2.getString("example_text", "DEFAULT");
        tv2.setText(str);
    }
}
