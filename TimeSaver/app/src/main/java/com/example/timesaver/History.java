package com.example.timesaver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link History.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link History#newInstance} factory method to
 * create an instance of this fragment.
 */
public class History extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    ConstraintLayout cl1,cl2,cl3,cl4,cl5,cl6,cl7;
    View vv1,vv2,vv3,vv4,vv5,vv6,vv7,vv8,vv9,vv10,vv11,vv12,vv13,vv14,vv15,vv16,vv17,vv18,vv19,vv20,vv21,vv22,vv23,vv24,vv25,vv26,vv27,vv28;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public History() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment History.
     */
    // TODO: Rename and change types and number of parameters
    public static History newInstance(String param1, String param2) {
        History fragment = new History();
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
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_history, container, false);

        tv1 = (TextView) view.findViewById(R.id.tv31);
        tv2 = (TextView) view.findViewById(R.id.tv32);
        tv3 = (TextView) view.findViewById(R.id.tv33);
        tv4 = (TextView) view.findViewById(R.id.tv34);
        tv5 = (TextView) view.findViewById(R.id.tv35);
        tv6 = (TextView) view.findViewById(R.id.tv36);
        tv7 = (TextView) view.findViewById(R.id.tv37);

        cl1 = (ConstraintLayout) view.findViewById(R.id.cl31);
        cl2 = (ConstraintLayout) view.findViewById(R.id.cl32);
        cl3 = (ConstraintLayout) view.findViewById(R.id.cl33);
        cl4 = (ConstraintLayout) view.findViewById(R.id.cl34);
        cl5 = (ConstraintLayout) view.findViewById(R.id.cl35);
        cl6 = (ConstraintLayout) view.findViewById(R.id.cl36);
        cl7 = (ConstraintLayout) view.findViewById(R.id.cl37);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        calendar.add(Calendar.DATE, -1);
        tv1.setText(dateFormat.format(calendar.getTime()).toString());

        calendar.add(Calendar.DATE, -1);
        tv2.setText(dateFormat.format(calendar.getTime()).toString());

        calendar.add(Calendar.DATE, -1);
        tv3.setText(dateFormat.format(calendar.getTime()).toString());

        calendar.add(Calendar.DATE, -1);
        tv4.setText(dateFormat.format(calendar.getTime()).toString());

        calendar.add(Calendar.DATE, -1);
        tv5.setText(dateFormat.format(calendar.getTime()).toString());

        calendar.add(Calendar.DATE, -1);
        tv6.setText(dateFormat.format(calendar.getTime()).toString());

        calendar.add(Calendar.DATE, -1);
        tv7.setText(dateFormat.format(calendar.getTime()).toString());


        cl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HistoryDetails.class);
                int day = -1;
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

        cl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HistoryDetails.class);
                int day = -2;
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

        cl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HistoryDetails.class);
                int day = -3;
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

        cl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HistoryDetails.class);
                int day = -4;
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

        cl5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HistoryDetails.class);
                int day = -5;
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

        cl6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),HistoryDetails.class);
                int day = -6;
                intent.putExtra("day", day);
                startActivity(intent);
            }
        });

        cl7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(),HistoryDetails.class);
                //int day = -5;
                //intent.putExtra("day", day);
                //startActivity(intent);
            }
        });


        View vv1 = (View) view.findViewById(R.id.vv1);
        View vv2 = (View) view.findViewById(R.id.vv2);
        View vv3 = (View) view.findViewById(R.id.vv3);
        View vv4 = (View) view.findViewById(R.id.vv4);
        View vv5 = (View) view.findViewById(R.id.vv5);
        View vv6 = (View) view.findViewById(R.id.vv6);
        View vv7 = (View) view.findViewById(R.id.vv7);
        View vv8 = (View) view.findViewById(R.id.vv8);
        View vv9 = (View) view.findViewById(R.id.vv9);
        View vv10 = (View) view.findViewById(R.id.vv10);
        View vv11 = (View) view.findViewById(R.id.vv11);
        View vv12 = (View) view.findViewById(R.id.vv12);
        View vv13 = (View) view.findViewById(R.id.vv13);
        View vv14 = (View) view.findViewById(R.id.vv14);
        View vv15 = (View) view.findViewById(R.id.vv15);
        View vv16 = (View) view.findViewById(R.id.vv16);
        View vv17 = (View) view.findViewById(R.id.vv17);
        View vv18 = (View) view.findViewById(R.id.vv18);
        View vv19 = (View) view.findViewById(R.id.vv19);
        View vv20 = (View) view.findViewById(R.id.vv20);
        View vv21 = (View) view.findViewById(R.id.vv21);
        View vv22 = (View) view.findViewById(R.id.vv22);
        View vv23 = (View) view.findViewById(R.id.vv23);
        View vv24 = (View) view.findViewById(R.id.vv24);
        View vv25 = (View) view.findViewById(R.id.vv25);
        View vv26 = (View) view.findViewById(R.id.vv26);
        View vv27 = (View) view.findViewById(R.id.vv27);
        View vv28 = (View) view.findViewById(R.id.vv28);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String arg) {
        if (mListener != null) {
            mListener.onFragmentInteraction(arg);
        }
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

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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



    public void lightTheme()
    {
/*
        vv1.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv2.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv3.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv4.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv5.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv6.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv7.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv8.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv9.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv10.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv11.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv12.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv13.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv14.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv15.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv16.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv17.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv18.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv19.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv20.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv21.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv22.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv23.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv24.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv25.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv26.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv27.setBackgroundColor(Color.parseColor("#e3fdfb"));
        vv28.setBackgroundColor(Color.parseColor("#e3fdfb"));
*/
        //LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.ll123);

        //linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.small2));


        //getSupportActionBar().setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.gradientgraytablayout));

        //Window window = getWindow();
        //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        //window.setStatusBarColor(Color.parseColor("#085e72"));

    }

    public void darkTheme()
    {
        /*
        vv1.setBackgroundColor(Color.parseColor("#00007f"));
        vv2.setBackgroundColor(Color.parseColor("#00007f"));
        vv3.setBackgroundColor(Color.parseColor("#00007f"));
        vv4.setBackgroundColor(Color.parseColor("#00007f"));
        vv5.setBackgroundColor(Color.parseColor("#00007f"));
        vv6.setBackgroundColor(Color.parseColor("#00007f"));
        vv7.setBackgroundColor(Color.parseColor("#00007f"));
        vv8.setBackgroundColor(Color.parseColor("#00007f"));
        vv9.setBackgroundColor(Color.parseColor("#00007f"));
        vv10.setBackgroundColor(Color.parseColor("#00007f"));
*/
        //LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.ll123);

        //linearLayout1.setBackground(ContextCompat.getDrawable(this, R.drawable.bluebg));

        //getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00007f")));

        //Window window = getWindow();
        //window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        //window.setStatusBarColor(Color.parseColor("#00004c"));


    }


}
