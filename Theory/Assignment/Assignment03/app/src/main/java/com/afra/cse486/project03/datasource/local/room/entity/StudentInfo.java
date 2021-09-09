package com.afra.cse486.project03.datasource.local.room.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "student_info")
public class StudentInfo {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "id")
  private String studentID;

  @ColumnInfo(name = "name")
  private String studentName;

  public StudentInfo(@NonNull String studentName, String studentID
      ){
    this.studentID = studentID;
    this.studentName = studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }
  public void setStudentID(String studentID) {
    this.studentID = studentID;
  }


  @NonNull
  public String getStudentID() {
    return studentID;
  }

  public String getStudentName() {
    return studentName;
  }

}
