package com.example.timesaver;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Details.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Details#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Details extends Fragment {
    Context mcontext;
    ArrayList<AppInfoList> appInfoList;
    ImageView img1,img2,img3,img4,img5;
    TextView tv1,tv2,tv3,tv4,tv5,tv33;
    TextView tvt1,tvt2,tvt3,tvt4,tvt5;
    ProgressBar pb1,pb2,pb3,pb4,pb5;
    Button button;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Details() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Details.
     */
    // TODO: Rename and change types and number of parameters
    public static Details newInstance(String param1, String param2) {
        Details fragment = new Details();
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
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        Button button = (Button) view.findViewById(R.id.viewallbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ShowAllApps.class);
                startActivity(intent);
            }
        });

        img1 = (ImageView) view.findViewById(R.id.appIcon1);
        img2 = (ImageView) view.findViewById(R.id.appIcon2);
        img3 = (ImageView) view.findViewById(R.id.appIcon3);
        img4 = (ImageView) view.findViewById(R.id.appIcon4);
        img5 = (ImageView) view.findViewById(R.id.appIcon5);

        tv1 = (TextView) view.findViewById(R.id.appName1);
        tv2 = (TextView) view.findViewById(R.id.appName2);
        tv3 = (TextView) view.findViewById(R.id.appName3);
        tv4 = (TextView) view.findViewById(R.id.appName4);
        tv5 = (TextView) view.findViewById(R.id.appName5);

        tvt1 = (TextView) view.findViewById(R.id.appUsed1);
        tvt2 = (TextView) view.findViewById(R.id.appUsed2);
        tvt3 = (TextView) view.findViewById(R.id.appUsed3);
        tvt4 = (TextView) view.findViewById(R.id.appUsed4);
        tvt5 = (TextView) view.findViewById(R.id.appUsed5);

        pb1 = (ProgressBar) view.findViewById(R.id.progressBar231);
        pb2 = (ProgressBar) view.findViewById(R.id.progressBar232);
        pb3 = (ProgressBar) view.findViewById(R.id.progressBar233);
        pb4 = (ProgressBar) view.findViewById(R.id.progressBar234);
        pb5 = (ProgressBar) view.findViewById(R.id.progressBar235);


        tv33 = (TextView) view.findViewById(R.id.textView3);
        String per = "";

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
        int totalTime = usageTime.getTotalTime();

        cal1.add(Calendar.DAY_OF_MONTH, -1);

        cal2.add(Calendar.DAY_OF_MONTH, -1);

        usageTime = new UsageTime(getContext(),cal1,cal2);
        totalTime = totalTime + usageTime.getTotalTime();

        cal1.add(Calendar.DAY_OF_MONTH, -2);

        cal2.add(Calendar.DAY_OF_MONTH, -2);

        usageTime = new UsageTime(getContext(),cal1,cal2);
        totalTime = totalTime + usageTime.getTotalTime();

        cal1.add(Calendar.DAY_OF_MONTH, -3);

        cal2.add(Calendar.DAY_OF_MONTH, -3);

        usageTime = new UsageTime(getContext(),cal1,cal2);
        totalTime = totalTime + usageTime.getTotalTime();



        int avgHour = (totalTime/60)/4;

        if (avgHour<=1)
        {
            per = "10%";
        }
        else if (avgHour<=3)
        {
            per = "30%";
        }
        else if (avgHour<=6)
        {
            per = "50%";
        }
        else if (avgHour<=9)
        {
            per = "80%";
        }
        else
        {
            per = "100%";
        }

        tv33.setText(per);

        button = (Button) view.findViewById(R.id.buttonup2);
        button.setBackground(ContextCompat.getDrawable(getContext(),R.drawable.ic_keyboard_arrow_up_white));

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String str) {
        if (mListener != null) {
            mListener.onFragmentInteraction(str);
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
        mcontext = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onResume() {
        super.onResume();
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
        appInfoList = usageTime.getAppInfoList();


        img1.setImageDrawable(appInfoList.get(appInfoList.size()-1).getAppIco());
        img2.setImageDrawable(appInfoList.get(appInfoList.size()-2).getAppIco());
        img3.setImageDrawable(appInfoList.get(appInfoList.size()-3).getAppIco());
        img4.setImageDrawable(appInfoList.get(appInfoList.size()-4).getAppIco());
        img5.setImageDrawable(appInfoList.get(appInfoList.size()-5).getAppIco());

        tv1.setText(appInfoList.get(appInfoList.size()-1).getAppName());
        tv2.setText(appInfoList.get(appInfoList.size()-2).getAppName());
        tv3.setText(appInfoList.get(appInfoList.size()-3).getAppName());
        tv4.setText(appInfoList.get(appInfoList.size()-4).getAppName());
        tv5.setText(appInfoList.get(appInfoList.size()-5).getAppName());

        String strTime = "";
        int hour = appInfoList.get(appInfoList.size()-1).getAppTime()/60;
        int min = appInfoList.get(appInfoList.size()-1).getAppTime()%60;
        strTime = hour+"H "+min+"M";
        tvt1.setText(strTime);
        hour = appInfoList.get(appInfoList.size()-2).getAppTime()/60;
        min = appInfoList.get(appInfoList.size()-2).getAppTime()%60;
        strTime = hour+"H "+min+"M";
        tvt2.setText(strTime);
        hour = appInfoList.get(appInfoList.size()-3).getAppTime()/60;
        min = appInfoList.get(appInfoList.size()-3).getAppTime()%60;
        strTime = hour+"H "+min+"M";
        tvt3.setText(strTime);
        hour = appInfoList.get(appInfoList.size()-4).getAppTime()/60;
        min = appInfoList.get(appInfoList.size()-4).getAppTime()%60;
        strTime = hour+"H "+min+"M";
        tvt4.setText(strTime);
        hour = appInfoList.get(appInfoList.size()-5).getAppTime()/60;
        min = appInfoList.get(appInfoList.size()-5).getAppTime()%60;
        strTime = hour+"H "+min+"M";
        tvt5.setText(strTime);

        int num = ((appInfoList.get(appInfoList.size()-1).getAppTime()*100)/appInfoList.get(appInfoList.size()-1).getAppTime());
        pb1.setProgress(num);
        num = ((appInfoList.get(appInfoList.size()-2).getAppTime()*100)/appInfoList.get(appInfoList.size()-1).getAppTime());
        pb2.setProgress(num);
        num = ((appInfoList.get(appInfoList.size()-3).getAppTime()*100)/appInfoList.get(appInfoList.size()-1).getAppTime());
        pb3.setProgress(num);
        num = ((appInfoList.get(appInfoList.size()-4).getAppTime()*100)/appInfoList.get(appInfoList.size()-1).getAppTime());
        pb4.setProgress(num);
        num = ((appInfoList.get(appInfoList.size()-5).getAppTime()*100)/appInfoList.get(appInfoList.size()-1).getAppTime());
        pb5.setProgress(num);
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
        void onFragmentInteraction(String str);
    }

    public void setArrayList(ArrayList<AppInfoList> arr)
    {
        appInfoList = new ArrayList<>();

        for (int i = 0; i < arr.size() ; i++) {
            appInfoList.add(arr.get(i));
        }
    }
}
