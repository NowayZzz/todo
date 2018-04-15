package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

/**
 * 	DAO绫�
 *
 */
public class UserDAO {
/*
 * 涓�鍙name鏌ヨ鐢ㄦ埛锛屽鏋滄壘涓嶅埌锛屽垯杩斿洖null
 * 鍚﹀垯锛岃繑鍥炰竴涓猆esr瀵硅薄锛堥噷闈㈠瓨鏀惧璞＄殑鎵�鏈変俊鎭紝鍖呮嫭瀵嗙爜)
 */
	public User find(String uname) {
		User user = null;
		Connection conn=null;
		try {
			conn =DBUtils.getConn();
			String sql ="SELECT*FROM admin_info "+
			"WHERE admin_code=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user =new User();
				user.setAdmin_id(rs.getInt("admin_id"));
				user.setAdmin_code(uname);
				user.setName("name");
				user.setPassword(rs.getString("password"));
				user.setTelephone(rs.getString("telephone"));
				user.setEmail(rs.getString("email"));
				user.setEnrolldate(rs.getString("enrolldate"));
			}
		} catch (Exception e) {
		}
		return user;
	}
	
	
	/**
	 * 渚濇嵁id浠庢暟鎹簱涓垹闄ゅ搴旂殑鐢ㄦ埛
	 */
	public void delete(int id){
		Connection conn=null;
		try {
			conn=DBUtils.getConn();
			String sql="DELETE FROM admin_info where admin_id=?";
			PreparedStatement ps=
					conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}finally {
			DBUtils.closeConn(conn);
		}
		
	}
	
	/**
	 * 灏嗙敤鎴蜂俊鎭坊鍔犲埌鏁版嵁搴�
	 */
	public void save(User user){
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "INSERT INTO admin_info "
					+ "VALUES(null,?,?,?,?,?,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setLong(1, user.getAdmin_id());
			ps.setString(2, user.getAdmin_code());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getName());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getEmail());
			ps.setString(7, user.getEnrolldate());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
	}
	
	/**
	 * 鏌ヨ鍑烘墍鏈夌敤鎴蜂俊鎭�
	 */
	public List<User> findAll(){
		List<User> users =  
				new ArrayList<User>();
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM admin_info";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("admin_id");
				String uname = rs.getString(
						"admin_code");
				String pwd = rs.getString(
						"password");
				String name=rs.getString("name");
				String phone = rs.getString(
						"telephone");
				String email = rs.getString(
						"email");
				String date =rs.getString("enrolldate");
				User user = new User();
				user.setAdmin_id(id);
				user.setAdmin_code(uname);
				user.setPassword(pwd);
				user.setName(name);
				user.setTelephone(phone);
				user.setEmail(email);
				user.setEnrolldate(date);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
		return users;
	}
	
}









