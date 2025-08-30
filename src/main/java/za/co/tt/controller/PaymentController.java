/*Author: Bonke Bulana - 220539995*/
package za.co.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.tt.domain.Payment;
import za.co.tt.service.impl.PaymentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping("/create")
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    @GetMapping("/read/{id}")
    public Payment read(@PathVariable Long id) {
        return paymentService.read(id);
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment) {
        return paymentService.update(payment);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        paymentService.delete(id);
        return true;
    }

    @GetMapping("/getAll")
    public List<Payment> getAll() {
        return paymentService.getAll();
    }
}

