package com.example.nevostrueva.tditestproject;

import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class SelectPictureActivity extends ActionBarActivity {

    private ImageView selectedPic;
    private RetainedFragment curPictureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_picture);

        selectedPic = (ImageView) findViewById(R.id.selectedPicView);
        Button firstPicBtn = (Button) findViewById(R.id.firstPicBtn);
        Button secondPicBtn = (Button) findViewById(R.id.secondPicBtn);
        Button thirdPicBtn = (Button) findViewById(R.id.thirdPicBtn);

        FragmentManager fm = getFragmentManager();
        curPictureFragment = (RetainedFragment) fm.findFragmentByTag("picture");

        /* Create the fragment the first time*/
        if (curPictureFragment == null) {
            curPictureFragment = new RetainedFragment();
            fm.beginTransaction().add(curPictureFragment, "picture").commit();
            curPictureFragment.setData(getResources().getDrawable(R.drawable.ratatui_1));
        }

        /* Get the picture for the first time or after change screen orientation */
        selectedPic.setImageDrawable(curPictureFragment.getData());
    }

    public void selectPicture(View v) {
        switch (v.getId()){
            case R.id.firstPicBtn:
                selectedPic.setImageResource(R.drawable.ratatui_1);
                break;
            case R.id.secondPicBtn:
                selectedPic.setImageResource(R.drawable.ratatui_2);
                break;
            case R.id.thirdPicBtn:
                selectedPic.setImageResource(R.drawable.ratatui_3);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        /* Store the data in the fragment */
        curPictureFragment.setData(selectedPic.getDrawable());
    }

}
