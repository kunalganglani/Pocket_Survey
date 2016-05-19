package kunalganglani.com.suveyji;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etName, etContactNumber, etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bRegister= (Button) findViewById(R.id.bRegister);
        etName= (EditText) findViewById(R.id.etName);
        etContactNumber = (EditText) findViewById(R.id.etContactnumber);
        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);

        bRegister.setOnClickListener(this);
        //
    }


    @Override
    public void onClick(View v) {
        final String REGISTER_URL = "http://prakashupadhyay.com/SurveyApp/process.php";
        final ProgressDialog loading;
        loading = ProgressDialog.show(this,"Registering...","Please wait...",false,false);
        final Intent intent = new Intent(this, UserManagement.class);

        switch (v.getId()){
            case R.id.bRegister:
            {
                String uname = etUsername.getText().toString();
                String pwd = etPassword.getText().toString();
                String fname = etName.getText().toString();
                String lname = "<Surname>";//etName.getText().toString();
                String contact = etContactNumber.getText().toString();
                String age = "25";//etName.getText().toString();
                String gender = "<gender>";//etName.getText().toString();
                String city = "<city>";//etName.getText().toString();

                JSONObject jSonObjData = new JSONObject();
                try
                {
                    JSONObject jsonVolObject = new JSONObject();
                    jsonVolObject.put("uname", uname);
                    jsonVolObject.put("pwd", pwd);
                    jsonVolObject.put("fname", fname);
                    jsonVolObject.put("lname", lname);
                    jsonVolObject.put("contact", contact);
                    jsonVolObject.put("age", age);
                    jsonVolObject.put("gender", gender);
                    jsonVolObject.put("city", city);

                    jSonObjData.put("action", "CreateVolunteer");
                    jSonObjData.put("data", jsonVolObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        REGISTER_URL, jSonObjData,
                        new Response.Listener<JSONObject>() {

                            @Override
                            public void onResponse(JSONObject response) {
                                loading.dismiss();
                                System.out.println("\n\n Response from Backend:\n" + response.toString());
                                // Navigating Back to User Management Screen.
                                startActivity(intent);
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        System.out.println("\n\n Response from Backend:\n" + error.toString());
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
            break;
            default: System.out.println("Not Matched..!!");
        }
    }
}
