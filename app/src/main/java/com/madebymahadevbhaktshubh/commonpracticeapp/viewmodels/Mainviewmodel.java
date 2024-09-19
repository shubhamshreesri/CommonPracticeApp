package com.madebymahadevbhaktshubh.commonpracticeapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.madebymahadevbhaktshubh.commonpracticeapp.models.Customer;

public class Mainviewmodel extends AndroidViewModel {
    Customer customer;
    public Mainviewmodel(@NonNull Application application) {
        super(application);
        customer=new Customer("shubham srivastava");
    }

    public Customer getCustomer() {
        return this.customer;
    }
}
