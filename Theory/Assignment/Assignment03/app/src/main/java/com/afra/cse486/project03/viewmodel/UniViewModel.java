package com.afra.cse486.project03.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.datasource.local.room.entity.UniAffiliation;
import com.afra.cse486.project03.repository.StudentRepository;
import com.afra.cse486.project03.repository.UniRepository;
import com.afra.cse486.project03.uicontroller.DBListenerInterface;

import java.util.List;

public class UniViewModel extends AndroidViewModel {

  private UniRepository mRepository;
  private LiveData<List<UniAffiliation>>  mAllUni;

  public UniViewModel(@NonNull Application application) {
    super(application);
    mRepository = new UniRepository(application);
    mAllUni = mRepository.getAllUni();
  }

  public LiveData<List<UniAffiliation>> getAllUni() {return mAllUni;}

  public void insert(UniAffiliation info){
    mRepository.insert(info);
  }



  public void insertAll(UniAffiliation... infos){
    mRepository.insertAll(infos);
  }
  public void delete(UniAffiliation info){
    mRepository.delete(info);
  }
  public void deleteAll(UniAffiliation... infos){
    mRepository.deleteAll(infos);
  }
  public void update(UniAffiliation info){
    mRepository.update(info);
  }
  public void updateAll(UniAffiliation... infos){
    mRepository.updateAll(infos);
  }


}
