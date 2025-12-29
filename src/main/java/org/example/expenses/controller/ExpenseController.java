
package com.example.expense.controller;

import com.example.expense.model.Expense;
import com.example.expense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin
public class ExpenseController {

    @Autowired
    private ExpenseService service;

    @PostMapping
    public Expense add(@RequestBody Expense e) {
        return service.addExpense(e);
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Expense update(@PathVariable Long id,
                          @RequestBody Expense e) {
        return service.update(id, e);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Deleted";
    }
}
