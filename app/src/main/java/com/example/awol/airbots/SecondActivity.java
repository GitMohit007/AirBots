package com.example.awol.airbots;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toolbar;

import org.json.JSONException;
import org.json.JSONObject;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button submitButton = (Button) findViewById(R.id.mess);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name="ZELONE",address="ADDRESS FROM APPLICATION MOBILE";
                JSONObject postData = new JSONObject();
                try {
                    postData.put("name", name);
                    postData.put("address", address);
                    postData.put("kill","mohit");
                    Log.e("msg",""+ postData.toString());
                    new SendJson().execute("http://10.4.168.87:205/", postData.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try
        {



            Log.i("result1",result);


            JSONObject jsonObject = new JSONObject(result1);


            JSONObject results  = jsonObject.getJSONObject("results");

            JSONObject USD_INR  = results.getJSONObject("USD_INR");


            getConversionRate = USD_INR.getDouble("val");
            Log.i("META",getConversionRate.toString());



        }

        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

}

