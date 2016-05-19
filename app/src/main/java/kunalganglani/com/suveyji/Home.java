package kunalganglani.com.suveyji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity  implements View.OnClickListener{

    Button bLogout;
    EditText etName, etMobilenumber, etUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etName= (EditText) findViewById(R.id.etName);
        etMobilenumber = (EditText) findViewById(R.id.etMobilenumber);
        etUsername=(EditText) findViewById(R.id.etUsername);
        bLogout= (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:
                startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
