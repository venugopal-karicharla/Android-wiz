package com.example.venu.dbexample2;


        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by sujatha on 1/6/2016.
 */
public class DataBaseClass extends SQLiteOpenHelper {
    private static final String DBNAME="productDB";
    private static final String TABLE_NAME="product_table";
    private static final int VERSION=1;

    private static final String PRODUCT="product";


    public DataBaseClass(Context context) {
        super(context, DBNAME, null, VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creat_product_table = "CREATE TABLE "+TABLE_NAME +"("+PRODUCT+ " STRING"+")";
        db.execSQL((creat_product_table));
        ContentValues contentValues=new ContentValues();
        contentValues.put(PRODUCT, "  ");
        db.insert(TABLE_NAME, null, contentValues);
        //db.addProduct("default");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addProduct(String p)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(PRODUCT,p);
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }

    public String viewData()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME;
        Cursor c =sqLiteDatabase.rawQuery(retq, null);
        c.moveToFirst();
        String prods=" ";
        do
        {
            String prod=c.getString(0);
            //Toast.makeText(RetrievedActivity.this, c.getString(1), Toast.LENGTH_SHORT).show();
            prods+=",";
            prods+=prod;

        }while(c.moveToNext());

        c.close();
        sqLiteDatabase.close();
        return prods;
    }

    public List<String> viewDataItems()
    {
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        String retq="SELECT * FROM " + TABLE_NAME;
        Cursor c =sqLiteDatabase.rawQuery(retq, null);
        String[] prods=null;
        List<String> x=new ArrayList<>();
        c.moveToFirst();
            prods = new String[100];
            int i = 0;
            do {
                x.add(c.getString(0));
                //Toast.makeText(RetrievedActivity.this, c.getString(1), Toast.LENGTH_SHORT).show();
                i++;
            } while (c.moveToNext());

        c.close();
        sqLiteDatabase.close();
        return x;
    }
}
