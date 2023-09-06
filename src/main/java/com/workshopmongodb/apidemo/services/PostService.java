package com.workshopmongodb.apidemo.services;


import com.workshopmongodb.apidemo.dto.UserDTO;
import com.workshopmongodb.apidemo.entity.Post;
import com.workshopmongodb.apidemo.entity.User;
import com.workshopmongodb.apidemo.repository.PostRepository;
import com.workshopmongodb.apidemo.repository.UserRepository;
import com.workshopmongodb.apidemo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        // return postRepository.findByTitleContainingIgnoreCase(text);
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }

    public static Date convertDate(String textDate, Date defaultValue) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return sdf.parse(textDate);
        } catch (ParseException e) {
            return defaultValue;
        }
    }
}
