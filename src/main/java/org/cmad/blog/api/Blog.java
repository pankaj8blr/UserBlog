package org.cmad.blog.api;


import java.util.List;

import org.cmad.blog.api.exception.BlogException;
import org.cmad.blog.api.exception.PostNotFoundException;
import org.cmad.blog.api.exception.UserNotFoundException;

public interface Blog {
	
	public int addAppUser(AppUser user) throws BlogException;

	public AppUser updateAppUser(AppUser user) throws BlogException;
	
	public int authenticatedAppUser(AppUser user) throws UserNotFoundException;

//	public int addPost(Post post) throws BlogException;
	
	public boolean addPost(Post post) throws BlogException;

	public boolean addComment(Comment comment) throws BlogException;

	public List<Post> getPosts() throws PostNotFoundException,BlogException;

	public List<Post> getPosts(Topic topic) throws PostNotFoundException,BlogException;

	public Post getPost(int postId) throws PostNotFoundException, BlogException;
	
	public List<AppUser> getAppUser() throws UserNotFoundException;
	
	public AppUser getAppUser(int appUserId) throws UserNotFoundException;
}
