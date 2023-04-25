package rs.raf.domaci.service;



import rs.raf.domaci.model.Comment;
import rs.raf.domaci.repository.BlogRepository;

import javax.inject.Inject;
import java.util.List;

public class CommentsService {
    @Inject
    BlogRepository blogRepository;
    public List<Comment> getCommentsForPost(int post_id){
        return blogRepository.getCommentsForPost(post_id);
    }
    public Comment addComment(int post_id, Comment newComment){
        return blogRepository.addComment(post_id, newComment);
    }

}
