package ua.lviv.iot.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import ua.lviv.iot.DAO.RequestBlackList;
import ua.lviv.iot.DAO.RequestComment;
import ua.lviv.iot.DAO.RequestFotoAndVideo;
import ua.lviv.iot.DAO.RequestMediaType;
import ua.lviv.iot.DAO.RequestPost;
import ua.lviv.iot.DAO.RequestPreference;
import ua.lviv.iot.DAO.RequestPreferenceComment;
import ua.lviv.iot.DAO.RequestTag;
import ua.lviv.iot.DAO.RequestTypePost;
import ua.lviv.iot.DAO.RequestUser;
import ua.lviv.iot.DAO.RequestUserLog;
import ua.lviv.iot.DAO.RequestUserSecurity;
import ua.lviv.iot.model.BlackList;
import ua.lviv.iot.model.Comment;
import ua.lviv.iot.model.FotoAndVideo;
import ua.lviv.iot.model.MediaType;
import ua.lviv.iot.model.Post;
import ua.lviv.iot.model.Preference;
import ua.lviv.iot.model.PreferenceComment;
import ua.lviv.iot.model.Tag;
import ua.lviv.iot.model.TypePost;
import ua.lviv.iot.model.User;
import ua.lviv.iot.model.UserLog;
import ua.lviv.iot.model.UserSecurity;

public class Controller implements IController {
    
	public Controller() {

	}

	@Override
	public String insertBlackList(BlackList blackList) throws SQLException {
		return RequestBlackList.insert(blackList);
	}
	
	@Override
	public ArrayList<BlackList> findAllBlackList() throws SQLException {
		return RequestBlackList.findAll();	
	}

	@Override
	public String updateBlackList(BlackList blackList, int userId, int lockingUserId) throws SQLException {
		return RequestBlackList.update(blackList, userId, lockingUserId);
		
	}

	@Override
	public String deleteBlackList(int userId, int lockingUserId) throws SQLException {
		return RequestBlackList.delete(userId, lockingUserId);
		
	}

	@Override
	public String insertComment(Comment ñomment) throws SQLException {
		return RequestComment.insert(ñomment);
		
	}

	@Override
	public ArrayList<Comment> findAllComment() throws SQLException {
        return RequestComment.findAll();
	}

	@Override
	public String updateComment(Comment ñomment, int commentId) throws SQLException {
		return RequestComment.update(ñomment, commentId);
		
	}

	@Override
	public String deleteComment(int commentId) throws SQLException {
		return RequestComment.delete(commentId);	
	}

	@Override
	public String insertFotoAndVideo(FotoAndVideo fotoAndVideo) throws SQLException {
		return RequestFotoAndVideo.insert(fotoAndVideo);
	}

	@Override
	public ArrayList<FotoAndVideo> findAllFotoAndVideo() throws SQLException {
		return RequestFotoAndVideo.findAll();
	}

	@Override
	public String updateFotoAndVideo(FotoAndVideo fotoAndVideo, int fotoOrVideoId) throws SQLException {
		return RequestFotoAndVideo.update(fotoAndVideo, fotoOrVideoId);	
	}

	@Override
	public String deleteFotoAndVideo(int fotoOrVideoId) throws SQLException {
		return RequestFotoAndVideo.delete(fotoOrVideoId);
	}

	@Override
	public String insertMediaType(MediaType mediaType) throws SQLException {
	    return RequestMediaType.insert(mediaType);	
	}

	@Override
	public ArrayList<MediaType> findAllMediaType() throws SQLException {
		return RequestMediaType.findAll();
	}

	@Override
	public String updateMediaType(MediaType mediaType, int mediaTypeId) throws SQLException {
		return RequestMediaType.update(mediaType, mediaTypeId);
	}

	@Override
	public String deleteMediaType(int mediaTypeId) throws SQLException {
		return RequestMediaType.delete(mediaTypeId);
	}

	@Override
	public String insertPost(Post post) throws SQLException {
		return RequestPost.insert(post);
	}

	@Override
	public ArrayList<Post> findAllPost() throws SQLException {
		return RequestPost.findAll();	
	}

