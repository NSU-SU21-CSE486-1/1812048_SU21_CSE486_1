package com.afra.cse486.project03.datasource.local.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;
import com.afra.cse486.project03.datasource.local.room.entity.UniAffiliation;

import java.util.List;

/**
 * Perform CRUD operations on student_info table defined by StudentInfo entity
 * C = @Insert
 * R = @Query
 * U = @Update
 * D = @Delete
 */
@Dao
public interface UniAffDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(UniAffiliation uniAffiliation);


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertAll(UniAffiliation... uniAffiliations);


  @Query("SELECT * FROM uni_affiliation ORDER BY uniname ASC")
  LiveData<List<UniAffiliation>> getAllUni();


  @Update
  void update(UniAffiliation uniAffiliation);

  @Update
  void updateAll(UniAffiliation... uniAffiliations);

  @Delete
  void delete(UniAffiliation uniAffiliation);

  @Delete
  void deleteAll(UniAffiliation... uniAffiliations);
}
