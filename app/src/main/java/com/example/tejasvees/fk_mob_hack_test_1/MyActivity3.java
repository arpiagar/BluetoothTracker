package com.example.tejasvees.fk_mob_hack_test_1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import android.content.Intent;

import com.example.tejasvees.fk_mob_hack_test_1.R;

public class MyActivity3 extends Activity {
    private RadioGroup alertCategory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity3);
        Toast.makeText(MyActivity3.this, "Calling Activity 3", Toast.LENGTH_SHORT).show();
//       addListenerOnButton();
    }


    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        String TAG="TAGGING";
        switch(view.getId()) {
            case R.id.red:
                if (checked)
                {
                    Toast.makeText(MyActivity3.this, "Red radiobutton checked", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Red radiobutton checked");
                    Intent n = new Intent(getApplicationContext(), MyActivity5.class);
                    startActivity(n);
                }

                break;
            case R.id.orange:
                if (checked)
                {
                    Toast.makeText(MyActivity3.this, "Orange radiobutton checked", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Orange radiobutton checked");
                    Intent n = new Intent(getApplicationContext(), MyActivity4.class);
                    startActivity(n);
                }
                break;
            case R.id.yellow:
                if (checked)
                {
                    Toast.makeText(MyActivity3.this, "Yellow radiobutton checked", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Yellow radiobutton checked");
                }

//                fall.setVisibility(View.GONE);
//                trip.setVisibility(View.GONE);
//                illness.setVisibility(View.GONE);
                break;
        }
    }
    public void addListenerOnButton() {

        alertCategory = (RadioGroup) findViewById(R.id.alertCategory);
        alertCategory.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = alertCategory.getCheckedRadioButtonId();

                Toast.makeText(MyActivity3.this,""+alertCategory.getCheckedRadioButtonId(), Toast.LENGTH_SHORT).show();

            }

        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
