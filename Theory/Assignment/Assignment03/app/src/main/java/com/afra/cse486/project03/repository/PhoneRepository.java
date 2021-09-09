package com.afra.cse486.project03.repository;

import androidx.lifecycle.LiveData;

import com.afra.cse486.project03.datasource.local.room.dao.PhoneDao;
import com.afra.cse486.project03.datasource.local.room.entity.Phone;

import java.util.List;

public class PhoneRepository implements PhoneDao {
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
    public LiveData<Phone> getStudent(String number) {
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
