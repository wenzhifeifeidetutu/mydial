package com.mycompany.mydial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ConnectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categlory);

        getSupportFragmentManager().beginTransaction().replace(R.id.categalory, new ConnectorFragment()).commit();
    }
}
