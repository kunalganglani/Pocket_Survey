package kunalganglani.com.suveyji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener {

    Button bRegister;
    EditText etName, etMobilenumber, etUsername, etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bRegister= (Button) findViewById(R.id.bRegister);
        etName= (EditText) findViewById(R.id.etName);
        etMobilenumber = (EditText) findViewById(R.id.etMobilenumber);
        etUsername=(EditText) findViewById(R.id.etUsername);
        etPassword= (EditText) findViewById(R.id.etPassword);

        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.bRegister:
            Intent intent= new Intent(this,UserManagement.class);
            startActivity(intent);
            break;
    }
    }
}
