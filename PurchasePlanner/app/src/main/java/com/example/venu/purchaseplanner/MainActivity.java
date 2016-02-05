package com.example.venu.purchaseplanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    DBManage dbManage;
    ListView mlv,listView;
    String mListName,mDate;
    MainListAdapter mainListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbManage = new DBManage(this);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ArrayList<DataClass> datas = dbManage.getList();
        //MainListAdapter mainListAdapter = new MainListAdapter(datas, this);
        mainListAdapter = new MainListAdapter(datas, this);
        listView = (ListView) findViewById(R.id.list2);
        listView.setAdapter(mainListAdapter);
        listView.setOnItemLongClickListener(this);
        Toast.makeText(MainActivity.this, "Long press any existing list item to delete it", Toast.LENGTH_LONG).show();

    }

  public void addListMethod(View v)
    {

        setContentView(R.layout.activity_create_list);
    }

    public void saveListMethod(View v) {

        EditText et=(EditText) findViewById(R.id.listname);
        DatePicker dp=(DatePicker) findViewById(R.id.datePicker);
        String ln=et.getText().toString();
        if(!ln.equals("To add item use '+' above  ")) {
            if (dbManage.searchList(ln) == true) {
                FragmentManager fragmentManager;
                fragmentManager = getFragmentManager();
                AlertMessage alertMessage = new AlertMessage();
                alertMessage.setMcontext(this);
                alertMessage.show(fragmentManager, "DefaultFragment");
            } else {
                if (!isEditTextInvisible(et)) {
                    String dt = new Integer(dp.getDayOfMonth()).toString() + "-" + new Integer(dp.getMonth() + 1).toString() + "-" + new Integer(dp.getYear()).toString();
                    dbManage.addList(dt, ln);
                    //System.out.println("--------------------------" + dt + "," + ln + "------------------");
                }
            }
            refresh();
        }
    }

   public void refresh()
   {

       setContentView(R.layout.activity_main);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
           }
       });
       dbManage = new DBManage(this);
       ArrayList<DataClass> datas =dbManage.getList();
       //MainListAdapter subListAdapter = new MainListAdapter(datas, this);
       mainListAdapter = new MainListAdapter(datas, this);
       ListView listView = (ListView) findViewById(R.id.list2);
       listView.setAdapter(mainListAdapter);
       listView.setOnItemLongClickListener(this);

       //((Activity) context).runOnUiThread(new Runnable() {
    /*   runOnUiThread(new Runnable() {
           @Override
           public void run() {
               mainListAdapter.notifyDataSetChanged();//Code for the UiThread

           }
       });*/
    Toast.makeText(MainActivity.this, "Long press any existing list item to delete it", Toast.LENGTH_LONG).show();
   }
    public void onMainItemSelectMethod(View v) {

        String s = ((TextView) v).getText().toString();
        //System.out.println("------------------------>>>" + s + "<<<<<--------------------------------");
        if (!s.trim().equals("To add item use '+' above")) {

            mListName = s;
            //System.out.println("------------------------<<<<<" + s + ">>>>>--------------------------------");
            ArrayList<DataClass> datas = dbManage.getSubList(s);
            setContentView(R.layout.activity_list_details);
            SubListAdapter subListAdapter = new SubListAdapter(datas, this);
            ListView listView = (ListView) findViewById(R.id.list1);
            listView.setAdapter(subListAdapter);
        }
    }
    public void backToActivityMain(View v)
    {

        refresh();
    }

    public void addSubItemMethod(View v) {
        setContentView(R.layout.activity_item_details);
        Button btn = (Button) findViewById(R.id.savemodify);
        btn.setText("Save");
        Button btn2 = (Button) findViewById(R.id.delete);
        btn2.setVisibility(View.INVISIBLE);

        Button bt=(Button) findViewById(R.id.blist);
        bt.setText(mListName);
            }
    public void deleteItemMethod (View v)
    {
        EditText et1 = (EditText) findViewById(R.id.iname2);
        EditText et2 = (EditText) findViewById(R.id.iqty2);
        EditText et3 = (EditText) findViewById(R.id.odetails2);
        String siName = et1.getText().toString();
        String siQty = et2.getText().toString();
        String siUnit = et3.getText().toString();
        DataClass dt = new DataClass();
        dt.setMlistName(mListName);
        dt.setMitemName(siName);
        dt.setMqty(siQty);
        dt.setMunits(siUnit);
        dbManage.deleteSubItem(dt);
        et1.setText("  ");
        et2.setText("  ");
        et3.setText("  ");

    }
    public void saveModifyMethod(View v) {
        boolean flag1,flag2,flag3,flag;
        Button bt=(Button) findViewById(R.id.savemodify);
        String s=bt.getText().toString();
      //  System.out.println("..................."+s+".......................");
        if(s.equalsIgnoreCase("save")) {

            EditText et1 = (EditText) findViewById(R.id.iname2);
            EditText et2 = (EditText) findViewById(R.id.iqty2);
            EditText et3 = (EditText) findViewById(R.id.odetails2);

            flag1=isEditTextInvisible(et1);
            flag2=isEditTextInvisible(et2);
            flag3=isEditTextInvisible(et3);
            flag=flag1 || flag2 || flag3;

            if(!flag) {
                String siName = et1.getText().toString();
                String siQty = et2.getText().toString();
                String siUnit = et3.getText().toString();
                String lnm = dbManage.searchItem(siName);
                if (lnm.equalsIgnoreCase("NIL")) {
                    DataClass dt = new DataClass();
                    dt.setMlistName(mListName);
                    dt.setMitemName(siName);
                    dt.setMqty(siQty);
                    dt.setMunits(siUnit);
                    dt = dbManage.addSubList(dt);
                    et1.setText("  ");
                    et2.setText("  ");
                    et3.setText("  ");
                } else {
                    FragmentManager fragmentManager;
                    fragmentManager = getFragmentManager();
                    ItemExistsAlert alertMessage = new ItemExistsAlert();
                    alertMessage.setMcontext(this);
                    alertMessage.setListName(lnm);
                    alertMessage.show(fragmentManager, "DefaultFragment");
                }
            }
        }
        if(s.equalsIgnoreCase("modify")) {
            EditText et1 = (EditText) findViewById(R.id.iname2);
            EditText et2 = (EditText) findViewById(R.id.iqty2);
            EditText et3 = (EditText) findViewById(R.id.odetails2);
            flag1 = isEditTextInvisible(et1);
            flag2 = isEditTextInvisible(et2);
            flag3 = isEditTextInvisible(et3);
            flag = flag1 || flag2 || flag3;

            if (!flag) {

                String siName = et1.getText().toString();
                String siQty = et2.getText().toString();
                String siUnit = et3.getText().toString();
                DataClass dt = new DataClass();
                dt.setMlistName(mListName);
                dt.setMitemName(siName);
                dt.setMqty(siQty);
                dt.setMunits(siUnit);
                dt = dbManage.modifySubItem(dt);
                et1.setText("  ");
                et2.setText("  ");
                et3.setText("  ");
            }
        }
    }

    public void onSubItemSelectedMethod(View view) {
        String s=((TextView)view).getText().toString();
        if (!s.trim().equals("To add item use '+' above")) {

            DataClass dt = dbManage.getSubItemDetails(s);
            setContentView(R.layout.activity_item_details);
            EditText et1, et2, et3;
            et1 = (EditText) findViewById(R.id.iname2);
            et1.setText(s);
            et2 = (EditText) findViewById(R.id.iqty2);
            et2.setText(dt.getMqty());
            et3 = (EditText) findViewById(R.id.odetails2);
            et3.setText(dt.getMunits());
            Button bt = (Button) findViewById(R.id.blist);
            bt.setText(mListName);
            Button bt2 = (Button) findViewById(R.id.savemodify);
            bt2.setText("Modify");
//        System.out.println("-------------------------------" + s + "--------------------------------");
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        String ss = ((TextView) view).getText().toString();
        if (!ss.trim().equals("To add item use '+' above")) {
            DataClass dc = dbManage.getRow(position);
            dbManage.setMainListAdapter(mainListAdapter);
            String s = dc.getMdate() + "," + dc.getMlistName() + "," + dc.getMslNo();
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager;
            fragmentManager = getFragmentManager();
            DeleteDialog deleteDialog = new DeleteDialog();
            deleteDialog.setMcontext(this);
            deleteDialog.setMoption(dc.getMlistName());
            deleteDialog.show(fragmentManager, "DefaultFragment");
            refresh();

        }return true;
    }
    public static boolean isEditTextInvisible( EditText et){
        String s = et.getText().toString();
        return s.trim().equals("");
    }

//------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
             getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
