package rs.raf.domaci.service;



import rs.raf.domaci.model.Post;
import rs.raf.domaci.repository.BlogRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class PostsService {

    @Inject
    BlogRepository blogRepository;
    public List<Post> getAllPosts() {
        return blogRepository.getAllPosts();
    }

    public Post getPostById(int id) {
        return blogRepository.getPostById(id);
    }

    public Post addPost(Post newPost) {
        return blogRepository.addPost(newPost);
    };
}
