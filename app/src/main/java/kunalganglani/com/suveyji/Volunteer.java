package kunalganglani.com.suveyji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Volunteer extends AppCompatActivity implements View.OnClickListener {

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
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bCampaign1:
                startActivity(new Intent(this,Campaign1.class));
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
