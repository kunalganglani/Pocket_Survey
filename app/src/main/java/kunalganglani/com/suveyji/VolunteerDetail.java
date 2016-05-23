package kunalganglani.com.suveyji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class VolunteerDetail extends AppCompatActivity {
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_detail);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        String fname = b.getString("fname");
        String lname = b.getString("lname");
        String age = b.getString("age");
        String contact = b.getString("contact");
        String gender = b.getString("gender");
        String city = b.getString("city");
        String reg = b.getString("reg");

            TextView textView1 = (TextView)findViewById(R.id.NameVal);
            TextView textView2 = (TextView)findViewById(R.id.ageval);
            TextView textView3 = (TextView)findViewById(R.id.genderval);
            TextView textView4 = (TextView)findViewById(R.id.contactnumberval);
            TextView textView5 = (TextView)findViewById(R.id.cityval);
            TextView textView6 = (TextView)findViewById(R.id.registeredonval);

            Button callbtn = (Button)findViewById(R.id.button);
            Button msgbtn = (Button)findViewById(R.id.button2);

            textView1.setText(fname + " " + lname);
            textView2.setText(age);
            textView3.setText(gender);
            textView4.setText(contact);
            textView5.setText(city);
            textView6.setText(reg);
    }
}
