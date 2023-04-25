package rs.raf.domaci.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Post {

    private int post_id;

    @NotNull(message = "post_title field is required.")
    @NotEmpty(message = "post_title field is required.")
    private String post_title;
    @NotNull(message = "post_text field is required.")
    @NotEmpty(message = "post_text field is required.")
    private String post_content;

    @NotNull(message = "post_author author is required.")
    @NotEmpty(message = "post_author is required.")
    private String post_author;

    public Post(){}
    public Post(int postId, String title, String author, String content) {
        this();
        this.post_id = postId;
        this.post_title = title;
        this.post_author = author;
        this.post_content = content;
    }


    public String getPost_content() {
        return post_content;
    }

    public String getPost_author() {
        return post_author;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public void setPost_author(String post_author) {
        this.post_author = post_author;
    }
}
