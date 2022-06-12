package sbnz.integracija.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.BankTemplate;

public interface BankTemplateRepository extends JpaRepository<BankTemplate, Long> {

}
