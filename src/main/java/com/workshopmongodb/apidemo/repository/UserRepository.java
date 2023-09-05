package com.workshopmongodb.apidemo.repository;

import com.workshopmongodb.apidemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
