package com.mickey.ClassSchedulingBackendRestApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Section")
public class Section {

    @Id
    @GeneratedValue
    private Long id;
    private int section;
    private int no_of_seats_booked_so_far;

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getNo_of_seats_booked_so_far() {
        return no_of_seats_booked_so_far;
    }

    public void setNo_of_seats_booked_so_far(int no_of_seats_booked_so_far) {
        this.no_of_seats_booked_so_far = no_of_seats_booked_so_far;
    }
//    public Section(int section, int no_of_seats_booked_so_far) {
//        this.section = section;
//        this.no_of_seats_booked_so_far = no_of_seats_booked_so_far;
//    }
}
