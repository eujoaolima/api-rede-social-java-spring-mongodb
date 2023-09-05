package com.workshopmongodb.apidemo.config;

import com.workshopmongodb.apidemo.dto.AuthorDTO;
import com.workshopmongodb.apidemo.dto.CommentDTO;
import com.workshopmongodb.apidemo.entity.Post;
import com.workshopmongodb.apidemo.entity.User;
import com.workshopmongodb.apidemo.repository.PostRepository;
import com.workshopmongodb.apidemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob, o Bobo", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Partiu copa do mundo 2026", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/06/2019"), "Batata", "Batata++", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Potato", sdf.parse("24/06/2019"), new AuthorDTO(bob));
        CommentDTO c2 = new CommentDTO("Potato++", sdf.parse("24/06/2019"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Potatoes", sdf.parse("25/06/2019"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);


    }
}
