package com.madebymahadevbhaktshubh.commonpracticeapp.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CheezyModelView extends AndroidViewModel {
  /*  public MutableLiveData<String> factslivedata;

    public CheezyModelView(@NonNull Application application) {
        super(application);
        factslivedata= new MutableLiveData<String>("This is fact");
    }

    public void updatefacetlivedata(){
        factslivedata.setValue("Another Fact");
    }

   */
  private final MutableLiveData<String> _factslivedata = new MutableLiveData<>("This is fact");
    public LiveData<String> factslivedata = _factslivedata;//factslivedata is exposed as LiveData, which is read-only for external classes.

    public CheezyModelView(@NonNull Application application) {
        super(application);
    }

    public void updatefacetlivedata() {
        _factslivedata.setValue("Another Fact");
    }
}


