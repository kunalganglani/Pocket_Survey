package kunalganglani.com.suveyji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessage extends AppCompatActivity {

    EditText etextMblNumber, etextMsg;
    Button btnSendSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        String contactnumber="";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
             contactnumber = extras.getString("contactnumberval");
        }

        etextMblNumber= (EditText)findViewById(R.id.etextMblNumber);
        etextMsg= (EditText)findViewById(R.id.etextMsg);
        btnSendSMS=(Button)findViewById(R.id.btnSendSMS);

        etextMblNumber.setText("+91"+contactnumber);
}

    public void sendSms(View view) {
        SmsManager sm = SmsManager.getDefault();
        String number = etextMblNumber.getText().toString();
        String msg = etextMsg.getText().toString();
        sm.sendTextMessage(number, null, msg, null, null);
    }
}