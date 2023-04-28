package org.example.UserRepository;

import org.springframework.stereotype.Repository;
import org.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface Input extends JpaRepository<User, Long>{
        User findByEmail(String email);
}
