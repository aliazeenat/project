package com.example.timesaver;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    public static TextView tv;
    public static ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        tv = (TextView) findViewById(R.id.help);
        pb = (ProgressBar) findViewById(R.id.progressBarh);

        FetchData fetchData = new FetchData();
        fetchData.execute();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar4);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setTheme();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    public void setTheme()
    {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("Mypref",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int theme = sharedPreferences.getInt("Theme",0);
        if (theme == 0)
            lightTheme();
        else
            darkTheme();
    }

    public void lightTheme()
    {

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.ll123);

        linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.small2));


        getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradientgraytablayout));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#085e72"));

    }

    public void darkTheme()
    {

        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.ll123);

        linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.bluebg));

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00007f")));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#00004c"));


    }
}
