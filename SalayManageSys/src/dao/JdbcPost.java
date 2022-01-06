package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.DbUtil;
import entity.Post;


public class JdbcPost {
	
	public Post findById(String id) throws Exception {
		String sql = "select * from post where pid=?";
		Connection conn = DbUtil.getConnection();
		PreparedStatement pst = 
					conn.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		Post post = null;
		if(rs.next()){
			post=new Post();
			post.setPay(rs.getString("pay"));
			post.setPid(id);
			post.setPname(rs.getString("pname"));
		}
		DbUtil.closeConnection();
		return post;
	}
}
