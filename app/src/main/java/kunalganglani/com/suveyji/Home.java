package kunalganglani.com.suveyji;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity  implements View.OnClickListener{

    Button bLogout;
    EditText etName, etContactnumber, etUsername;
    UserLocalStore userLocalStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        etName= (EditText) findViewById(R.id.etName);
        etContactnumber = (EditText) findViewById(R.id.etContactnumber);
        etUsername=(EditText) findViewById(R.id.etUsername);
        bLogout= (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);
        userLocalStore= new UserLocalStore(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(authenticate()==true){
            displayUserDetails();
        }
        else {
            startActivity(new Intent(this,Login.class));
        }
    }

    private boolean authenticate(){
    return userLocalStore.getUserLoggedIn();
    }

    private void displayUserDetails(){
        User  user =  userLocalStore.getLoggedInUser();
        etUsername.setText(user.username);
        etName.setText(user.name);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogout:
                userLocalStore.clearUserData();
                userLocalStore.setUserLoggedIn(false);

                startActivity(new Intent(this,Login.class));
                break;
        }
    }
}
