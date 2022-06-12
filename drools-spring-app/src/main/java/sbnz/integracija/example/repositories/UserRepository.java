package sbnz.integracija.example.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sbnz.integracija.example.data.User;


public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByUsername(String username);
}
