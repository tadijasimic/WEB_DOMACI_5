package rs.raf.domaci.resource;


import rs.raf.domaci.model.Comment;
import rs.raf.domaci.model.Post;
import rs.raf.domaci.service.CommentsService;
import rs.raf.domaci.service.PostsService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/posts")
public class BlogResource {

    @Inject
    private PostsService postsService;
    @Inject
    private CommentsService commentsService;


    //getovanje svih postova
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPosts() {
        return Response.ok(postsService.getAllPosts()).build();
    }

    //dodavanje novog posta
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Post addPost(Post post) {
        return postsService.addPost(post);
    }

    //getovanje sadrzaja kliknutog posta
    @GET
    @Path("/{post_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPost(@PathParam("post_id") int id) {
        return postsService.getPostById(id);
    }

    //citanje komentara na postu
    @GET
    @Path("/{post_id}/comments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCommentsForPost(@PathParam("post_id") int post_id) {
        return Response.ok(commentsService.getCommentsForPost(post_id)).build();
    }

    @POST
    @Path("/{post_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Comment addComment(@PathParam("post_id") int post_id, Comment comment) {
        return commentsService.addComment(post_id, comment);
    }

}