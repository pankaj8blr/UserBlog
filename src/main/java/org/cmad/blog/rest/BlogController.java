package org.cmad.blog.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cmad.blog.api.Blog;
import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;
import org.cmad.blog.biz.UserBlog;

@Path("/blog")
public class BlogController {
	public BlogController() {
		System.out.println("BlogController.BlogController()");
	}
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addblog")
	public Response addBlog(Post post) {
		System.out.println("BlogController.addBlog() post: "+post);
		Blog blog = new UserBlog();
		System.out.println("BlogController.addBlog()blog: "+blog);
		int postId = blog.addPost(post);
		System.out.println("postId: "+postId);;
		return Response.ok().entity(postId + "").build();
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addblog")
	public Response addBlog(Blog blog) {
		return Response.ok().entity(blog).build();
	}



	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateblog")
	public Response updateBlog(Blog blog) {
		return Response.ok().entity(blog).build();
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blog/{no}")
	public Response read(@PathParam("no") int number) {
		
		Blog blog = new UserBlog();
		Post post = new Post();
		
		post = blog.getPost(number);
		return Response.ok().entity(post).build();
	}*/
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/comment")
	public Response addComment(Comment comment) {
		return Response.ok().entity(comment).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/user")
	public Response updateComment(Comment comment) {
		return Response.ok().entity(comment).build();
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/blog/{no}")
	public Response read(@PathParam("no") int number) {
		
	}*/

	
}
