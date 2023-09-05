package com.workshopmongodb.apidemo.resources;

import com.workshopmongodb.apidemo.dto.UserDTO;
import com.workshopmongodb.apidemo.entity.Post;
import com.workshopmongodb.apidemo.entity.User;
import com.workshopmongodb.apidemo.services.PostService;
import com.workshopmongodb.apidemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = postService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
