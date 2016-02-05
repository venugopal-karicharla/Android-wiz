package com.example.venu.purchaseplanner;

/**
 * Created by sujatha on 1/24/2016.
 */


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ViewParent;

/**
 * Created by Akhilesh on 1/12/16.
 */
public class DeleteDialog extends DialogFragment {
        String moption;
        Context mcontext;

    public DeleteDialog() {
    }

    public void setMoption(String moption) {
        this.moption = moption;
    }

    public void setMcontext(Context mcontext) {
        this.mcontext = mcontext;
    }

     @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setIcon(R.drawable.ask)
                .setTitle("Delete a List?")
                .setMessage("Do you want to delete the selected list!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    DBManage dbm=new DBManage(mcontext);
                    //System.out.println(dbm.deleteRow(moption));
                    dbm.deleteRow(moption);

                    dialog.dismiss();
                   }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();

    }
}

