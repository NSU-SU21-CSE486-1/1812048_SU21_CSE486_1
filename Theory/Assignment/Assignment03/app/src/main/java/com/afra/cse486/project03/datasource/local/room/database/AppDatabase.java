package com.afra.cse486.project03.datasource.local.room.database;

import android.content.Context;

import com.shawonarefin.android.roomdbv06.datasource.local.room.dao.StudentInfoDao;
import com.shawonarefin.android.roomdbv06.datasource.local.room.entity.StudentInfo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {StudentInfo.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
  public abstract StudentInfoDao studentInfoDao();

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
              .fallbackToDestructiveMigration()
              .build();
        }
      }
    }
    return INSTANCE;
  }
}
