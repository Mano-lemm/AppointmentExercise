package org.example.service;

import jakarta.persistence.*;
import org.example.model.Appointment;
import org.example.repository.AppointmentRepository;

import java.util.Optional;

public class AppointmentService {
    public class EntityManagerProvider{
        private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Appointmentdb");

        public static EntityManager getEm() {
            return emf.createEntityManager();
        }
    }

    private AppointmentRepository apr = new AppointmentRepository();

    public void create(Appointment appointment){
        EntityManager em = EntityManagerProvider.getEm();
        apr.createAppointment(em, appointment);
        em.close();
    }

    public void update(Appointment appointment){
        EntityManager em = EntityManagerProvider.getEm();
        apr.updateAppointment(em, appointment);
        em.close();
    }

    public Optional<Appointment> read(String id){
        EntityManager em = EntityManagerProvider.getEm();
        Optional<Appointment> optionalAppointment = apr.readAppointment(em, id);
        em.close();
        return optionalAppointment;
    }

    public void delete(String id){
        EntityManager em = EntityManagerProvider.getEm();
        Optional<Appointment> perhapsEven = apr.readAppointment(em, id);
        perhapsEven.ifPresent(appointment -> apr.deleteAppointment(em, appointment));
        em.close();
    }
}
