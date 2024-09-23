import java.lang.System;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Clock implements Runnable {
    private Thread t1;
    private Thread t2;
    private Calendar cal;
    private String hour;
    private String minute;
    private String second;
    private String am_pm;
    void start() {
        t1 = new Thread(this);
        t1.start();
    }

    public void run() {
        t2 = Thread.currentThread();
        while (t2 == t1) {
            clock();
            try {
                t2.sleep(1000);
                System.out.print("\r");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void clock() {
        cal = new GregorianCalendar();
        int hr = cal.get(Calendar.HOUR);
        if ((hr > -1) && (hr < 10)) {
            hour = (hr == 0) ? "12" : "0" + String.valueOf(hr);
        } else {
            hour = String.valueOf(hr);
        }
        int min = cal.get(Calendar.MINUTE);
        if ((min > -1) && (min < 10)) {
            minute = "0" + String.valueOf(min);    
        } else {
            minute = String.valueOf(min);
        }
        int sec = cal.get(Calendar.SECOND);
        if ((sec > -1) && (sec < 10)) {
            second = "0" + String.valueOf(sec);    
        } else {
            second = String.valueOf(sec);
        }
        am_pm = (cal.get(Calendar.AM_PM) == 0) ? "AM" : "PM";
        System.out.print(hour + ":" + minute + ":" + second + " " + am_pm);
    }

    public static void main(String[] args) {
        Clock c = new Clock();
        c.start();
    }
}