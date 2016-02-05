package com.example.venu.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bSubmit;
    EditText etName;
    EditText etAge;
    EditText etNationality;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bSubmit=(Button) findViewById(R.id.submit);
        etName=(EditText) findViewById((R.id.nameField));
        etAge=(EditText) findViewById((R.id.ageField));
        etNationality=(EditText) findViewById((R.id.natField));
        bSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String sName=etName.getText().toString();
        String sAge=etAge.getText().toString();
        String sNat=etNationality.getText().toString();
        Bundle bundle=new Bundle();
        bundle.putString("NAME",sName);
        bundle.putString("AGE",sAge);
        bundle.putString("NATIONALITY",sNat);
        Intent intent=new Intent(MainActivity.this,SubActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
