package com.mickey.ClassSchedulingBackendRestApi.repository;

import com.mickey.ClassSchedulingBackendRestApi.model.Section;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Long> {
//    @Query("SELECT S FROM Student S")
//    List<Section> getAllStudentBySection();

//    @Modifying
//    @Query("INSERT INTO SECTION S (section) VALUES (:no_of_seats_booked_so_far)")
//    void insert(@Param("section") int section, @Param("no_of_seats_booked_so_far") int no_of_seats_booked_so_far);
//TODO : https://stackoverflow.com/questions/42739566/how-to-use-jpa-query-to-insert-data-into-db

}
