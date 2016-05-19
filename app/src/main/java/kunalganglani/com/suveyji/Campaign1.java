package kunalganglani.com.suveyji;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Campaign1 extends AppCompatActivity implements View.OnClickListener {

    TextView formtitle;
    EditText etName, etAge,etAddress,etLanguagesknown,etNoOfPeople,etNonEarning,etTotalIncome,etPlace;
    RadioGroup etGender,etMaritalstatus,etEducationalqualification,etPresentstatus,etInterest;
    Button bSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign1);
        formtitle= (TextView) findViewById(R.id.formtitle);
        bSubmit= (Button) findViewById(R.id.bSubmit);
        etName= (EditText) findViewById(R.id.etName);
        etAge= (EditText) findViewById(R.id.etAge);
        etAddress= (EditText) findViewById(R.id.etAddress);
        etLanguagesknown= (EditText) findViewById(R.id.etLanguagesknown);
        etNoOfPeople= (EditText) findViewById(R.id.etNoOfPeople);
        etNonEarning= (EditText) findViewById(R.id.etNonEarning);
        etTotalIncome= (EditText) findViewById(R.id.etTotalIncome);
        etPlace= (EditText) findViewById(R.id.etPlace);
        etGender = (RadioGroup) findViewById(R.id.etGender);
        etMaritalstatus = (RadioGroup) findViewById(R.id.etMaritalstatus);
        etEducationalqualification = (RadioGroup) findViewById(R.id.etEducationalqualification);
        etPresentstatus = (RadioGroup) findViewById(R.id.etPresentstatus);
        etInterest = (RadioGroup) findViewById(R.id.etInterest);

        bSubmit.setOnClickListener(this);
        //int selectedId=etGender.getCheckedRadioButtonId();
        //RadioButton radioButton = (RadioButton) findViewById(selectedId);
        //String gender= radioButton.getText().toString();


    }

    @Override
    public void onClick(View v) {
        String form_title = formtitle.getText().toString();
        String name = etName.getText().toString();
        String age = etAge.getText().toString();
        String address = etAddress.getText().toString();
        String languages_known= etLanguagesknown.getText().toString();
        String no_of_people= etNoOfPeople.getText().toString();
        String non_earning = etNonEarning.getText().toString();
        String total_income= etTotalIncome.getText().toString();
        String place= etPlace.getText().toString();


        int genderId= etGender.getCheckedRadioButtonId();
        RadioButton etGenderRadio = (RadioButton) findViewById(genderId);
        String gender= etGenderRadio.getText().toString();

        int maritalstatusId= etMaritalstatus.getCheckedRadioButtonId();
        RadioButton etMaritalstatusRadio = (RadioButton) findViewById(maritalstatusId);
        String marital_status= etMaritalstatusRadio.getText().toString();

        int educationId= etEducationalqualification.getCheckedRadioButtonId();
        RadioButton etEducationRadio = (RadioButton) findViewById(educationId);
        String educational_qualification= etEducationRadio.getText().toString();

        int presentstatusId= etPresentstatus.getCheckedRadioButtonId();
        RadioButton etPresentstatusRadio = (RadioButton) findViewById(presentstatusId);
        String present_status= etPresentstatusRadio.getText().toString();

        int interestId= etInterest.getCheckedRadioButtonId();
        RadioButton etInterestRadio = (RadioButton) findViewById(interestId);
        String interest= etInterestRadio.getText().toString();


        //Toast.makeText(this,radioButton.getText(), Toast.LENGTH_SHORT).show();
    }
}
