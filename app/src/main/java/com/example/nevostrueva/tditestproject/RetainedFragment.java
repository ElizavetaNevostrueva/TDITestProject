package com.example.nevostrueva.tditestproject;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

/*
* Fragment is necessary for handling runtime changes
*/

public class RetainedFragment extends Fragment {

    /* Picture we want to retain */
    private Drawable curPicture;

    /*
    * This method is only called once for this fragment
    */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public void setData (Drawable data) {
        this.curPicture = data;
    }

    public Drawable getData() {
        return curPicture;
    }
}
