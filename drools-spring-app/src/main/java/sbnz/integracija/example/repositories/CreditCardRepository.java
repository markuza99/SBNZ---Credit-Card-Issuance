package sbnz.integracija.example.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	List<CreditCard> findByIdNot(Long id);
	List<CreditCard> findByUserUsername(String username);
}
