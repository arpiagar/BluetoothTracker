package com.example.tejasvees.fk_mob_hack_test_1;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.bluetooth.BluetoothAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;


public class MyActivity2 extends Activity {
private static final int REQUEST_ENABLE_BT = 1;
private ListView listView;
//private   ArrayAdapter<String> adapter;




    private void onResponse(ArrayList<String> titles) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,titles);
        listView = (ListView) findViewById(R.id.listView);
        listView.setClickable(true);
        listView.setAdapter(adapter);
        Toast.makeText(MyActivity2.this, "Response called", Toast.LENGTH_SHORT).show();

        listView.setOnItemClickListener(new OnItemClickListener()
        {
            public void onItemClick(AdapterView <?> adapter,View arg1 , int position, long arg3)
            {
                Intent n = new Intent(getApplicationContext(), MyActivity3.class);
                String selected = (String)adapter.getAdapter().getItem(position);
                n.putExtra("item",selected);
                n.putExtra("position", position);
                startActivity(n);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity2);

        //1. Checking if device supports bluetooth
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(MyActivity2.this, "I dont support bluetooth", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MyActivity2.this, "I support bluetooth ABC",Toast.LENGTH_SHORT).show();

        //2. Checking if bluetooth is enabled
            if (!mBluetoothAdapter.isEnabled()) {
                Toast.makeText(MyActivity2.this, "bluetooth not enbaled", Toast.LENGTH_SHORT).show();
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            }else{
                Toast.makeText(MyActivity2.this, "bluetooth enabled DEF", Toast.LENGTH_SHORT).show();
            }

         //3. start scanning for bluetooth devices
            Toast.makeText(MyActivity2.this, "Going to start scanning for devices", Toast.LENGTH_SHORT).show();
            mBluetoothAdapter.startDiscovery();

            //Fetching the Paired Devices
            //ASSUMPTION: We are just looking for Paired Devices as of now.
            final ArrayList<String> mArray = new ArrayList<String>();
            Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
            // If there are paired devices
            if (pairedDevices.size() > 0) {
                // Loop through paired devices
                for (BluetoothDevice device : pairedDevices) {
                    // Add the name and address to an array adapter to show in a ListView
                    mArray.add(device.getName() + "\n" + device.getAddress()+"KLLLLLLL");
                    Toast.makeText(MyActivity2.this, "Bonded Device", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MyActivity2.this, device.getAddress(), Toast.LENGTH_SHORT).show();
                }
                //Following function displays the list of bonded connections and allows them to categorize as ROY
                this.onResponse(mArray);


            }


            // Create a BroadcastReceiver for ACTION_FOUND
            final BroadcastReceiver mReceiver;

            HashMap<String,String> devicesMap = new HashMap<String,String>();

//            {
//                mReceiver = new BroadcastReceiver() {
//                    public void onReceive(Context context, Intent intent) {
//                        Log.d("Line","1" );
//                        String action = intent.getAction();
//                        Log.d("Line","2" );
//                        // When discovery finds a device
//                        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
//                            Log.d("Line","3" );
//                            // Get the BluetoothDevice object from the Intent
//                            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
//                            Log.d("Line","4" );
//                            // Add the name and address to an array adapter to show in a ListView
//                            ArrayAdapter<String> mArrayAdapter = new ArrayAdapter(context, android.R.layout.simple_selectable_list_item);
//                            Log.d("Line","5" );
//                            mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
//                            Log.d("Line","6" );
//                            // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,titles);
//                            ListView listView = (ListView) findViewById(R.id.listView);
//                            Log.d("Line","7" );
//                            listView.setAdapter(mArrayAdapter);
//                            Log.d("Line","8" );
//                        }
//                    }
//                };
//            }

            // Register the BroadcastReceiver
//            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//            Log.d("Line","9" );
//            registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
//            Log.d("Line","10" );




        }


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_activity2, menu);
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
