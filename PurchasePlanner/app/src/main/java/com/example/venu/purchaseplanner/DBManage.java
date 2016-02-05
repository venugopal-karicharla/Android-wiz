package com.example.venu.purchaseplanner;


        import android.app.Activity;
        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.Date;

/**
 * Created by sujatha on 1/6/2016.
 */
public class DBManage extends SQLiteOpenHelper {
    private static final String DBNAME="PurchasePlannerDB";
    private static final String TABLE_NAME1="list_table";
    private static final String TABLE_NAME2="main_table";
    private static final int VERSION=1;
    private static final String  DATE ="date";
    private static final String SL1="slno";
    private static final String LISTNAME="listname";
    private static final String ITEMNAME="itemname";
    private static final String QUANTITY="quantity";
    private static final String UNITS="units";
    private static final String REMARKS="remarks";
    private Context context;
    private MainListAdapter mainListAdapter;
    public DBManage(Context context) {
        super(context,DBNAME,null,VERSION);
        this.context = context;
    }

    public void setMainListAdapter(MainListAdapter mainListAdapter) {
        this.mainListAdapter = mainListAdapter;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_list_table = "CREATE TABLE "+TABLE_NAME1 +"("+SL1+ " INTEGER PRIMARY KEY AUTOINCREMENT , "+DATE+ " STRING, "+LISTNAME+" STRING)";
        String create_main_table = "CREATE TABLE "+TABLE_NAME2 +"("+SL1+ " INTEGER PRIMARY KEY AUTOINCREMENT , "+DATE+ " STRING, "+LISTNAME+" STRING, "+ ITEMNAME + " STRING, "+ QUANTITY + " STRING, "+ UNITS+ " STRING, "+ REMARKS+" STRING )";
       // String create_main_table = "CREATE TABLE "+TABLE_NAME2 +"("+SL1+ " INTEGER PRIMARY KEY AUTOINCREMENT , "+DATE+ " STRING, "+LISTNAME+" STRING, "+ ITEMNAME + " STRING, "+ UNITS+ " STRING, "+ REMARKS+" STRING )";

        db.execSQL((create_list_table));
        db.execSQL((create_main_table));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addList(String d, String ln)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DATE,d);
        contentValues.put(LISTNAME,ln);
        sqLiteDatabase.insert(TABLE_NAME1, null, contentValues);
        sqLiteDatabase.close();
    }

    public boolean searchList(String s)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME1+ " WHERE " + LISTNAME + " = ? ";
        Cursor c =sqLiteDatabase.rawQuery(retq, new String[]{s});
        return(c.getCount()>0);
    }
    public String searchItem(String s)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME2+ " WHERE " + ITEMNAME + " = ? ";
        Cursor c =sqLiteDatabase.rawQuery(retq, new String[]{s});
        //sqLiteDatabase.close();
        if(c.getCount()>0) {
            c.moveToFirst();
          //  System.out.println("ooooooooooooooooooo"+c.getString(2)+"oooooooooooooooooooooo");
            return c.getString(2);
        }
            else
        return "NIL";
    }

    public int deleteRow(String id)
    {
        int flag=1;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_NAME1, LISTNAME + "= ?", new String[]{id});
        sqLiteDatabase.delete(TABLE_NAME2, LISTNAME + "= ?", new String[]{id});
        sqLiteDatabase.close();
        return flag;
    }


    ArrayList<DataClass> getList()
    {
        ArrayList<DataClass> datas = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME1;
        Cursor c =sqLiteDatabase.rawQuery(retq, null);
       // System.out.println("--------------------"+c.getCount()+"--------------->>");
      if(c.getCount()==0) {
          String list = " ";
          String date = "To add item use '+' above ";
          DataClass wd = new DataClass();
          wd.setMlistName(list);
          wd.setMdate(date);
          datas.add(wd);
      }
      else
      {
           c.moveToFirst();
           String list = " ";
           String date = " ";

           do {
               list = c.getString(1);
               date = c.getString(2);
               DataClass wd = new DataClass();
               wd.setMlistName(list);
               wd.setMdate(date);
               datas.add(wd);
               //Toast.makeText(RetrievedActivity.this, c.getString(1), Toast.LENGTH_SHORT).show();
           } while (c.moveToNext());

           c.close();
           sqLiteDatabase.close();
       }
           return datas;

    }

    ArrayList<DataClass> getSubList(String id)
    {
        ArrayList<DataClass> datas = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME2+ " WHERE " + LISTNAME + " = ? ";
        Cursor c =sqLiteDatabase.rawQuery(retq, new String[]{id});
        // System.out.println("--------------------"+c.getCount()+"--------------->>");
        if(c.getCount()==0) {
            String item = "To add item use '+' above  ";
            String qty = " ";
            String unt=" ";
            DataClass wd = new DataClass();
            wd.setMitemName(item);
            wd.setMqty(qty);
            wd.setMunits(unt);
            datas.add(wd);
        }
        else
        {
            c.moveToFirst();
            String itm = " ";
            String qty = " ";
            String unt=" ";

            do {
                itm = c.getString(3);
                qty = c.getString(4);
                unt = c.getString(5);
                DataClass wd = new DataClass();
                wd.setMitemName(itm);
                wd.setMqty(qty);
                wd.setMunits(unt);
                datas.add(wd);
                //Toast.makeText(RetrievedActivity.this, c.getString(1), Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());

            c.close();
            sqLiteDatabase.close();
        }
        return datas;

    }



    public DataClass getRow( int pos)
    {
        ArrayList<DataClass> datas = new ArrayList<>();
        DataClass dc;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME1;
        Cursor c =sqLiteDatabase.rawQuery(retq, null);
        c.moveToFirst();
        String list=" ";
        String date=" ";
        int slno;
        int i=0;
        dc = new DataClass();
        do
        {
            slno=c.getInt(0);
            date=c.getString(1);
            list=c.getString(2);
            if(i==pos)
                break;
            i++;
            //Toast.makeText(RetrievedActivity.this, c.getString(1), Toast.LENGTH_SHORT).show();
        }while(c.moveToNext());
        dc.setMslNo(slno);
        dc.setMdate(date);
        dc.setMlistName(list);
        c.close();
        sqLiteDatabase.close();
       // System.out.println(date+","+dc.mlistName+">>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        return dc;
    }


    public DataClass modifySubItem(DataClass dc)
    {
        String d=dc.getMitemName();
        String e=dc.getMqty();
        String f=dc.getMunits();
      //  String g="XXXX";
        SQLiteDatabase  sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ITEMNAME, d.toString());
        contentValues.put(QUANTITY, e.toString());
        contentValues.put(UNITS, f.toString());
        sqLiteDatabase.update(TABLE_NAME2, contentValues, ITEMNAME + " =? ", new String[]{d});
        sqLiteDatabase.close();
        return dc;
    }

