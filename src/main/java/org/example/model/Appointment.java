package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class Appointment {
    @Id
    String id;
    String title;
    String description;
    Timestamp dateAndTime;

    protected Appointment(){
    }

    public Appointment(String title, String description, int year, int month, int day, int hour, int minute){
        this.id = String.format("%4dY_%02dM_%02dD_%02dh_%02dm", year, month, day, hour, minute);
        this.title = title;
        this.description = description;
        this.dateAndTime = Timestamp.valueOf(LocalDateTime.of(year, month, day, hour, minute));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Appointment that = (Appointment) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
