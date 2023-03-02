package org.example.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.model.Appointment;
import java.util.Optional;

public class AppointmentRepository {
    public void createAppointment(EntityManager em, Appointment appointment){
        em.getTransaction().begin();
        em.persist(appointment);
        em.getTransaction().commit();
    }

    public Optional<Appointment> readAppointment(EntityManager em, String id){
        em.getTransaction().begin();
        Optional<Appointment> optionalAppointment = Optional.of(em.find(Appointment.class, id));
        em.getTransaction().commit();
        return optionalAppointment;
    }

    public void updateAppointment(EntityManager em, Appointment appointment){
        em.getTransaction().begin();
        em.merge(appointment);
        em.getTransaction().commit();
    }

    public void deleteAppointment(EntityManager em, Appointment appointment){
        em.getTransaction().begin();
        em.remove(appointment);
        em.getTransaction().commit();
    }
}
