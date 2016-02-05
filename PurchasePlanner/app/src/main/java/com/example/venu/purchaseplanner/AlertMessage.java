package com.example.venu.purchaseplanner;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by sujatha on 2/1/2016.
 */
public class AlertMessage extends DialogFragment{



        Context mcontext;

        public AlertMessage() { }


        public void setMcontext(Context mcontext) {
            this.mcontext = mcontext;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                    .setIcon(R.drawable.alert)
                    .setTitle("Alert")
                    .setMessage("List Name Already Exists!")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            dialog.dismiss();

                        }
                    }).create();


        }
    }



