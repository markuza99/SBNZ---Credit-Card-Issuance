package sbnz.integracija.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
