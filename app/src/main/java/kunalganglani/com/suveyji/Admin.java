package kunalganglani.com.suveyji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity implements View.OnClickListener {

    Button bUsermanage, bViewdata,bAddform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        bUsermanage= (Button) findViewById(R.id.bUsermanage);
        bViewdata= (Button) findViewById(R.id.bViewdata);
        bAddform= (Button) findViewById(R.id.bAddform);

        bUsermanage.setOnClickListener(this);
        bViewdata.setOnClickListener(this);
        bAddform.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bUsermanage:
                    startActivity(new Intent(this,UserManagement.class));
                break;

            case R.id.bViewdata:
                startActivity(new Intent(this,ViewData.class));
                break;

            case R.id.bAddform:
                startActivity(new Intent(this,AddForm.class));
                break;

        }
    }
}
