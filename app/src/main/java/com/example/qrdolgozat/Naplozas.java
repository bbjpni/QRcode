package com.example.qrdolgozat;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Naplozas {

    public static void Kiiratas(String text){
        Date d = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String idopont = format.format(d);

        String sor = String.format("%s,%s", text, idopont);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED))
        {
            try {
                File f = new File(Environment.getExternalStorageDirectory(), "scannedCodes.csv");
                BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
                bw.append(sor);
                bw.append(System.lineSeparator());
                bw.close();
            } catch (IOException e) {
                Log.d("Kiiratas", e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
