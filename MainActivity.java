package com.lesson2.serj.myfirstjson;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class MainActivity extends ActionBarActivity {

    TextView tv_1;
    String secondManName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = (TextView)findViewById(R.id.textView_1);

        //------------------------------

        String text = "test.json";
        byte[] buffer = null;
        InputStream is;
        try {

            is = getAssets().open(text);
            int size = is.available();
            buffer = new byte[size];
            is.read(buffer);
            is.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String str = new String(buffer);


        //---------------------------------

        JSONParser parser = new JSONParser();
        Object obj = null;
            try {
                obj = parser.parse(str);
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray ja = (JSONArray) jsonObj.get("people");
        System.out.println(ja.get(1));
        jsonObj = (JSONObject) ja.get(1);
        secondManName = (String) jsonObj.get("name");
        tv_1.append(secondManName);




    }
}
