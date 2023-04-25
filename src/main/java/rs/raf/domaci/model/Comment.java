package rs.raf.domaci.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Comment {


    @NotNull(message = "author field is required.")
    @NotEmpty(message = "author field is required.")
    private String comment_author;
    @NotNull(message = "content field is required.")
    @NotEmpty(message = "content field is required.")
    private String comment_content;

    public Comment() {

    }

    public Comment(String author, String content) {
        this.comment_author = author;
        this.comment_content = content;
    }

    public String getComment_author() {
        return comment_author;
    }

    public void setComment_author(String comment_author) {
        this.comment_author = comment_author;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }
}
