package kunalganglani.com.suveyji;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class AddForm extends AppCompatActivity {
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_in, R.anim.right_out);
    }

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    public int type=0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_form);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(onClick());

        Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
        String[] items = new String[]{"Edit Text", "Text Area", "Radio Buttons", "Checkboxes"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                               @Override
                                               public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                                                   switch (position) {
                                                       case 0:
                                                           type=0;
                                                           break;
                                                       case 1:
                                                           type=1;
                                                           break;
                                                       case 2:
                                                           type=2;
                                                           break;
                                                       case 3:
                                                           type=3;
                                                           break;

                                                   }
                                                   //Log.v("item", (String) parent.getItemAtPosition(position));
                                               }

                                               @Override
                                               public void onNothingSelected(AdapterView<?> parent) {
                                                   // TODO Auto-generated method stub
                                               }

        });

            TextView textView = new TextView(this);
        textView.setText("Q> ");
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch(type){
                    case 0:
                        mLayout.addView(createNewEditText(mEditText.getText().toString()));
                        mEditText.setText("");
                        break;
                    case 1:
                        mLayout.addView(createNewEditTextArea(mEditText.getText().toString()));
                        //mLayout.addView(createNewTextView(mEditText.getText().toString()));
                        mEditText.setText("");
                        break;
                    case 2:
                        mLayout.addView(createNewRadioGroup(mEditText.getText().toString()));
                        mEditText.setText("");
                        break;
                    case 3:
                        mEditText.setText("");
                        break;
                }


            }
        };
    }

    private TextView createNewTextView(String text) {
        final ActionBar.LayoutParams lparams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
       // lparams.setMargins(0,20,0,0);
        textView.setHint("" + text);
        return textView;
    }
    private EditText createNewEditTextArea(String text) {
//        android:ellipsize="start"

        final ActionBar.LayoutParams lparams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        final EditText editText= new EditText(this);
        editText.setLayoutParams(lparams);
        editText.setBackgroundResource(R.drawable.edittextstyle);
        editText.setHint("\n " + text);
        editText.setGravity(Gravity.CENTER);
        //editText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        editText.setLines(5);
        editText.setHorizontallyScrolling(false);
        editText.setSingleLine(false);
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);

        editText.setGravity(1);
        return editText;
    }
    private EditText createNewEditText(String text) {
        final ActionBar.LayoutParams lparams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        //lparams.setMargins(0,20,0,0);
        final EditText editText= new EditText(this);
        editText.setBackgroundResource(R.drawable.edittextstyle);
        editText.setLayoutParams(lparams);
        editText.setHint("" + text);
        editText.setGravity(Gravity.CENTER);
        //editText.setLayoutParams(new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT));
        return editText;
    }
    private RadioGroup createNewRadioGroup(String text) {
        mLayout.addView(createNewTextView(mEditText.getText().toString()));
        final ActionBar.LayoutParams lparams = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
        //final EditText editText= new EditText(this);
//        editText.setLayoutParams(lparams);
//        editText.setHint("Q: " + text);

        RadioGroup group = new RadioGroup(this);
        group.setLayoutParams(lparams);
        group.setBackgroundResource(R.drawable.edittextstyle);
        group.setOrientation(RadioGroup.HORIZONTAL);
        RadioButton btn1 = new RadioButton(this);
        btn1.setText("Yes");
        group.addView(btn1);
        RadioButton btn2 = new RadioButton(this);
        group.addView(btn2);
        btn2.setText("No");
        return group;

    }

}
