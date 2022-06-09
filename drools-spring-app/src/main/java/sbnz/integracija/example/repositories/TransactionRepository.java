package sbnz.integracija.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
