package com.tgj.eventaid.Repositories;

import com.tgj.eventaid.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{
    Users findById(Long id);
    Users findByEmail(String email);
}
