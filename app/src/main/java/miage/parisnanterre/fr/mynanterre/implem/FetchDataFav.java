package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Intent;
import android.os.StrictMode;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 23/02/2019.
 */

public class FetchDataFav extends AsyncTask<Void, Void, Void> {
    String data = "";
    String dataParsed = "";
    String dataParsed2 = "";
    String dataParsed3 = "";
    String singleParsed = "";
    String singleParsed2 = "";
    String singleParsed3 = "";
    String gareFavori = "";
    String lien = "";

    public FetchDataFav(String gare) {
        this.gareFavori = gare;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {

            System.out.println("Gaare : " + gareFavori);
            switch (gareFavori) {
                case "Saint-Germain-en-Laye":
                    lien = "https://api-ratp.pierre-grimaud.fr/v3/schedules/rers/A/saint+germain+en+laye/R";
                    break;
                case "Le Vesinet-Le Pecq":
                    lien = "https://api-ratp.pierre-grimaud.fr/v3/schedules/rers/A/le+vesinet+le+pecq/R";
                    break;
                case "Le Vesinet-Centre":
                    lien = "https://api-ratp.pierre-grimaud.fr/v3/schedules/rers/A/le+vesinet+centre/R";
                    break;
                default:
                    System.out.println("no match");
            }

            URL url = new URL(lien);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject jo = new JSONObject(data);

            for (int i = 0; i <= data.length(); i++) {
                JSONArray arr = (JSONArray) jo.getJSONObject("result").getJSONArray("schedules");

                singleParsed = arr.getJSONObject(i).get("message") + "\n";

                dataParsed = dataParsed + singleParsed;

                singleParsed2 = arr.getJSONObject(i).get("code") + "\n";
                dataParsed2 = dataParsed2 + singleParsed2;

                singleParsed3 = arr.getJSONObject(i).get("destination") + "\n";
                dataParsed3 = dataParsed3 + singleParsed3;

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

        GareFavorite.code.setText(this.dataParsed2);
        GareFavorite.heureT.setText(this.dataParsed);
        GareFavorite.destination.setText(this.dataParsed3);
        GareFavorite.direction.setText(gareFavori);
        GareFavorite.direction2.setText("vers Nanterre-Université");

    }
}