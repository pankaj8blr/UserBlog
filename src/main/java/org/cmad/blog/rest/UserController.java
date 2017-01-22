package org.cmad.blog.rest;

import javax.transaction.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cmad.blog.api.AppUser;
import org.cmad.blog.api.Blog;
import org.cmad.blog.biz.UserBlog;


@Path("/account")
public class UserController {
	public UserController() {
		System.out.println("UserController.UserController()");
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/adduser")
	public Response addUser(AppUser user) {
		System.out.println("UserController.addUser() user: "+user);
		Blog blog = new UserBlog();
		System.out.println("UserController.addUser()blog: "+blog);
		int appUserId = blog.addAppUser(user);
		System.out.println("appUserId: "+appUserId);;
		return Response.ok().entity(appUserId + "").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/authenticateuser")
	public Response authenticateUser(AppUser user) {
		System.out.println("UserController.authenticateUser() user: "+user);
		Blog blog = new UserBlog();
		System.out.println("UserController.authenticateUser()blog: "+blog);
		int appUserId = blog.authenticatedAppUser(user);
		System.out.println("appUserId: "+appUserId);
		return Response.ok().entity(appUserId + "").build();
////		return new ResponseEntity(HttpStatus.BAD_REQUEST);
//		return Response.status(Status.NOT_FOUND);
		
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateuser")
	public Response updateUser(AppUser user) {
		return Response.ok().entity(user).build();
	}
	
}
