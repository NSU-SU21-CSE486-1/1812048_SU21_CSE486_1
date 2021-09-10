package com.afra.cse486.project03.datasource.local.room.database;

import android.content.Context;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.afra.cse486.project03.datasource.local.room.dao.PhoneDao;
import com.afra.cse486.project03.datasource.local.room.dao.StudentInfoDao;
import com.afra.cse486.project03.datasource.local.room.dao.UniAffDao;
import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.datasource.local.room.entity.UniAffiliation;

@Database(entities = {StudentInfo.class, UniAffiliation.class, Phone.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
  public abstract StudentInfoDao studentInfoDao();
  public abstract PhoneDao phoneDao();
  public abstract UniAffDao uniAffDao();

  private static AppDatabase INSTANCE;
  private static final int NUMBER_OF_THREADS = 4;
  private static final ExecutorService databaseWriteExecutor =
      Executors.newFixedThreadPool(NUMBER_OF_THREADS);

  public static ExecutorService getDatabaseWriteExecutor(){
    return databaseWriteExecutor;
  }

  public static AppDatabase getDatabase(final Context context){
    if(INSTANCE == null){
      synchronized (AppDatabase.class){
        if(INSTANCE == null){
          INSTANCE = Room.databaseBuilder(context.getApplicationContext()
              ,AppDatabase.class, "student_db")
              .fallbackToDestructiveMigration().allowMainThreadQueries()
              .build();
        }
      }
    }
    return INSTANCE;
  }
}
