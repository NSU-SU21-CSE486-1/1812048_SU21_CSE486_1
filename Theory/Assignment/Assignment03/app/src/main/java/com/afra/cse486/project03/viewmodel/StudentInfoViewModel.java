package com.afra.cse486.project03.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;


import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.repository.StudentRepository;
import com.afra.cse486.project03.uicontroller.DBListenerInterface;

import java.util.List;

public class StudentInfoViewModel extends AndroidViewModel {

  private StudentRepository mRepository;
  private LiveData<List<Integer>> mAllStudentIds;
  private LiveData<List<StudentInfo>> mAllStudents;

  public StudentInfoViewModel(@NonNull Application application) {
    super(application);
    mRepository = new StudentRepository(application);
    mAllStudentIds = mRepository.getAllStudentIDs();
    mAllStudents = mRepository.getAllStudents();
  }

  public LiveData<List<Integer>> getAllStudentIds() {
    return mAllStudentIds;
  }
  public LiveData<List<StudentInfo>> getAllStudents() {return mAllStudents;}

  public void insert(StudentInfo info){
    mRepository.insert(info);
  }

  public void insert1(StudentInfo info, DBListenerInterface listen){
    mRepository.insert1(info, listen);
  }

  public void insertAll(StudentInfo... infos){
    mRepository.insertAll(infos);
  }
  public void delete(StudentInfo info){
    mRepository.delete(info);
  }
  public void deleteAll(StudentInfo... infos){
    mRepository.deleteAll(infos);
  }
  public void update(StudentInfo info){
    mRepository.update(info);
  }
  public void updateAll(StudentInfo... infos){
    mRepository.updateAll(infos);
  }

  public LiveData<StudentInfo> getStudent(Integer id){
    return mRepository.getStudent(id);
  }
}
