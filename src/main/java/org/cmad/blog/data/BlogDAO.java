package org.cmad.blog.data;

import org.cmad.blog.api.AppUser;
import org.cmad.blog.api.Blog;
import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;

public interface BlogDAO {
	
	public int addAppUser(AppUser appUser);
	public AppUser updateAppUser(AppUser appUser);
	public int authenticateAppUser(AppUser appUser);
	
	public boolean createBlog(Post post);
	public Blog readBlog();
	public Blog updateBlog(Post post) ;
	public boolean deleteBlog(Post post);
	
	public boolean addComment(Comment comment);
	public Comment readComment();
	public Comment updateComment(Comment comment) ;
	public boolean deleteComment(Comment comment); 

}
