package com.madebymahadevbhaktshubh.commonpracticeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.madebymahadevbhaktshubh.commonpracticeapp.databinding.ActivityMainBinding;
import com.madebymahadevbhaktshubh.commonpracticeapp.models.Customer;
import com.madebymahadevbhaktshubh.commonpracticeapp.viewmodels.Mainviewmodel;

public class MainActivity extends AppCompatActivity {
    Mainviewmodel mainviewmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        ActivityMainBinding mainxml= DataBindingUtil.setContentView(this,R.layout.activity_main);

       // mainxml.setCname("Jai Shree Ram "); for primitive


//        Customer customer=new Customer("Shubham");
//        mainxml.setCustomer(customer);
        //khud ka model class bana ke use kiya 60% done here

        mainviewmodel= ViewModelProviders.of(this).get(Mainviewmodel.class);
        mainxml.setCustomer(mainviewmodel.getCustomer());

     }
}