package com.workshopmongodb.apidemo.repository;

import com.workshopmongodb.apidemo.entity.Post;
import com.workshopmongodb.apidemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
