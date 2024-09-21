package com.madebymahadevbhaktshubh.commonpracticeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewbinding.ViewBinding;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.madebymahadevbhaktshubh.commonpracticeapp.databinding.ActivityMainBinding;
import com.madebymahadevbhaktshubh.commonpracticeapp.viewmodels.CheezyModelView;
import com.madebymahadevbhaktshubh.commonpracticeapp.viewmodels.Mainviewmodel;

public class CheezyCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheezy_code);
        TextView tv1=findViewById(R.id.factstv_cheezy);
        Button bt1=findViewById(R.id.btn_update_cheezy);

        CheezyModelView cheezyModelView=new ViewModelProvider(this).get(CheezyModelView.class);

        cheezyModelView.factslivedata.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
               tv1.setText(s);
            }
        });

//        cheezyModelView.factslivedata.postValue("hello");
//        cheezyModelView.factslivedata.setValue("hello2");

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cheezyModelView.updatefacetlivedata();
            }
        });
    }
}