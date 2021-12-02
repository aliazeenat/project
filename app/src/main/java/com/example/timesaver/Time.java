package com.example.timesaver;

public class Time {
    private int hours;
    private int min;
    private int sec;

    public Time()
    {}

    public Time(int hours, int min, int sec) {
        this.hours = hours;
        this.min = min;
        this.sec = sec;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public Time nextSec(Time time)
    {
        time.setSec(time.getSec()+1);
        if (time.getSec()==60)
        {
            time.setSec(0);
            time.setMin(time.getMin()+1);
        }
        if(time.getMin()==60)
        {
            time.setMin(0);
            time.setHours(time.getHours()+1);
        }
        return time;
    }

    public String toString(Time time)
    {
        String s = "";

        s = time.getHours()+"H "+time.getMin()+"M";

        return s;
    }
}
