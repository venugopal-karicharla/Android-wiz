package com.example.venu.intent2;


        import android.app.Activity;
        import android.content.Intent;
        import android.net.wifi.p2p.WifiP2pManager;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.venu.intent2.R;

        import java.io.ByteArrayInputStream;
        import java.io.IOException;
        import java.io.ObjectInputStream;

/**
 * Created by sujatha on 1/3/2016.
 */
public class SubActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView mOne= (TextView)findViewById(R.id.one);
        TextView mTwo= (TextView)findViewById(R.id.two);
        TextView mThree= (TextView)findViewById(R.id.three);
        MySerial ms=new MySerial();


        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        // Toast.makeText(SubActivity.this,"OK",Toast.LENGTH_LONG);
        // mTwo.setText(bundle.getString("NAME"));
        if(bundle!=null)
        {
            try {
                ms = (MySerial) ms.byteToObject(bundle.getByteArray("OBJ"));
                }catch(IOException e){e.printStackTrace();}
            catch(ClassNotFoundException e){e.printStackTrace();}
            // bundle.getString("")
            mOne.setText("Hello!     "+ms.getmName());
            // mOne.setText("Hello!");
            mTwo.setText("Your Age is"+ms.getmAge());
            mThree.setText("You Belong to    "+ms.getmNation());
        }

    }

    //static public Object byteToObject(byte bto[]) throws IOException, ClassNotFoundException
    //{
      //  ByteArrayInputStream bais=new ByteArrayInputStream(bto);
       // ObjectInputStream ois=new ObjectInputStream(bais);
        //Object obj=ois.readObject();
        //return obj;
   // }

}