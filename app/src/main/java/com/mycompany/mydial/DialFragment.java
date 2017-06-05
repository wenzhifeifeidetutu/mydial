package com.mycompany.mydial;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */

public class DialFragment extends Fragment implements View.OnClickListener {
    private List<Connector> connectorList = new ArrayList<>();
    private String name;
    private String phoneNumber;
    private String time;

    private EditText phoneNumberInput;
    private Button btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six,
            btn_seven, btn_eight, btn_nine, btn_clera, btn_start, btn_alert, btn_call;
    private String callNumber = "";

    public DialFragment() {

    }

    public void getphonenumber() {

        Cursor cursor = null;
        try{

            ContentResolver contentResolver = getContext().getContentResolver();
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            cursor = contentResolver.query(CallLog.Calls.CONTENT_URI,
//                    new String[]{
//                            CallLog.Calls.CACHED_NAME,
//                            CallLog.Calls.NUMBER,
//                            CallLog.Calls.DATE

                    //},
                    null,null, null, CallLog.Calls.DEFAULT_SORT_ORDER
            );

            while(cursor.moveToNext()) {
                name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
                phoneNumber = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
                Date callDate = new Date(Long.parseLong(cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE))));

                time = simpleDateFormat.format(callDate);
                Log.d("sadas", getContext().toString()+"getphonenumber: "+name+phoneNumber+time);

                connectorList.add(new Connector(name, phoneNumber, time));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (cursor != null) {
                cursor.close();
            }
        }




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle saveInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_dial_avtivity, container, false);
        RecyclerView recyclerView =(RecyclerView)rootView.findViewById(R.id.dialRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        getphonenumber();
        recyclerView.setLayoutManager(linearLayoutManager);

        ConnectorAdapter connectorAdapter = new ConnectorAdapter(connectorList);
        recyclerView.setAdapter(connectorAdapter);

        phoneNumberInput = (EditText) rootView.findViewById(R.id.phone_number);
        btn_one = (Button)rootView.findViewById(R.id.number_one);
        btn_two = (Button)rootView.findViewById(R.id.number_two);
        btn_three = (Button)rootView.findViewById(R.id.number_three);
        btn_four = (Button)rootView.findViewById(R.id.number_four);
        btn_five = (Button)rootView.findViewById(R.id.number_five);
        btn_six = (Button)rootView.findViewById(R.id.number_six);
        btn_seven=(Button)rootView.findViewById(R.id.number_seven);
        btn_eight = (Button)rootView.findViewById(R.id.number_eight);
        btn_nine = (Button)rootView.findViewById(R.id.number_nine);
        btn_clera = (Button)rootView.findViewById(R.id.clear_number);
        btn_call = (Button)rootView.findViewById(R.id.call);
        btn_start = (Button)rootView.findViewById(R.id.number_star);
        btn_alert = (Button)rootView.findViewById(R.id.number_alert);
        btn_zero = (Button)rootView.findViewById(R.id.number_zero);

        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
        btn_five.setOnClickListener(this);
        btn_six.setOnClickListener(this);
        btn_seven.setOnClickListener(this);
        btn_eight.setOnClickListener(this);
        btn_nine.setOnClickListener(this);
        btn_zero.setOnClickListener(this);
        btn_start.setOnClickListener(this);
        btn_alert.setOnClickListener(this);
        btn_call.setOnClickListener(this);
        btn_clera.setOnClickListener(this);



        return rootView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_one:
                callNumber =callNumber+"1";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_two:
                callNumber += "2";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_three:
                callNumber += "3";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_four:
                callNumber += "4";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_five:
                callNumber += "5";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_six:
                callNumber += "6";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_seven:
                callNumber += "7";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_eight:
                callNumber += "8";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_nine:
                callNumber += "9";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_zero:
                callNumber += "0";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_star:
                callNumber += "*";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.number_alert:
                callNumber +="#";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.clear_number:
                callNumber = "";
                phoneNumberInput.setText(callNumber);
                break;
            case R.id.call:
                Intent clallIntent = new Intent("android.intent.action.CALL", Uri.parse("tel:" + callNumber));
                startActivity(clallIntent);
                callNumber = "";
                break;

        }
    }
}
