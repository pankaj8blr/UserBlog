package org.cmad.blog.data;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.cmad.blog.api.AppUser;
import org.cmad.blog.api.Blog;
import org.cmad.blog.api.Comment;
import org.cmad.blog.api.Post;

public class UserBlogDAO implements BlogDAO {

	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("blog");

	@Override
	public int addAppUser(AppUser appUser) {
		System.out.println("UserBlogDAO.addAppUser()appUser: "+appUser);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(appUser);
		em.getTransaction().commit();
		em.close();
		return appUser.getAppUserId();
		
	}

	@Override
	public AppUser updateAppUser(AppUser appUser) {
		return appUser;
		
	}
	
	@Override
	public int authenticateAppUser(AppUser appUser) {
		int appUserId = -1;
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		String userName = appUser.getEmail();
		String password = appUser.getPassword();
		System.out.println("UserBlogDAO.authenticateAppUser() userName: "+userName+",password: "+password);
		/*Query q = em.createQuery("SELECT u FROM AppUser u WHERE u.email = :email AND u.password = :password");
		q.setParameter("email", userName);
		q.setParameter("password", password);
		AppUser user = (AppUser) q.getSingleResult();*/
		
		AppUser u=null;
	    Iterator<AppUser> it =  em.createQuery("SELECT u FROM AppUser u").getResultList().iterator();
	    if(it.hasNext()){
	           u=it.next();
	           if (u!=null && userName.equalsIgnoreCase(u.getEmail())&&password.equals(u.getPassword())) {
	   			appUserId=u.getAppUserId();
	   			}
	           System.out.println("UserBlogDAO.authenticateAppUser()user: "+u);
	   		System.out.println("UserBlogDAO.authenticateAppUser()user.getEmail(): "+u.getEmail()+",user.getPassword(): "+u.getPassword());
	     }
		
		
		
		em.getTransaction().commit();
	    em.close();
	    
	    System.out.println("UserBlogDAO.authenticateAppUser()appUserId: "+appUserId);
		return appUserId;
	}

	@Override
	public boolean createBlog(Post post) {
		if(isPostValid(post)){
			
		}
		return true;
	}

	@Override
	public Blog readBlog() {
		Blog userBlog = null;
		// TODO Auto-generated method stub
		return userBlog;
	}

	@Override
	public Blog updateBlog(Post post) {
		Blog updatedBlog = null;
		if(isPostValid(post)){
			
		}
		return updatedBlog;
	}

	@Override
	public boolean deleteBlog(Post post) {
		boolean isBlogDeleted = false;
		if(isPostValid(post)){
			//to-do deleteBlog
			isBlogDeleted = true;
		}
		return isBlogDeleted;
	}

	@Override
	public boolean addComment(Comment comment) {
		boolean isCommentAdded = false;
		if(isCommentValid(comment)){
			//to-do Add comment
		}
		return isCommentAdded;
	}

	@Override
	public Comment readComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment updateComment(Comment comment) {
		Comment updatedComment=null;
		if(isCommentValid(comment)){
			
		}
		return updatedComment;
	}

	@Override
	public boolean deleteComment(Comment comment) {
		// TODO Auto-generated method stub
		boolean isCommentDeleted = false;
		if(isCommentValid(comment)){
			//to-do delete comment
		}
		return isCommentDeleted;
		
	}

	
	private boolean isPostValid(Post post) {
		boolean isPostValid = false;
		if(isPostTitleValid(post) && isPostDescValid(post)){
			isPostValid = true;
		} 
		return isPostValid;
	}

	private boolean isPostTitleValid(Post post) {
		boolean isPostTitleValid = false;
		if(post!=null && post.getTitle()!=null && post.getTitle().trim().length() >0){
			isPostTitleValid = true;
		} 
		return isPostTitleValid;
	}
	
	private boolean isPostDescValid(Post post) {
		boolean isPostDescValid = false;
		if(post!=null && post.getDescription()!=null && post.getDescription().trim().length() >0){
			isPostDescValid = true;
		}
		return isPostDescValid;
	}
	
	private boolean isCommentValid(Comment comment){
		boolean isValidComment = false;
		if(comment!=null && comment.getCommentDesc()!=null && comment.getCommentDesc().trim().length()>0){
			isValidComment = true;
		}
		return isValidComment;
	}

	
}
