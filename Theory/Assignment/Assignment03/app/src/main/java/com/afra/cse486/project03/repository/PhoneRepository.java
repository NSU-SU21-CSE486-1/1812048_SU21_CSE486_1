package com.afra.cse486.project03.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.afra.cse486.project03.datasource.local.room.dao.PhoneDao;
import com.afra.cse486.project03.datasource.local.room.dao.StudentInfoDao;
import com.afra.cse486.project03.datasource.local.room.database.AppDatabase;
import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;

import java.util.List;

public class PhoneRepository implements PhoneDao {

    private PhoneDao mPhoneDao;
  //  private LiveData<List<Integer>> mAllStudentIds;
    private LiveData<List<Phone>> mAllPhone;
    public PhoneRepository(Application application) {

        AppDatabase db = AppDatabase.getDatabase(application);
        mPhoneDao = db.phoneDao();
        mAllPhone = mPhoneDao.getAllPhone();
    }

    @Override
    public void insert(Phone phone) {

    }

    @Override
    public void insertAll(Phone... Phone) {

    }

    @Override
    public LiveData<List<Phone>> getAllPhone() {
        return null;
    }

    @Override
    public LiveData<Phone> getPhone(String number) {
        return null;
    }

    @Override
    public void update(Phone phone) {

    }

    @Override
    public void updateAll(Phone... phones) {

    }

    @Override
    public void delete(Phone phone) {

    }

    @Override
    public void deleteAll(Phone... phones) {

    }
}