	@Override
	public String updatePost(Post post, int idPost) throws SQLException {
		return RequestPost.update(post, idPost);		
	}

	@Override
	public String deletePost(int idPost) throws SQLException {
		return RequestPost.delete(idPost);	
	}

	@Override
	public String insertPreference(Preference preference) throws SQLException {
		return RequestPreference.insert(preference);
	}

	@Override
	public ArrayList<Preference> findAllPreference() throws SQLException {
		return RequestPreference.findAll();
	}

	@Override
	public String updatePreference(Preference preference, int userId, int postId) throws SQLException {
		return RequestPreference.update(preference, userId, postId);
	}

	@Override
	public String deletePreference(int userId, int postId) throws SQLException {
		return RequestPreference.delete(userId, postId);	
	}

	@Override
	public String insertPreferenceComment(PreferenceComment preferenceComment) throws SQLException {
	    return RequestPreferenceComment.insert(preferenceComment);
	}

	@Override
	public ArrayList<PreferenceComment> findAllPreferenceComment() throws SQLException {
		return RequestPreferenceComment.findAll();
	}

	@Override
	public String updatePreferenceComment(PreferenceComment preferenceComment, int commentId) throws SQLException {
		return RequestPreferenceComment.update(preferenceComment, commentId);
	}

	@Override
	public String deletePreferenceComment(int commentId) throws SQLException {
		return RequestPreferenceComment.delete(commentId);
	}

	@Override
	public String insertTag(Tag tag) throws SQLException {
	    return RequestTag.insert(tag);
	}

	@Override
	public ArrayList<Tag> findAllTag() throws SQLException {
		return RequestTag.findAll();
	}

	@Override
	public String updateTag(Tag tag, int userId, int postId) throws SQLException {
		return RequestTag.update(tag, userId, postId);
	}

	@Override
	public String deleteTag(int userId, int postId) throws SQLException {
		return RequestTag.delete(userId, postId);
	}

	@Override
	public String insertTypePost(TypePost typePost) throws SQLException {
		return RequestTypePost.insert(typePost);
	}

	@Override
	public ArrayList<TypePost> findAllTypePost() throws SQLException {
		return RequestTypePost.findAll();
	}

	@Override
	public String updateTypePost(TypePost typePost, int typePostId) throws SQLException {
		return RequestTypePost.update(typePost, typePostId);
	}

	@Override
	public String deleteTypePost(int typePostId) throws SQLException {
		return RequestTypePost.delete(typePostId);
	}

	@Override
	public String insertUser(User user) throws SQLException {
		return RequestUser.insert(user);
	}

	@Override
	public ArrayList<User> findAllUser() throws SQLException {
		return RequestUser.findAll();
	}

	@Override
	public String updateUser(User user, int userId) throws SQLException {
		return RequestUser.update(user, userId);
	}

	@Override
	public String deleteUser(int userId) throws SQLException {
		return RequestUser.delete(userId);
	}

	@Override
	public String insertUserLog(UserLog userLog) throws SQLException {
		return RequestUserLog.insert(userLog);
	}

	@Override
	public ArrayList<UserLog> findAllUserLog() throws SQLException {
		return RequestUserLog.findAll();
	}

	@Override
	public String updateUserLog(UserLog userLog, int userId) throws SQLException {
		return RequestUserLog.update(userLog, userId);
	}

	@Override
	public String deleteUserLog(int userId) throws SQLException {
		return RequestUserLog.delete(userId);
	}

	@Override
	public String insertUserSecurity(UserSecurity userSecurity) throws SQLException {
		return RequestUserSecurity.insert(userSecurity);
	}

	@Override
	public ArrayList<UserSecurity> findAllUserSecurity() throws SQLException {
		return RequestUserSecurity.findAll();
	}

	@Override
	public String updateUserSecurity(UserSecurity userSecurity, int userId) throws SQLException {
		return RequestUserSecurity.update(userSecurity, userId);
	}

	@Override
	public String deleteUserSecurity(int userId) throws SQLException {
		return RequestUserSecurity.delete(userId);
	}
}
	