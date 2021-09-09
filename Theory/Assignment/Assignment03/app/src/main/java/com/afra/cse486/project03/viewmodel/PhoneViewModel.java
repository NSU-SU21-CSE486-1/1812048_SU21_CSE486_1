package com.afra.cse486.project03.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.repository.PhoneRepository;
import com.afra.cse486.project03.repository.StudentRepository;
import com.afra.cse486.project03.uicontroller.DBListenerInterface;

import java.util.List;

public class PhoneViewModel extends AndroidViewModel {

  private PhoneRepository mRepository;
  private LiveData<List<Phone>> mAllPhones;

  public PhoneViewModel(@NonNull Application application) {
    super(application);
    mRepository = new PhoneRepository(application);
    mAllPhones = mRepository.getAllPhone();

  }

  public LiveData<List<Phone>> getAllPhone() {return mAllPhones;}

  public void insert(Phone info){
    mRepository.insert(info);
  }


  public void insertAll(Phone... phones){
    mRepository.insertAll(phones);
  }
  public void delete(Phone phone){
    mRepository.delete(phone);
  }
  public void deleteAll(Phone... phones){
    mRepository.deleteAll(phones);
  }
  public void update(Phone phone){
    mRepository.update(phone);
  }
  public void updateAll(Phone... phones){
    mRepository.updateAll(phones);
  }

  public LiveData<Phone> getPhone(String number){
    return mRepository.getPhone(number);
  }
}
