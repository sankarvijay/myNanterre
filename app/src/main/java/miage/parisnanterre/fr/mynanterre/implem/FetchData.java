package miage.parisnanterre.fr.mynanterre.implem;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.*;

/**
 * Created by Sankar Vijay on 17/02/2019.
 */
public class FetchData extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String singleParsed = "";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api-ratp.pierre-grimaud.fr/v3/schedules/rers/A/nanterre+universite/A+R");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject jo = new JSONObject(data);
            for (int i = 0; i < data.length(); i++) {
                JSONArray arr = (JSONArray) jo.getJSONObject("result").getJSONArray("schedules");

                singleParsed = "Code : " + arr.getJSONObject(i).get("code") + "\n" +
                        "Message : " + arr.getJSONObject(i).get("message") + "\n" +
                        "Destination : " + arr.getJSONObject(i).get("destination") + "\n";

                dataParsed = dataParsed + singleParsed + "\n";

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        Train.horaires.setText(this.dataParsed);
    }
}
