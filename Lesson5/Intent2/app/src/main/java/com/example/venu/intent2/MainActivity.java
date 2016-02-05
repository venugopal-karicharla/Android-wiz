package com.example.venu.intent2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
        MySerial ms=new MySerial();
        String sName=etName.getText().toString();
        ms.setmName(sName);
        String sAge=etAge.getText().toString();
        ms.setmAge(sAge);
        String sNat=etNationality.getText().toString();
        ms.setmNation(sNat);

        Bundle bundle=new Bundle();
        try {
            bundle.putByteArray("OBJ", ms.objectToBytes());
        }
        catch (IOException e){ e.printStackTrace();}
        Intent intent=new Intent(MainActivity.this,SubActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

//     static public byte[] objectToBytes(Object o) throws IOException
  //  {
    //    ByteArrayOutputStream baos=new ByteArrayOutputStream();
      //  ObjectOutputStream oos=new ObjectOutputStream(baos);
        //oos.writeObject(o);
       // return baos.toByteArray();
    //}
}