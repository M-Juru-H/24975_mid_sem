package com.auca.GarageApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.auca.GarageApplication.Model.Appointments;

public interface AppointmentsRepo extends JpaRepository<Appointments, Integer> {
}
