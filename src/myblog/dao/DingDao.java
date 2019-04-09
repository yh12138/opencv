package myblog.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import myblog.bean.Comment;
import myblog.bean.Order;
import myblog.util.DBUtil;



public class DingDao {
	public boolean create(Order order) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ding(supplier, buyer, vending,goods,num,price,time) VALUES(?,?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getSupplier());
			pstmt.setString(2, order.getBuyer());
			pstmt.setString(3, order.getVending());
			pstmt.setString(4, order.getGoods());
			pstmt.setInt(5, order.getNum());
			pstmt.setFloat(6, order.getPrice());
			pstmt.setTimestamp(7, (Timestamp) order.getTime());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return result==1;
	}
	public boolean create1(Order order) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO ding(supplier, buyer, vending,goods,num,price) VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, order.getSupplier());
			pstmt.setString(2, order.getBuyer());
			pstmt.setString(3, order.getVending());
			pstmt.setString(4, order.getGoods());
			pstmt.setInt(5, order.getNum());
			pstmt.setFloat(6, order.getPrice());
			pstmt.setTimestamp(7, (Timestamp) order.getTime());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return result==1;
	}
	public List<Order> queryOrders() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM ding ORDER BY Id ASC";
		ResultSet rs = null;
		List<Order> temps = new ArrayList<Order>();		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Order temp = new Order();
				temp.setSupplier(rs.getString(2));
				temp.setBuyer(rs.getString(3));
				temp.setVending(rs.getString(4));
				temp.setGoods(rs.getString(5));
				temp.setNum(rs.getInt(6));
				temp.setPrice(rs.getFloat(7));
				temp.setTime(rs.getTimestamp(8));
				temps.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeJDBC(null, pstmt, conn);
		}
		
		return temps;
	}
}
