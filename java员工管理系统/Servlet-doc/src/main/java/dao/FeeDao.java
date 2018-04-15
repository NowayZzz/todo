package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Fee;
import util.DBUtils;

public class FeeDao {

	public List<Fee> findAllS(){
		List<Fee> users =  
				new ArrayList<Fee>();
		Connection conn = null;
		try {
			conn = DBUtils.getConn();
			String sql = "SELECT * FROM cost";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("cost_id");
				String name = rs.getString(
						"name");
				int base_duration = rs.getInt(
						"base_duration");
				double base_cost=rs.getDouble("base_cost");
				double unit_cost=rs.getDouble("unit_cost");
				String status  = rs.getString(
						"status");
				String descr =rs.getString("descr");
				String creatime  =rs.getString("creatime");
				String startime   =rs.getString("startime");
				String cost_type   =rs.getString("cost_type");
				Fee fee = new Fee();
				fee.setId(id);
				fee.setName(name);
				fee.setBase_duration(base_duration);
				fee.setBase_cost(base_cost);
				fee.setUnit_cost(unit_cost);
				fee.setStatus(status);
				fee.setDescr(descr);
				fee.setCreatime(creatime);
				fee.setStartime(startime);
				fee.setCost_type(cost_type);
				users.add(fee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
		return users;


	}
	public void save(Fee fee){
		Connection conn=null;
		try {
			conn = DBUtils.getConn();
			String  sql="INSERT INTO cost "
					+ "VALUES(null,?,?,?,?,0,?,DEFAULT,DEFAULT,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, fee.getName());
			ps.setInt(2, fee.getBase_duration());
			ps.setDouble(3, fee.getBase_cost());
			ps.setDouble(4, fee.getUnit_cost());
			ps.setString(5, fee.getDescr());
			ps.setString(6, fee.getCost_type());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}
	}


	public void delete(int id){
		Connection conn=null;

		try {
			conn =DBUtils.getConn();
			String sql="DELETE FROM cost WHERE cost_id=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			DBUtils.closeConn(conn);
		}

	}
	public void update(Fee fee){
			Connection conn=null;
			try {
			conn=DBUtils.getConn();
			String sql="UPDATE cost set name=?,base_duration=?,base_cost=?,unit_cost=?,descr=? WHERE cost_id=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, fee.getName());
				ps.setInt(2, fee.getBase_duration());
				ps.setDouble(3, fee.getBase_cost());
				ps.setDouble(4, fee.getUnit_cost());
				ps.setString(5, fee.getDescr());
				ps.setInt(6, fee.getId());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				DBUtils.closeConn(conn);
			}
	}
}
