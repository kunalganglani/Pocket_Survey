package kunalganglani.com.suveyji;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.FileInputStream;

public class Volunteer extends AppCompatActivity implements View.OnClickListener {
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer);
        Button bCampaign1,bCampaign2,bCampaign3;

        bCampaign1= (Button) findViewById(R.id.bCampaign1);
        bCampaign2= (Button) findViewById(R.id.bCampaign2);
        bCampaign3= (Button) findViewById(R.id.bCampaign3);
        bCampaign1.setOnClickListener(this);
        bCampaign2.setOnClickListener(this);
        bCampaign3.setOnClickListener(this);
        try
        {
            JSONObject jsonObject = new JSONObject(getIntent().getStringExtra("volInfoStr"));
            TextView textView = (TextView)findViewById(R.id.editText);
            textView.setText("Hi, "+jsonObject.get("vol_fname").toString()+" !");
            /*
            byte[] decodedString = Base64.decode(jsonObject.get("vol_photo").toString(),Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);


            ImageView profileView = (ImageView)findViewById(R.id.imageViewVolPic);

            profileView.setImageBitmap(decodedByte);
            */

            String filename = getIntent().getStringExtra("profilePicNameStr");
            Bitmap bmp = null;
            try {
                FileInputStream is = this.openFileInput(filename);
                bmp = BitmapFactory.decodeStream(is);
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ImageView profileView = (ImageView)findViewById(R.id.imageViewVolPic);

            profileView.setImageBitmap(bmp);



        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bCampaign1:
                startActivity(new Intent(this,Campaign1.class));
                overridePendingTransition(R.anim.right_in, R.anim.left_out);
                break;

            case R.id.bCampaign2:
//                startActivity(new Intent(this,Campaign1.class));
                break;

            case R.id.bCampaign3:
//                startActivity(new Intent(this,Campaign1.class));
                break;

            // case R.id.tvRegisterLink:
            //   startActivity(new Intent(this,Register.class));
            // break;

        }
    }
}
