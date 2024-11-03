package com.auca.GarageApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.auca.GarageApplication.Model.Appointments;
import com.auca.GarageApplication.Service.AppointmentsService;

@Controller
public class AppointmentsController {

    @Autowired
    private AppointmentsService customerService;

    @GetMapping("/appointments")
    public String showForm(Model model) {
        model.addAttribute("appointments", new Appointments());
        return "appointments";  // Thymeleaf template name (without .html)
    }

    @PostMapping("/appointmentsDisplay")
    public String submitForm(@ModelAttribute("appointments") Appointments customer) {
        customerService.saveCustomer(customer);
        return "appointmentsDisplay";  // Success page after form submission
    }

    @GetMapping("/appointmentsList")
    public String showAppointmentsList(Model model) {
    List<Appointments> appointments = customerService.getAllCustomers();
    model.addAttribute("appointments", appointments);
    return "appointmentsDisplay";  // This should match the Thymeleaf template name
}
}

