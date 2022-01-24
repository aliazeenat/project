package com.example.timesaver;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.renderscript.ScriptIntrinsicResize;
import android.support.constraint.ConstraintLayout;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WaitActivity extends AppCompatActivity {

    View l1;
    View l2;
    View l3;
    View l4;
    View l5;
    View l6;
    View l7;
    View l8;
    View l9;
    View l10;
    View l11;
    View l12;
    View l13;
    View l14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        ScreenOnOffBroadcast screenOnOffBroadcast = new ScreenOnOffBroadcast();
        IntentFilter lockFilter = new IntentFilter();
        lockFilter.addAction(Intent.ACTION_SCREEN_ON);
        lockFilter.addAction(Intent.ACTION_SCREEN_OFF);
        registerReceiver(screenOnOffBroadcast, lockFilter);

        if(checkPermission() == false) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission")
                    .setMessage("Usage Permission is required for this app!")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton(android.R.string.no,  new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else {
            starter();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public void lightTheme()
    {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.clwait);
        constraintLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.small2));

        CardView cv = (CardView) findViewById(R.id.cv12wait);
        cv.setCardBackgroundColor(Color.parseColor("#e3fdfb"));

        TextView tv = (TextView) findViewById(R.id.tv1wait);
        tv.setTextColor(Color.parseColor("#80000000"));

        ImageView imv = (ImageView) findViewById(R.id.imgclock);
        imv.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avd_anim));

        l1.setBackgroundColor(Color.parseColor("#800dbab1"));
        l2.setBackgroundColor(Color.parseColor("#800dbab1"));
        l3.setBackgroundColor(Color.parseColor("#800dbab1"));
        l4.setBackgroundColor(Color.parseColor("#800dbab1"));
        l5.setBackgroundColor(Color.parseColor("#800dbab1"));
        l6.setBackgroundColor(Color.parseColor("#800dbab1"));
        l7.setBackgroundColor(Color.parseColor("#800dbab1"));
        l8.setBackgroundColor(Color.parseColor("#800dbab1"));
        l9.setBackgroundColor(Color.parseColor("#800dbab1"));
        l10.setBackgroundColor(Color.parseColor("#800dbab1"));
        l11.setBackgroundColor(Color.parseColor("#800dbab1"));
        l12.setBackgroundColor(Color.parseColor("#800dbab1"));
        l13.setBackgroundColor(Color.parseColor("#800dbab1"));
        l14.setBackgroundColor(Color.parseColor("#800dbab1"));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#085e72"));

    }

    public void darkTheme()
    {
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.clwait);
        constraintLayout.setBackground(ContextCompat.getDrawable(this, R.drawable.bluebg));

        CardView cv = (CardView) findViewById(R.id.cv12wait);
        cv.setCardBackgroundColor(Color.parseColor("#000099"));

        TextView tv = (TextView) findViewById(R.id.tv1wait);
        tv.setTextColor(Color.parseColor("#ffffff"));

        ImageView imv = (ImageView) findViewById(R.id.imgclock);
        imv.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avd_anim2));

        l1.setBackgroundColor(Color.parseColor("#80ffffff"));
        l2.setBackgroundColor(Color.parseColor("#80ffffff"));
        l3.setBackgroundColor(Color.parseColor("#80ffffff"));
        l4.setBackgroundColor(Color.parseColor("#80ffffff"));
        l5.setBackgroundColor(Color.parseColor("#80ffffff"));
        l6.setBackgroundColor(Color.parseColor("#80ffffff"));
        l7.setBackgroundColor(Color.parseColor("#80ffffff"));
        l8.setBackgroundColor(Color.parseColor("#80ffffff"));
        l9.setBackgroundColor(Color.parseColor("#80ffffff"));
        l10.setBackgroundColor(Color.parseColor("#80ffffff"));
        l11.setBackgroundColor(Color.parseColor("#80ffffff"));
        l12.setBackgroundColor(Color.parseColor("#80ffffff"));
        l13.setBackgroundColor(Color.parseColor("#80ffffff"));
        l14.setBackgroundColor(Color.parseColor("#80ffffff"));

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        window.setStatusBarColor(Color.parseColor("#00004c"));


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

    @Override
    protected void onRestart() {
        super.onRestart();
        setTheme();
    }

    public void starter()
    {


        l1 = (View) findViewById(R.id.tt1);
        l2 = (View) findViewById(R.id.tt2);
        l3 = (View) findViewById(R.id.tt3);
        l4 = (View) findViewById(R.id.tt4);
        l5 = (View) findViewById(R.id.tt5);
        l6 = (View) findViewById(R.id.tt6);
        l7 = (View) findViewById(R.id.tt7);
        l8 = (View) findViewById(R.id.tt8);
        l9 = (View) findViewById(R.id.tt9);
        l10 = (View) findViewById(R.id.tt10);
        l11 = (View) findViewById(R.id.tt11);
        l12 = (View) findViewById(R.id.tt12);
        l13 = (View) findViewById(R.id.tt13);
        l14 = (View) findViewById(R.id.tt14);

        final CardView cv = (CardView) findViewById(R.id.cv12wait);
        cv.setVisibility(View.VISIBLE);

        //Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
        //startActivity(intent);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(WaitActivity.this, MainActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(WaitActivity.this, cv, "transCard");
                startActivity(intent, options.toBundle());

            }
        }, 4500);


        //lightTheme();
        setTheme();

        cv.animate()
                .translationY(Resources.getSystem().getDisplayMetrics().heightPixels / 6)
                .alpha(1.0f)
                .setDuration(1000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);

                        ImageView imv = (ImageView) findViewById(R.id.imgclock);
                        imv.setVisibility(View.VISIBLE);
                        Drawable d = imv.getDrawable();
                        if (d instanceof AnimatedVectorDrawableCompat) {
                            AnimatedVectorDrawableCompat avd = (AnimatedVectorDrawableCompat) d;
                            avd.start();
                        } else if (d instanceof AnimatedVectorDrawable) {
                            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) d;
                            avd.start();
                        }
                    }
                });


        final TextView tv = (TextView) findViewById(R.id.tv1wait);

        tv.animate()
                .translationY(0)
                .alpha(0.0f)
                .setDuration(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        tv.animate()
                                .translationY(0)
                                .alpha(1.0f)
                                .setDuration(3000)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                    }
                                });
                    }
                });


        final LinearLayout ll = (LinearLayout) findViewById(R.id.linearforanim);

        ll.animate()
                .translationY(0)
                .alpha(0.0f)
                .setDuration(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        ll.animate()
                                .translationY(100)
                                .alpha(1.0f)
                                .setDuration(2000)
                                .setListener(new AnimatorListenerAdapter() {
                                    @Override
                                    public void onAnimationEnd(Animator animation) {
                                        super.onAnimationEnd(animation);
                                    }
                                });
                    }
                });

    }



    public boolean checkPermission()
    {
        try {
            PackageManager packageManager = getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            AppOpsManager appOpsManager = (AppOpsManager) getSystemService(Context.APP_OPS_SERVICE);
            int mode = appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_GET_USAGE_STATS, applicationInfo.uid, applicationInfo.packageName);
            return (mode == AppOpsManager.MODE_ALLOWED);

        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
