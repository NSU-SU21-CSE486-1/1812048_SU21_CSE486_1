package com.afra.cse486.project03.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.afra.cse486.project03.datasource.local.room.dao.PhoneDao;
import com.afra.cse486.project03.datasource.local.room.dao.StudentInfoDao;
import com.afra.cse486.project03.datasource.local.room.database.AppDatabase;
import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.uicontroller.DBListenerInterface;

import java.util.List;

public class PhoneRepository{

    private PhoneDao mPhoneDao;
    private List<Phone> mAllPhone;

    public PhoneRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        mPhoneDao = db.phoneDao();
        mAllPhone = mPhoneDao.getAllPhone();
    }


    public void insert(Phone phone) {
      AppDatabase.getDatabaseWriteExecutor().execute(()->{
        mPhoneDao.insert(phone);
      });
    }


    public void insert1(Phone phone, DBListenerInterface listen ){
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            long result = mPhoneDao.insert1(phone);
            if(result == 0){
                listen.failed();
            }else{
                listen.passed();
            }
        });
    }

    public void insertAll(Phone... phone) {
      AppDatabase.getDatabaseWriteExecutor().execute(()->{
        mPhoneDao.insertAll(phone);
      });
    }


    public List<Phone> getAllPhone() {
        return mAllPhone;
    }


    public LiveData<Phone> getPhone(String number) {
        return mPhoneDao.getPhone(number);
    }


    public void update(Phone phone) {
      AppDatabase.getDatabaseWriteExecutor().execute(()->{
        mPhoneDao.update(phone);
      });
    }


    public void updateAll(Phone... phones) {
      AppDatabase.getDatabaseWriteExecutor().execute(()->{
        mPhoneDao.updateAll(phones);
      });
    }


    public void delete(Phone phone) {
      AppDatabase.getDatabaseWriteExecutor().execute(()->{
        mPhoneDao.delete(phone);
      });
    }


    public void deleteAll(Phone... phones) {
      AppDatabase.getDatabaseWriteExecutor().execute(()->{
        mPhoneDao.deleteAll(phones);
      });
    }
}
