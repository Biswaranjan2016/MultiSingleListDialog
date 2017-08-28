package com.example.happy.multisinglelist;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiSingleChoiceFrag extends DialogFragment {


    public MultiSingleChoiceFrag() {
        // Required empty public constructor
    }

    public Dialog onCreateDialog(Bundle savedInstance){
        //Where we track the selected Item
        final List<Integer> mSelectedItems = new ArrayList<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //Set the dialog Title
        builder.setTitle("Pick the topings")

        //Specify the list array, the items to be seleced by default (null or none)
        //and the listener through which to recieve the callbacks when items are selected.
                .setMultiChoiceItems(R.array.multipleChoices, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if(isChecked){

                            //If the user selects the item add the item to the selected list
                            mSelectedItems.add(which);

                        }else if(mSelectedItems.contains(which)){

                            //else if the item is already in the array remove it.
                            mSelectedItems.remove(Integer.valueOf(which));

                        }
                    }
                })
        //Set the positive Button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }

}
