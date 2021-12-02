package com.example.timesaver;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Today.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Today#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Today extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    Context context;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private boolean againStart;

    private int totalHour;
    private int totalMin;

    private CardView cv1;
    private CardView cv2;
    private CardView cv3;
    private CardView cv4;
    private TextView tv1;
    private TextView timev12;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private TextView tv10;
    private TextView tv11;
    private TextView tv12;
    private TextView tv13;

    private View view1;
    private View view2;
    private View view3;

    private Button Buttonup;
    ImageView img2;

    View linearLayout1;
    View linearLayout2;
    View linearLayout3;

    private boolean threadRunning;

    public Today() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Today.
     */
    // TODO: Rename and change types and number of parameters
    public static Today newInstance(String param1, String param2) {
        Today fragment = new Today();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_today, container, false);
        // Inflate the layout for this fragment

        cv1 = (CardView) view.findViewById(R.id.cv11);
        cv2 = (CardView) view.findViewById(R.id.cv12);
        cv3 = (CardView) view.findViewById(R.id.cv13);
        cv4 = (CardView) view.findViewById(R.id.cv14);

        cv2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                cv2.getViewTreeObserver().removeOnPreDrawListener(this);
                getActivity().startPostponedEnterTransition();
                return true;
            }
        });


        tv1 = (TextView) view.findViewById(R.id.tv11);
        timev12 = (TextView) view.findViewById(R.id.timev12);
