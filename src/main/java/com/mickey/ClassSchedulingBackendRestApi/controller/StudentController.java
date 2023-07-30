package com.mickey.ClassSchedulingBackendRestApi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mickey.ClassSchedulingBackendRestApi.controller.extraUtils.BusinessLogic;
import com.mickey.ClassSchedulingBackendRestApi.model.Section;
import com.mickey.ClassSchedulingBackendRestApi.model.Student;
import com.mickey.ClassSchedulingBackendRestApi.repository.SectionRepository;
import com.mickey.ClassSchedulingBackendRestApi.repository.StudentsRepository;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
//@GetMapping("/ClassScheduling")
public class StudentController {
    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private SectionRepository sectionRepository;

//    List<Integer> SECTION_MAX_LIMIT = new ArrayList<Integer>();
    private final BusinessLogic businessLogic = new BusinessLogic();

    @PostMapping("/Class_Enrollment")
    Object newStudent(@RequestBody Student newStudent){
        List<Student> studentFinder = studentsRepository.findBySID(newStudent.getSid());
        List<Student> list_of_all_students_in_the_section = getAllStudentBySection(newStudent.getSection());
        List<Section>  SECTION_MAX_LIMIT = sectionRepository.findAll();
        if(studentFinder.size() > 0){
            if(studentFinder.get(0).getEmail().equals(newStudent.getEmail()) && studentFinder.get(0).getFirstName().equals(newStudent.getFirstName()) && studentFinder.get(0).getLastName().equals(newStudent.getLastName())) {
                if (studentFinder.get(0).getSection() == newStudent.getSection()) {
                    return "Already Registered to this section";
                } else {
                    return businessLogic.update(newStudent, list_of_all_students_in_the_section, SECTION_MAX_LIMIT, StudentController.this);
                }
            }else {
                return "STUDENT WITH DIFFERENT CREDENTIALS CANNOT HAVE SAME SID!!";
            }
        }else{
            return businessLogic.insert(newStudent, list_of_all_students_in_the_section, SECTION_MAX_LIMIT, StudentController.this);

//            return studentsRepository.save(newStudent);
        }
    }

/*
    @GetMapping("/View_Class_Schedule_With_Enrollment")
    List<Student> getAll(){
        return studentsRepository.findAll();
    }

 */

//    @GetMapping(path="/filterbySection/{section}")      //TODO:    https://www.youtube.com/watch?v=J8Q0wNL9xVU&pp=ygUqaG93IHRvIHRha2UgdmFsdWUgZnJvbSB1cmwgaW4gc3ByaW5nIGJvb3Qg
//    int getAllST(@PathVariable int section){
//        int no_of_seats_booked = studentsRepository.getAllStudent(section);
//    }





//    @GetMapping(path="/filterbySection/")
    List<Student> getAllStudentBySection(int section){
        return studentsRepository.getAllStudentBySection(section);
    }



    @GetMapping(path="/filterbySection")
    Object getAllST() throws Exception{

        List<Section>  SECTION_MAX_LIMIT = sectionRepository.findAll();
        Map<Integer, Integer> data = new HashMap<>();

        for(int sectionNO = 1; sectionNO <= 4; sectionNO++){
            data.put(sectionNO, SECTION_MAX_LIMIT.get(sectionNO - 1).getNo_of_seats_booked_so_far() - studentsRepository.getNoOfStudentInTheSection(sectionNO));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(data);
    }


//    TODO : this method is for temporary use

/*
    @GetMapping(path = "/SettingDummySectionSeatValues")
    void insertSectionValues(){

        int [] sec = {51, 1, 12, 26};

        for(int i = 0; i < 4; i++){
            Section section = new Section();
            section.setSection(i+1);
            section.setNo_of_seats_booked_so_far(sec[i]);
            sectionRepository.save(section);

        }
    }
*/



    public Object update(int section, String sid){
        studentsRepository.updateStudentByID(section, sid);
        return "SUCCESSFULLY UPDATED";
    }

    public Object insert(Student student){
        studentsRepository.save(student);
        return "SUCCESSFULLY REGISTERED";
    }
}
