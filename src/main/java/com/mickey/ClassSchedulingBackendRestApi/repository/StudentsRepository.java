package com.mickey.ClassSchedulingBackendRestApi.repository;

import com.mickey.ClassSchedulingBackendRestApi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Long> {

    @Query("SELECT S FROM Student S WHERE S.section=:section")
    List<Student> getAllStudentBySection(@Param("section") int section);

    @Query("SELECT COUNT(S) FROM Student S WHERE S.section=:section")
    int getNoOfStudentInTheSection(@Param("section") int section);


    @Query("SELECT S FROM Student S WHERE S.sid=:sid")
    List<Student> findBySID(@Param("sid") String sid);


    @Transactional
    @Modifying
    @Query("UPDATE Student S SET S.section=:section WHERE S.sid=:sid")
    void updateStudentByID(@Param("section") int section, @Param("sid") String sid);
//    Student findByName(String name);

//    List<Student> findAllById(int i);
}