//        tv3 = (TextView) view.findViewById(R.id.tv13);
        tv4 = (TextView) view.findViewById(R.id.tv14);
        tv5 = (TextView) view.findViewById(R.id.tv15);
        tv7 = (TextView) view.findViewById(R.id.tv17);
        tv8 = (TextView) view.findViewById(R.id.tv18);
        tv9 = (TextView) view.findViewById(R.id.tv19);
        tv10 = (TextView) view.findViewById(R.id.tv110);
        tv11 = (TextView) view.findViewById(R.id.tv111);
        tv12 = (TextView) view.findViewById(R.id.tv112);
        tv13 = (TextView) view.findViewById(R.id.timevsec);

        Buttonup = (Button) view.findViewById(R.id.buttonup);

        view1 = (View) view.findViewById(R.id.ll11);
        view2 = (View) view.findViewById(R.id.ll12);
        view3 = (View) view.findViewById(R.id.ll13);


        linearLayout1 = (View) view.findViewById(R.id.cirsec1);
        linearLayout2 = (View) view.findViewById(R.id.cirmin1);
        linearLayout3 = (View) view.findViewById(R.id.cirhour1);

        int width1  = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height1 = Resources.getSystem().getDisplayMetrics().heightPixels;

        ViewGroup.LayoutParams params1 = linearLayout1.getLayoutParams();

        params1.height = (width1/2)-(width1/8);
        params1.width = (width1/2)-(width1/8);
        linearLayout1.setLayoutParams(params1);

        ViewGroup.LayoutParams params2 = linearLayout2.getLayoutParams();

        params2.height = (width1/2);
        params2.width = (width1/2);
        linearLayout2.setLayoutParams(params2);

        ViewGroup.LayoutParams params3 = linearLayout3.getLayoutParams();

        params3.height = (width1/2)+(width1/8);
        params3.width = (width1/2)+(width1/8);
        linearLayout3.setLayoutParams(params3);

        ScrollView sv1 = (ScrollView) view.findViewById(R.id.sv1);

        img2 = (ImageView) view.findViewById(R.id.imgicon111);

        againStart = false;

        return view;
    }

    @Override
    public void onResume() {


        super.onResume();
        startMovement();
        final Calendar cal1 = Calendar.getInstance();
        //cal1.add(Calendar.DAY_OF_MONTH, -1);
        cal1.set(Calendar.HOUR_OF_DAY,00);
        cal1.set(Calendar.MINUTE,00);
        cal1.set(Calendar.SECOND,00);

        final Calendar cal2 = Calendar.getInstance();
        //cal2.add(Calendar.DAY_OF_MONTH, 1);
        cal2.set(Calendar.HOUR_OF_DAY,23);
        cal2.set(Calendar.MINUTE,59);
        cal2.set(Calendar.SECOND,59);

        UsageTime usageTime = new UsageTime(getContext(),cal1,cal2);
        AppInfoList appInfo = usageTime.mostUsedApp();

        img2.setImageDrawable(appInfo.getAppIco());
        tv11.setText(appInfo.getAppName());
        String strTime = "";
        int hour = (appInfo.getAppTime()/60)%24;
        int min = appInfo.getAppTime()%60;
        strTime = hour+"H "+min+"M";
        tv12.setText(strTime);

        int totalTime = usageTime.getTotalTime();
        strTime = "";
        hour = (totalTime/60)%24;
        min = totalTime%60;
        totalHour = hour;
        totalMin = min;
        strTime = hour+"H "+min+"M";
        timev12.setText(strTime);
        tv5.setText(strTime);

        if (againStart == false) {
            setTheme();
            startClock();
        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String arg) {
        if (mListener != null) {
            mListener.onFragmentInteraction(arg);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        againStart = true;

        view1.setVisibility(View.INVISIBLE);
        view2.setVisibility(View.INVISIBLE);
        view3.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }

    }

    public void setTheme()
    {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("Mypref",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int theme = sharedPreferences.getInt("Theme",0);
        if (theme == 0)
            setLightTheme();
        else
            setDarkTheme();

    }



    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        threadRunning = false;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String arg);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        againStart = true;
    }

    public void setLightTheme()
    {
        //Context context = getContext();

        cv1.setCardBackgroundColor(Color.parseColor("#50e3fdfb"));
        cv2.setCardBackgroundColor(Color.parseColor("#e3fdfb"));
        cv3.setCardBackgroundColor(Color.parseColor("#50e3fdfb"));
        cv4.setCardBackgroundColor(Color.parseColor("#50e3fdfb"));

        tv1.setTextColor(Color.BLACK);
        timev12.setTextColor(Color.BLACK);
    //    tv3.setTextColor(Color.BLACK);
        tv4.setTextColor(Color.BLACK);
        tv5.setTextColor(Color.parseColor("#ff1111"));

        tv7.setTextColor(Color.BLACK);
        tv8.setTextColor(Color.parseColor("#ff1111"));
        tv9.setTextColor(Color.BLACK);
        tv10.setTextColor(Color.BLACK);
        tv11.setTextColor(Color.BLACK);
        tv13.setTextColor(Color.BLACK);
        tv12.setTextColor(Color.parseColor("#ff1111"));

        Buttonup.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.ic_keyboard_arrow_up_white));

        view1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circleseclight));
        view2.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circleminlight));
        view3.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlehourlight));


        linearLayout1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circleseclight));
        linearLayout2.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circleminlight));
        linearLayout3.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlehourlight));


    }

    public void setDarkTheme()
    {
        //Context context = getContext();

        cv1.setCardBackgroundColor(Color.parseColor("#500000e5"));
        cv2.setCardBackgroundColor(Color.parseColor("#000099"));
        cv3.setCardBackgroundColor(Color.parseColor("#500000e5"));
        cv4.setCardBackgroundColor(Color.parseColor("#500000e5"));

        tv1.setTextColor(Color.WHITE);
        timev12.setTextColor(Color.WHITE);
    //  tv3.setTextColor(Color.WHITE);
        tv4.setTextColor(Color.WHITE);
        tv5.setTextColor(Color.parseColor("#ff1111"));

        tv7.setTextColor(Color.WHITE);
        tv8.setTextColor(Color.parseColor("#ff1111"));
        tv9.setTextColor(Color.WHITE);
        tv10.setTextColor(Color.WHITE);
        tv11.setTextColor(Color.WHITE);
        tv13.setTextColor(Color.WHITE);
        tv12.setTextColor(Color.parseColor("#ff1111"));

        Buttonup.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.ic_keyboard_arrow_up));


        view1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlesec));
        view2.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlemin));
        view3.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlehour));


        linearLayout1.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlesec));
        linearLayout2.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlemin));
        linearLayout3.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.circlehour));


    }


    public void startClock()
    {
        threadRunning = true;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Time time = new Time(totalHour,totalMin,23);
                while(threadRunning==true){

                    time = time.nextSec(time);
                    try{Thread.sleep(1000);}catch (Exception e){}
                    final String s = time.toString(time);
                    int sec = time.getSec();
                    final String s2;

                    if (sec<10)
                        s2 = "0"+sec;
                    else
                        s2 = ""+sec;

                    timev12.post(new Runnable() {
                        @Override
                        public void run() {
                            timev12.setText(s);
                        }
                    });

                    tv13.post(new Runnable() {
                        @Override
                        public void run() {
                            tv13.setText(s2);
                        }
                    });

                    if (threadRunning == false)
                        break;

                }
            }
        });
        thread.start();


    }

    void startMovement()
    {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                final int width  = Resources.getSystem().getDisplayMetrics().widthPixels;
                final int height = Resources.getSystem().getDisplayMetrics().heightPixels;

                try{Thread.sleep(2000);}catch (Exception e){}

                view1.post(new Runnable() {
                    @Override
                    public void run() {
                        Animation anim2 = new MyAnimation(view1, (width/4)-(width/16));
                        anim2.setDuration(5000);
                        anim2.setRepeatCount(Animation.INFINITE);
                        view1.setVisibility(View.VISIBLE);
                        view1.startAnimation(anim2);
                    }
                });


                try{Thread.sleep(1000);}catch (Exception e){}

                view2.post(new Runnable() {
                    @Override
                    public void run() {

                        Animation anim = new MyAnimation(view2, (width/4));
                        anim.setDuration(5000);
                        anim.setRepeatCount(Animation.INFINITE);
                        view2.setVisibility(View.VISIBLE);
                        view2.startAnimation(anim);
                    }
                });


                try{Thread.sleep(1000);}catch (Exception e){}


                view3.post(new Runnable() {
                    @Override
                    public void run() {

                        Animation anim3 = new MyAnimation(view3, (width/4)+(width/16));
                        anim3.setDuration(5000);
                        anim3.setRepeatCount(Animation.INFINITE);
                        view3.setVisibility(View.VISIBLE);
                        view3.startAnimation(anim3);
                    }
                });
            }
        });
        thread2.start();

    }
}
