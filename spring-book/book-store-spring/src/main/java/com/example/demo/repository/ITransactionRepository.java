package com.example.demo.repository;

import com.example.demo.model.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransactionRepository extends JpaRepository<Transaction,Integer> {
}
