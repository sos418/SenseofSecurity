package com.example.a1216qdf.senseofsecurity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SafePhoneActivity extends AppCompatActivity implements SensorEventListener{

    private Button btn_contact1;
    private ImageView iv_contact1,iv_contact2;
    private EditText et_contact1,et_contact2;
    private CheckBox checkBoxsafephone;
    public final static int REQUEST_CODE_CALL_PERMISSIONS = 1;
    String a;
    private SensorManager mSensorManager;
    private Sensor mAcce;
    private float acceXYZ[] = new float[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_phone);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_contact1 = (EditText)findViewById(R.id.et_contact1);
        et_contact2 = (EditText)findViewById(R.id.et_contact2);
        btn_contact1 = (Button)findViewById(R.id.btn_contact1);
        checkBoxsafephone = (CheckBox)findViewById(R.id.checkboxphone) ;

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAcce = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        btn_contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = spref.edit();
                editor.clear();

                String phone_contact1 = et_contact1.getText().toString();
                String phone_contact2 = et_contact2.getText().toString();

                editor.putString("KEY_STRING1", phone_contact1);
                editor.putString("KEY_STRING2", phone_contact2);
                editor.apply();
                a = spref.getString("KEY_STRING1", "");

                Toast toast = Toast.makeText(SafePhoneActivity.this,":" + a,Toast.LENGTH_LONG);
                toast.show();
            }
        });


        checkBoxsafephone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxsafephone.isChecked()){

                }
            }
        });
    }

    private void SOSCall(){
        Intent intentDial = new Intent("android.intent.action.CALL", Uri.parse("tel:"+a));
        if (ActivityCompat.checkSelfPermission(SafePhoneActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SafePhoneActivity.this,new String[] {Manifest.permission.CALL_PHONE},REQUEST_CODE_CALL_PERMISSIONS);
            return;
        }
        startActivity(intentDial);
    }

    public void onResume(){
        super.onResume();
        mSensorManager.registerListener(this,mAcce,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {

            case REQUEST_CODE_CALL_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    SOSCall();
                } else {
                    // Permission Denied
                    Toast.makeText(SafePhoneActivity.this, "CALL Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        acceXYZ[0] = sensorEvent.values[0];
        acceXYZ[1] = sensorEvent.values[1];
        acceXYZ[2] = sensorEvent.values[2];

        double Acce = Math.sqrt(Math.pow(acceXYZ[0],2) + Math.pow(acceXYZ[1],2) + Math.pow(acceXYZ[2],2));
        if (Acce > 30){
            SOSCall();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

}
