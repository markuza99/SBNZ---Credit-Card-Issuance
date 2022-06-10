package sbnz.integracija.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
