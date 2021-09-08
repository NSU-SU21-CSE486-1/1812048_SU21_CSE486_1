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
  private final Integer studentID;

  @ColumnInfo(name = "name")
  private String studentName;

  @ColumnInfo(name = "age")
  private Integer studentAge;

  public StudentInfo(@NonNull Integer studentID
      , String studentName
      , @NonNull Integer studentAge){
    this.studentID = studentID;
    this.studentName = studentName;
    this.studentAge = studentAge;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public void setStudentAge(Integer studentAge) {
    this.studentAge = studentAge;
  }

  @NonNull
  public Integer getStudentID() {
    return studentID;
  }

  public String getStudentName() {
    return studentName;
  }

  public Integer getStudentAge() {
    return studentAge;
  }
}
