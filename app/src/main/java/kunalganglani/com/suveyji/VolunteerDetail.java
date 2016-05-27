package kunalganglani.com.suveyji;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;

public class VolunteerDetail extends AppCompatActivity  implements View.OnClickListener{
    Button callbtn, msgbtn;
    TextView textView1, textView2, textView3, textView4, textView5, textView6;


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

             textView1 = (TextView)findViewById(R.id.NameVal);
             textView2 = (TextView)findViewById(R.id.ageval);
             textView3 = (TextView)findViewById(R.id.genderval);
             textView4 = (TextView)findViewById(R.id.contactnumberval);
             textView5 = (TextView)findViewById(R.id.cityval);
             textView6 = (TextView)findViewById(R.id.registeredonval);

             callbtn = (Button)findViewById(R.id.callbtn);
        callbtn.setOnClickListener(this);
             msgbtn = (Button)findViewById(R.id.msgbtn);
        msgbtn.setOnClickListener(this);
            textView1.setText(fname + " " + lname);
            textView2.setText(age);
            textView3.setText(gender);
            textView4.setText(contact);
            textView5.setText(city);
            textView6.setText(reg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.callbtn:
                Intent i = new Intent(this, SendMessage.class);
                i.putExtra("contactnumberval",textView4.getText().toString());
                startActivity(i);
                break;
            case R.id.msgbtn:
                startActivity(new Intent(this, SendMessage.class));
                break;

        }


    }
}
