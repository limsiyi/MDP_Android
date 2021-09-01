package com.example.mdp_android;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    //bluetooth connection
    BluetoothAdapter bluetoothAdapter;
    boolean bluetoothIsOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
        }
        Button bluetoothButton = findViewById(R.id.bluetoothButton);
        bluetoothButton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                System.out.println("Button Clicked");

                Intent bluetoothIntent = new Intent(getApplicationContext(), bluetooth.class);
                startActivity(bluetoothIntent);
            }
        });

    }


    public void toggleBluetooth (View view) {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(bluetoothAdapter == null){
            String noSupportText = "Your device does not support Bluetooth :(";
        }else {
            if (bluetoothIsOn) {
                //turn off bluetooth
                bluetoothIsOn = false;
                if (bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.disable();
                }
            } else {
                //turn on bluetooth
                if (bluetoothAdapter == null) {
                    String noSupportText = "Your device does not support Bluetooth :(";
                }
                //DEVICE'S BLUETOOTH NOT ENABLED
                if (!bluetoothAdapter.isEnabled()) {
                    Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(enableBTIntent);
                }
                bluetoothIsOn = true;
            }
        }
    }


}