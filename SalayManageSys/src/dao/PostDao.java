package dao;

import entity.Post;

public interface PostDao {
	public Post findById(String id)throws Exception;
}
