package org.cmad.blog.biz;

import java.util.List;

import org.cmad.blog.api.AppUser;
import org.cmad.blog.api.Blog;
import org.cmad.blog.api.Comment;
import org.cmad.blog.api.PersonalInfo;
import org.cmad.blog.api.Post;
import org.cmad.blog.api.Topic;
import org.cmad.blog.api.exception.BlogException;
import org.cmad.blog.api.exception.InvalidCommentException;
import org.cmad.blog.api.exception.InvalidPostException;
import org.cmad.blog.api.exception.PostNotFoundException;
import org.cmad.blog.api.exception.UserNotFoundException;
import org.cmad.blog.data.BlogDAO;
import org.cmad.blog.data.UserBlogDAO;

public class UserBlog implements Blog {

	private BlogDAO blogDao;
	
	public UserBlog() {
		super();
		this.blogDao = new UserBlogDAO();
	}
	
	public UserBlog(BlogDAO blogDao) {
		super();
		this.blogDao = blogDao;
	}

	
	
	@Override
	public int addAppUser(AppUser appUser) throws BlogException {
		int appUserId = -1;
		// TODO Auto-generated method stub
		System.out.println("UserBlog.addAppUser()appUser: "+appUser);
		System.out.println("UserBlog.addAppUser()blogDao: "+blogDao);
		if(/*!isUserExist(appUser) &&*/ isUserPersonalInfoProper(appUser)){
			appUserId = blogDao.addAppUser(appUser);
		}
		System.out.println("UserBlog.addAppUser()appUserId: "+appUserId);
		return appUserId;
	}


	@Override
	public AppUser updateAppUser(AppUser appUser) throws BlogException {
		AppUser updatedUser = null;
		if(isUserExist(appUser) && isUserPersonalInfoProper(appUser)){
			blogDao.updateAppUser(appUser);
		}
		return updatedUser;
	}

	@Override
	public int authenticatedAppUser(AppUser appUser) throws UserNotFoundException {
		return blogDao.authenticateAppUser(appUser);
	}
	
	private boolean isUserExist(AppUser user) throws UserNotFoundException{
		boolean isUserExist = false;
		if(user==null || user.getPersonalInfo()==null){
			throw new UserNotFoundException(UserNotFoundException.USER_NOT_FOUND);
		}else{
			isUserExist = true;
		}
		System.out.println("UserBlog.isUserExist()isUserExist: "+isUserExist);
		return isUserExist;
	}
	
	private boolean isUserPersonalInfoProper(AppUser user) throws UserNotFoundException{
		boolean isUserPersonalInfoProper = false;
		PersonalInfo personInfo = user.getPersonalInfo();
		if(personInfo.getName()!=null 
				&& personInfo.getName().trim().length()>0  
				&& personInfo.getPhoneNum()!=null 
				&& personInfo.getPhoneNum().trim().length()>0){
			isUserPersonalInfoProper = true;
		}else{
			throw new UserNotFoundException(UserNotFoundException.USER_DETAILS_NOT_PROPER);
		}
		System.out.println("UserBlog.isUserPersonalInfoProper()isUserPersonalInfoProper: "+isUserPersonalInfoProper);
		return isUserPersonalInfoProper;
	}

	/*@Override
	public int addPost(Post post) throws BlogException {
//		boolean isUserPostAdded = false;
		System.out.println("UserBlog.addPost()post: "+post);
		int postId = -1;
		if(isPostValid(post)){
			blogDao.createBlog(post);
			postId = post.getId();
		} else {
			throw new InvalidPostException();
		}
		System.out.println("UserBlog.addPost()postId: "+postId);

		return postId;
	}*/
	@Override
	public boolean addPost(Post post) throws BlogException {
		boolean isUserPostAdded = false;
		if(isPostValid(post)){
			blogDao.createBlog(post);
			isUserPostAdded = true;
		} 
		return isUserPostAdded;
	}

	@Override
	public boolean addComment(Comment comment) throws BlogException {
		boolean isCommentAdded = false;
		if(isCommentValid(comment)){
			blogDao.addComment(comment);
			isCommentAdded = true;
		}
		return isCommentAdded;
	}

	@Override
	public List<Post> getPosts() throws BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> getPosts(Topic topic) throws BlogException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPost(int postId) throws PostNotFoundException, BlogException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean isPostValid(Post post) throws InvalidPostException{
		boolean isPostValid = false;
		if(isPostTitleValid(post) && isPostDescValid(post)){
			isPostValid = true;
		} 
		return isPostValid;
	}

	private boolean isPostTitleValid(Post post) throws InvalidPostException{
		boolean isPostTitleValid = false;
		if(post!=null && post.getTitle()!=null && post.getTitle().trim().length() >0){
			isPostTitleValid = true;
		} else{
			throw new InvalidPostException(InvalidPostException.INVALID_POST_TITLE);
		}
		return isPostTitleValid;
	}
	
	private boolean isPostDescValid(Post post) throws InvalidPostException{
		boolean isPostDescValid = false;
		if(post!=null && post.getDescription()!=null && post.getDescription().trim().length() >0){
			isPostDescValid = true;
		} else{
			throw new InvalidPostException(InvalidPostException.INVALID_POST_DESCRIPTION);
		}
		return isPostDescValid;
	}
	
	private boolean isCommentValid(Comment comment)  throws InvalidCommentException{
		boolean isValidComment = false;
		if(comment!=null && comment.getCommentDesc()!=null && comment.getCommentDesc().trim().length()>0){
			isValidComment = true;
		}else{
			throw new InvalidCommentException(InvalidCommentException.INVALID_COMMENT);
		}
		return isValidComment;
	}

	@Override
	public List<AppUser> getAppUser() throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser getAppUser(int appUserId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
