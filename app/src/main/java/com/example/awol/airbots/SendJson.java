package com.example.awol.airbots;

import android.os.AsyncTask;
import android.os.Looper;
import android.util.Log;

import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.Proxy.Type.HTTP;

class SendJson extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

        String data = "";

        HttpURLConnection httpURLConnection = null;
        try {

            httpURLConnection = (HttpURLConnection) new URL(params[0]).openConnection();
            httpURLConnection.setRequestMethod("POST");

            httpURLConnection.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(httpURLConnection.getOutputStream());
            wr.writeBytes("PostData=" + params[1]);
            wr.flush();
            wr.close();

            InputStream in = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(in);

            int inputStreamData = inputStreamReader.read();
            while (inputStreamData != -1) {
                char current = (char) inputStreamData;
                inputStreamData = inputStreamReader.read();
                data += current;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

        return data;
    }
public void execute(String URL,String JSON){
doInBackground(URL,JSON);
onPostExecute("ZDone: ");
}
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.e("TAG", result); // this is expecting a response code to be sent from your server upon receiving the POST data
    }

}

public class DataDownload extends AsyncTask<String,Void,String>
{

    String result;
    String result1;


    @Override
    protected String doInBackground(String... urls)
    {

        try {

            URL url = new URL(urls[0]);

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();




            InputStream inputStream = httpURLConnection.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            int data = inputStreamReader.read();

            while (data != -1 )
            {
                char c = (char)data;

                result += c;

                data = inputStreamReader.read();

            }

            result1 = result.replaceFirst("null","");
            return result;



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


        return null;
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


            Log.i("META","ok");



        }

        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}







