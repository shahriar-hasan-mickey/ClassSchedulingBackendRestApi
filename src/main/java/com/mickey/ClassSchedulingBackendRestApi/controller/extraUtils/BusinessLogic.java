package com.mickey.ClassSchedulingBackendRestApi.controller.extraUtils;

import com.mickey.ClassSchedulingBackendRestApi.controller.StudentController;
import com.mickey.ClassSchedulingBackendRestApi.model.Section;
import com.mickey.ClassSchedulingBackendRestApi.model.Student;

import java.util.List;

public class BusinessLogic {


    public Object update(Student newStudent, List<Student>  list_of_all_students_in_the_section, List<Section> SECTION_MAX_LIMIT, StudentController studentController){
        switch (newStudent.getSection()) {
            case 1:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(0).getNo_of_seats_booked_so_far()) {
                    return studentController.update(newStudent.getSection(), newStudent.getSid());
                } else {
                    return "Section has no free seat";
                }

            case 2:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(1).getNo_of_seats_booked_so_far()) {
                    return studentController.update(newStudent.getSection(), newStudent.getSid()) + " "+ list_of_all_students_in_the_section.size();
                } else {
                    return "Section has no free seat";
                }
            case 3:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(2).getNo_of_seats_booked_so_far()) {
                    return studentController.update(newStudent.getSection(), newStudent.getSid());
                } else {
                    return "Section has no free seat";
                }
            case 4:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(3).getNo_of_seats_booked_so_far()) {
                    return studentController.update(newStudent.getSection(), newStudent.getSid());
                } else {
                    return "Section has no free seat";
                }
        }
        return null;
    }



    public Object insert(Student newStudent, List<Student>  list_of_all_students_in_the_section, List<Section> SECTION_MAX_LIMIT, StudentController studentController){
        switch (newStudent.getSection()) {
            case 1:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(0).getNo_of_seats_booked_so_far()) {
                    return studentController.insert(newStudent);
                } else {
                    return "Section has no free seat";
                }

            case 2:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(1).getNo_of_seats_booked_so_far()) {
                    return studentController.insert(newStudent);
                } else {
                    return "Section has no free seat";
                }
            case 3:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(2).getNo_of_seats_booked_so_far()) {
                    return studentController.insert(newStudent);
                } else {
                    return "Section has no free seat";
                }
            case 4:
                if (list_of_all_students_in_the_section.size() < SECTION_MAX_LIMIT.get(3).getNo_of_seats_booked_so_far()) {
                    return studentController.insert(newStudent);
                } else {
                    return "Section has no free seat";
                }
        }
        return null;
    }
}
