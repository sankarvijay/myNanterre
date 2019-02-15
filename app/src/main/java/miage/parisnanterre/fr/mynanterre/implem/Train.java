package miage.parisnanterre.fr.mynanterre.implem;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 09/02/2019.
 */
public class Train extends AppCompatActivity {
    TextView horaires;  // This will reference our repo list text box.
    RequestQueue requestQueue;  // This is our requests queue to process our HTTP requests.

    String baseUrl = "https://api-ratp.pierre-grimaud.fr/v3/schedules/rers/A/nanterre+universite/A+R";  // This is the API base URL (GitHub API)
    String url;  // This will hold the full URL which will include the username entered in the etGitHubUser.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_horaires);

        this.horaires = (TextView) findViewById(R.id.horaire);  // Link our repository list text output box.
        this.horaires.setMovementMethod(new ScrollingMovementMethod());  // This makes our text box scrollable, for those big GitHub contributors with lots of repos :)

        requestQueue = Volley.newRequestQueue(this);  // This setups up a new request queue which we will need to make HTTP requests.

        JSONObject obj = null;
        /*try {
            obj = new JSONObject(baseUrl);
            String schedules = obj.getJSONObject("result").getJSONArray("schedules").toString();

            System.out.println(schedules);

            JSONArray arr = obj.getJSONArray("posts");
            for (int i = 0; i < arr.length(); i++) {
                String post_id = arr.getJSONObject(i).getString("post_id");
                System.out.println(post_id);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/

        //  getHoraireList();
        try {
            String inline = "";
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=chicago&sensor=false&#8221");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);

            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if (responsecode != 200)
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            else {
                //Scanner functionality will read the JSON data from the stream
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }
                System.out.println("\nJSON Response in String format");
                System.out.println(inline);
                //Close the stream when reading the data has been finished
                sc.close();
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void addToHoraireList(String repoName, String lastUpdated) {
        // This will add a new repo to our list.
        // It combines the repoName and lastUpdated strings together.
        // And then adds them followed by a new line (\n\n make two new lines).
        String strRow = repoName + " / " + lastUpdated;
        String currentText = horaires.getText().toString();
        this.horaires.setText(currentText + "\n\n" + strRow);
    }

    private void setHoraireListText(String str) {
        // This is used for setting the text of our repo list box to a specific string.
        // We will use this to write a "No repos found" message if the user doens't have any.
        this.horaires.setText(str);
    }

   /* private void getHoraireList() {
        this.url = this.baseUrl;

        JsonArrayRequest arrReq = new JsonArrayRequest(Request.Method.GET, url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Check the length of our response (to see if the user has any repos)
                        if (response.length() > 0) {
                            // The user does have repos, so let's loop through them all.


                            JSONObject obj = null;
                            try {
                                obj = new JSONObject(baseUrl);

                                JSONArray arr = (JSONArray) obj.getJSONObject("object").getJSONObject("result").getJSONArray("schedules");

                                for (int i = 0; i < arr.length(); i++) {
                                    String message = arr.getJSONObject(i).getString("message");
                                    String destination = arr.getJSONObject(i).getString("destination");

                                    System.out.println(message + "/" + destination);
                                    addToHoraireList(message, destination);
                                    JSONObject innerObj = arr.getJSONObject(i);
                                    for (Iterator it = innerObj.keys(); it.hasNext(); ) {
                                        String key = (String) it.next();
                                        System.out.println(key + ":" + innerObj.get(key));
                                    }

                                }
                            } catch (JSONException e) {
                                Log.e("Volley", "Invalid JSON Object.");
                            }


                        } else {
                            // The user didn't have any repos.
                            setHoraireListText("No repos found.");
                        }

                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // If there a HTTP error then add a note to our repo list.
                        setHoraireListText("Error while calling REST API");
                        Log.e("Volley", error.toString());
                    }
                }
        );

        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        requestQueue.add(arrReq);
    }*/
}
