package kunalganglani.com.suveyji;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileInputStream;

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

        int id = Integer.parseInt(b.getString("id"));
        String uname = b.getString("uname");
        String fname = b.getString("fname");
        String lname = b.getString("lname");
        String city = b.getString("city");
        String age = b.getString("age");
        String gender = b.getString("gender");
        String dob = b.getString("dob");
        String dor = b.getString("dor");
        String contact = b.getString("contact");

        TextView textView1 = (TextView)findViewById(R.id.NameVal);
        TextView textView2 = (TextView)findViewById(R.id.ageval);
        TextView textView3 = (TextView)findViewById(R.id.genderval);
        TextView textView4 = (TextView)findViewById(R.id.contactnumberval);
        TextView textView5 = (TextView)findViewById(R.id.cityval);
        TextView textView6 = (TextView)findViewById(R.id.registeredonval);
        TextView textView7 = (TextView)findViewById(R.id.birthdateval);

        Button callbtn = (Button)findViewById(R.id.button);
        Button msgbtn = (Button)findViewById(R.id.button2);

        textView1.setText(fname + " " + lname);
        textView2.setText(age);
        textView3.setText(gender);
        textView4.setText(contact);
        textView5.setText(city);
        textView6.setText(dor);
        textView7.setText(dob);

        String filename = b.getString("profilePicNameStr");
        Bitmap bmp = null;
        try {
            FileInputStream is = this.openFileInput(filename);
            bmp = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ImageView profileView = (ImageView)findViewById(R.id.imageView);

        profileView.setImageBitmap(bmp);

    }
}
