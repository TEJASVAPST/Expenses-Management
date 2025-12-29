package com.example.expense.service;

import com.example.expense.model.Expense;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ExpenseService {

    private List<Expense> list = new ArrayList<>();
    private Long counter = 1L;

    public Expense addExpense(Expense e) {
        e.setId(counter++);
        list.add(e);
        return e;
    }

    public List<Expense> getAll() {
        return list;
    }

    public Expense update(Long id, Expense e) {
        for (Expense ex : list) {
            if (ex.getId().equals(id)) {
                ex.setAmount(e.getAmount());
                ex.setDescription(e.getDescription());
                return ex;
            }
        }
        return null;
    }

    public void delete(Long id) {
        list.removeIf(e -> e.getId().equals(id));
    }
}