public void deleteSubItem(DataClass dc)
{
    String d=dc.getMitemName();
    SQLiteDatabase  sqLiteDatabase=this.getWritableDatabase();
    sqLiteDatabase.delete(TABLE_NAME2, ITEMNAME + " =? ", new String[]{d});
    sqLiteDatabase.close();

}


    public DataClass addSubList(DataClass dc)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME1+ " WHERE " + LISTNAME + " = ? ";
        Cursor c =sqLiteDatabase.rawQuery(retq, new String[]{dc.getMlistName()});
        c.moveToFirst();
        dc.setMdate(c.getString(1));
        c.close();
        sqLiteDatabase.close();
        String a=dc.getMdate();
        String b=dc.getMlistName();
        String d=dc.getMitemName();
        String e=dc.getMqty();
        String f=dc.getMunits();
        String g="XXXX";
        sqLiteDatabase=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(LISTNAME,b.toString());
        contentValues.put(ITEMNAME,d.toString());
        contentValues.put(QUANTITY,e.toString());
        contentValues.put(UNITS,f.toString());
        contentValues.put(REMARKS, "xxxx");
        contentValues.put(DATE, a.toString());
        sqLiteDatabase.insert(TABLE_NAME2, null, contentValues);

        System.out.println(a + "," + b + "," + d + "," + e + "," + f + "," + g);
     /*   String sql = "INSERT INTO "+ TABLE_NAME2+ " ( "+DATE+" , "+LISTNAME+" , "+ITEMNAME+" , "+QUANTITY+" , "+UNITS+" , "+REMARKS+" ) VALUES( "+a.toString()+" , "+b.toString()+" , "+d.toString()+" , "+e.toString()+" , "+f.toString()+" , "+g.toString()+" );";
        sqLiteDatabase.execSQL(sql);*/
        sqLiteDatabase.close();
        return dc;
    }

    DataClass getSubItemDetails(String s)
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME2+ " WHERE " + ITEMNAME + " = ? ";
        Cursor c =sqLiteDatabase.rawQuery(retq, new String[]{s});
        c.moveToFirst();

        String qty = " ";
        String unt=" ";


        qty = c.getString(4);
        unt = c.getString(5);
        DataClass wd = new DataClass();
        wd.setMitemName(s);
        wd.setMqty(qty);
        wd.setMunits(unt);
        return wd;
    }


}
