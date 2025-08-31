/*Author: Bonke Bulana - 220539995*/
package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.co.tt.domain.Payment;
import za.co.tt.service.impl.PaymentServiceImpl;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
//@CrossOrigin(origins = "*")
@RequestMapping("api/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("api/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("api/read/{id}")
    public Payment read(@PathVariable Long id) {
        return paymentService.read(id);
    }

    @PostMapping("api/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @DeleteMapping("api/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        paymentService.delete(id);
        return true;
    }

    @GetMapping("api/getAll")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
}

