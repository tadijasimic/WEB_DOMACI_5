package rs.raf.domaci.repository;


import rs.raf.domaci.model.Comment;
import rs.raf.domaci.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class RuntimeRepository implements BlogRepository {

    private Map<Post, List<Comment>> posts;

    public RuntimeRepository() {
      posts = new ConcurrentHashMap<>();
    }


    @Override
    public Post addPost(Post post) {

        synchronized (this) {
            post.setPost_id(posts.size());
            posts.put(post, new CopyOnWriteArrayList<>());
        }
        return post;
    }

    @Override
    public Comment addComment(int post_id, Comment comment) {
        posts.get(getPostById(post_id)).add(comment);
        return comment;
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(posts.keySet());
    }

    @Override
    public Post getPostById(int post_id) {
        for (Post curr : posts.keySet()) {
            if (post_id == curr.getPost_id())
                return curr;
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsForPost(int post_id) {

        return new ArrayList<>( posts.get(getPostById(post_id)) );
    }

}
