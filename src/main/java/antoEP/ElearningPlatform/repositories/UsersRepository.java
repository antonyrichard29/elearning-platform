package antoEP.ElearningPlatform.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import antoEP.ElearningPlatform.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByEmail(String email);
	boolean existsByEmail(String email);

}

