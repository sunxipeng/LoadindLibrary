package com.sunxipeng.loadindlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import view.CustomFramLayout;

public class MainActivity extends AppCompatActivity implements CustomFramLayout.InflateviewListener, View.OnClickListener {

    private CustomFramLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        layout = new CustomFramLayout(this,this);

        setContentView(layout);

        layout.setOnLoadingClickListener(this);

        layout.setOnEmptyClickListener(this);

        layout.setOnErrorClickListener(this);

        layout.setOnSuccessClickListener(this);
    }


    @Override
    public View getView() {
        return getLayoutInflater().inflate(R.layout.activity_main,null);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.loading:
                layout.showloading();

                break;
            case R.id.empty:

                layout.showempty();
                break;
            case R.id.error:
                layout.showerror();
                break;
            case R.id.success:

                layout.showsuccess();
                break;
        }
    }
}
