package com.tgj.eventaid.Repositories;

import com.tgj.eventaid.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    User findById(Long id);
    User findByEmail(String email);
}
