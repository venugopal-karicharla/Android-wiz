package com.example.venu.intent2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by sujatha on 1/3/2016.
 */
public class MySerial implements Serializable {

    String mName;
    String mAge;
    String mNation;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmNation() {
        return mNation;
    }

    public void setmNation(String mNation) {
        this.mNation = mNation;
    }

    public byte[] objectToBytes() throws IOException
      {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(baos);
        oos.writeObject(this);
        return baos.toByteArray();
      }

    static public Object byteToObject(byte bto[]) throws IOException, ClassNotFoundException
    {
        ByteArrayInputStream bais=new ByteArrayInputStream(bto);
        ObjectInputStream ois=new ObjectInputStream(bais);
        Object obj=ois.readObject();
        return obj;
    }
}
