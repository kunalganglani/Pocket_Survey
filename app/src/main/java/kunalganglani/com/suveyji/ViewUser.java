package kunalganglani.com.suveyji;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ViewUser extends AppCompatActivity {

    //String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        final String REGISTER_URL = "http://prakashupadhyay.com/SurveyApp/process.php";
        final ProgressDialog loading;
        loading = ProgressDialog.show(this,"Verifying...","Please wait...",false,false);
        //final Intent intent = new Intent(this, Volunteer.class);

        final JSONObject jSonObjData = new JSONObject();
        try{
            jSonObjData.put("action", "GetVolunteers");
            jSonObjData.put("data", jSonObjData.toString());
        }catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                REGISTER_URL, jSonObjData,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        loading.dismiss();
                        System.out.println("\n\n Response from Backend:\n" + response);
                        try
                        {
                            String jsonStr = response.getString("arrRes");
                            JSONObject myjson = new JSONObject(jsonStr);
                            JSONArray volInfoArr = myjson.getJSONArray("volunteerRecords");
                            int sizeVolArr = volInfoArr.length();
                            //ArrayList<JSONObject> arrays = new ArrayList<JSONObject>();
                            int vol_id=-1;
                            JSONObject volJSONObject = new JSONObject();
                            String[] mobileArray = new String[sizeVolArr];
                            for (int i = 0; i < sizeVolArr; i++) {
                                volJSONObject = volInfoArr.getJSONObject(i);
                                String n1 = volJSONObject.get("vol_fname") + " " + volJSONObject.get("vol_lname");
                                mobileArray[i] = n1;
                            }
                            ArrayAdapter adapter = new ArrayAdapter<String>(ViewUser.this, R.layout.activity_listview, mobileArray);
                            //ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, mobileArray);
                            ListView listView = (ListView) findViewById(R.id.mobile_list);
                            listView.setAdapter(adapter);

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }



                        //startActivity(intent);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                    loading.dismiss();
                   // System.out.println("\n\n Response from Backend:\n" + error.toString());
            }
        }) {

            /**
             * Passing some request headers
             */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }


        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);
    }






}
