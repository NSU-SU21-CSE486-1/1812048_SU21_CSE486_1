package com.afra.cse486.project03.datasource.local.room.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.afra.cse486.project03.datasource.local.room.entity.Phone;
import com.afra.cse486.project03.datasource.local.room.entity.StudentInfo;

import java.util.List;

/**
 * Perform CRUD operations on student_info table defined by StudentInfo entity
 * C = @Insert
 * R = @Query
 * U = @Update
 * D = @Delete
 */
@Dao
public interface PhoneDao {
  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insert(Phone phone);

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  void insertAll(Phone... Phone);


  @Query("SELECT * FROM phone ORDER BY tag ASC")
  LiveData<List<Phone>> getAllPhone();

  @Query("SELECT * FROM phone WHERE number LIKE :number LIMIT 1")
  LiveData<Phone> getPhone(String number);

  @Update
  void update(Phone phone);

  @Update
  void updateAll(Phone... phones);

  @Delete
  void delete(Phone phone);

  @Delete
  void deleteAll(Phone... phones);
}
