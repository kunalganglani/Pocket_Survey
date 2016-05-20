package kunalganglani.com.suveyji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DataDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_detail);

        Intent in = getIntent();
        Bundle b = in.getExtras();
        String name3 = b.getString("name");
//        String lname = b.getString("lname");
//        String age = b.getString("age");
//        String contact = b.getString("contact");
//        String gender = b.getString("gender");
//        String city = b.getString("city");
//        String reg = b.getString("reg");

        TextView textView10 = (TextView)findViewById(R.id.Nameval);
//        TextView textView11 = (TextView)findViewById(R.id.ageval);
//        TextView textView12 = (TextView)findViewById(R.id.genderval);
//        TextView textView13 = (TextView)findViewById(R.id.contactnumberval);
//        TextView textView14 = (TextView)findViewById(R.id.cityval);
//        TextView textView15 = (TextView)findViewById(R.id.registeredonval);


        textView10.setText(name3);

    }
}