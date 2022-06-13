package sbnz.integracija.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByRecipientUserUsernameOrPayerUserUsernameOrderByDateDesc(String user, String user1);
	List<Transaction> findByRecipientIdOrPayerIdOrderByDateDesc(Long id, Long id2);

}
