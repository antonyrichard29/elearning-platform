package antoEP.ElearningPlatform.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import antoEP.ElearningPlatform.entities.Users;
import antoEP.ElearningPlatform.repositories.UsersRepository;

@Service
public class UsersServiceImplementation implements UsersService {

    @Autowired
    UsersRepository repo;

    @Override
    public String addUser(Users user) {
        repo.save(user);
        return "User added successfully!";
    }

    @Override
    public Users findUserByEmail(String email) {
        return repo.findByEmail(email);  // Find user by email
    }

    @Override
    public boolean checkEmail(String email) {
        return repo.existsByEmail(email);  // Check if the email exists in the database
    }

    @Override
    public String saveUsers(Users user) {
        repo.save(user);
        return "User updated successfully!";
    }
}
