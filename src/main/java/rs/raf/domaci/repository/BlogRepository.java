package rs.raf.domaci.repository;



import rs.raf.domaci.model.Comment;
import rs.raf.domaci.model.Post;

import java.util.List;

public interface BlogRepository {


    public Post addPost(Post post);
    public Comment addComment(int post_id, Comment comment);

    public List<Post> getAllPosts();

    public Post getPostById(int post_id);

    public List<Comment> getCommentsForPost(int post_id);

}
