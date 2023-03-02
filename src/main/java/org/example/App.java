package org.example;

import org.example.model.Appointment;
import org.example.service.AppointmentService;

import java.util.Optional;

public class App
{
    public static void main( String[] args )
    {
        Appointment a1 = new Appointment("Doctor's appointment", "going to the doctor's for a regular checkup", 2023, 2, 28, 12, 12);
        Appointment a2 = new Appointment("Dentist's appointment", "going to the dentist's for a regular checkup", 2023, 3, 1, 11, 0);
        Appointment a3 = new Appointment("Psychologist's appointment", "going to the psychologist's for my violent and murderous tendencies", 6666, 6, 6, 6, 6);

        AppointmentService as = new AppointmentService();

        as.create(a1);
        as.create(a2);
        as.create(a3);

        Optional<Appointment> maybe = as.read("2023Y_03M_01D_11h_00m");
        if(maybe.isPresent()){
            Appointment appointment = maybe.get();
            appointment.setDescription("going to the dentist to get my wisodm teeth pulled");
            as.update(appointment);
        } else {
            System.out.println("No appointment found");
        }


        as.delete("6666Y_06M_06D_06h_06m");
    }
}
