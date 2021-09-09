package com.afra.cse486.project03.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;



import com.afra.cse486.project03.datasource.local.room.dao.StudentInfoDao;
import com.afra.cse486.project03.datasource.local.room.database.AppDatabase;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.uicontroller.DBListenerInterface;

import java.util.List;

public class StudentRepository {
  private StudentInfoDao mStudentInfoDao;
  private LiveData<List<Integer>> mAllStudentIds;
  private LiveData<List<StudentInfo>> mAllStudents;


  public StudentRepository(Application application){
    AppDatabase db = AppDatabase.getDatabase(application);
    mStudentInfoDao = db.studentInfoDao();
    mAllStudentIds = mStudentInfoDao.getAllIds();
    mAllStudents = mStudentInfoDao.getAllStudents();
  }

  public LiveData<List<Integer>> getAllStudentIDs(){
    return mAllStudentIds;
  }

  public LiveData<List<StudentInfo>> getAllStudents(){
    return mAllStudents;
  }

  // Room executes all queries on a separate thread.
  // Observed LiveData will notify the observer when the data has changed.
  public LiveData<StudentInfo> getStudent(Integer id){
    return mStudentInfoDao.getStudent(id);
  }

  public void insert(StudentInfo studentInfo){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.insert(studentInfo);
    });
  }

  public void insert1(StudentInfo studentInfo, DBListenerInterface listen ){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      long result = mStudentInfoDao.insert1(studentInfo);
      if(result == 0){
        listen.failed();
      }else{
        listen.passed();
      }
    });
  }

  public void insertAll(StudentInfo... studentInfos){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.insertAll(studentInfos);
    });
  }

  public void delete(StudentInfo studentInfo){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.delete(studentInfo);
    });
  }

  public void deleteAll(StudentInfo... studentInfos){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.deleteAll(studentInfos);
    });
  }

  public void update(StudentInfo studentInfo){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.update(studentInfo);
    });
  }

  public void updateAll(StudentInfo... studentInfos){
    AppDatabase.getDatabaseWriteExecutor().execute(()->{
      mStudentInfoDao.updateAll(studentInfos);
    });
  }
}
