package com.afra.cse486.project03.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.afra.cse486.project03.datasource.local.room.dao.StudentInfoDao;
import com.afra.cse486.project03.datasource.local.room.dao.UniAffDao;
import com.afra.cse486.project03.datasource.local.room.database.AppDatabase;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.datasource.local.room.entity.UniAffiliation;

import java.util.List;

public class UniRepository implements UniAffDao {
    private UniAffDao mUniAffDao;
    private LiveData<List<UniAffiliation>> mAllUni;

    public UniRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        mUniAffDao = db.uniAffDao();
        mAllUni = mUniAffDao.getAllUni();
    }

    @Override
    public void insert(UniAffiliation uniAffiliation) {
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            mUniAffDao.insert(uniAffiliation);
        });

    }

    @Override
    public void insertAll(UniAffiliation... uniAffiliations) {
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            mUniAffDao.insertAll(uniAffiliations);
        });
    }

    @Override
    public LiveData<List<UniAffiliation>> getAllUni() {
        return null;
    }

    @Override
    public void update(UniAffiliation uniAffiliation) {
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            mUniAffDao.update(uniAffiliation);
        });
    }

    @Override
    public void updateAll(UniAffiliation... uniAffiliations) {
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            mUniAffDao.updateAll(uniAffiliations);
        });
    }

    @Override
    public void delete(UniAffiliation uniAffiliation) {
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            mUniAffDao.delete(uniAffiliation);
        });

    }

    @Override
    public void deleteAll(UniAffiliation... uniAffiliations) {
        AppDatabase.getDatabaseWriteExecutor().execute(()->{
            mUniAffDao.deleteAll(uniAffiliations);
        });
    }
}
