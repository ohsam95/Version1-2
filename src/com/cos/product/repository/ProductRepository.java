package com.cos.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.product.db.DBConn;
import com.cos.product.model.Product;
import com.cos.product.model.Type;

public class ProductRepository {

	private static final String TAG = "ProductReapsitory : ";
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	public static ProductRepository getinstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public List<Product> home() {
		final String SQL = "select id,name,type,price,count from product order by id";
				List<Product> products = new ArrayList<Product>();
				try {
					conn=DBConn.getConnection();
					pstmt = conn.prepareStatement(SQL);
					
					rs=pstmt.executeQuery();
					while (rs.next()) {
						Product product = Product.builder()
								.id(rs.getInt(1))
								.name(rs.getString(2))
								.type(rs.getString(3))
								.price(rs.getInt(4))
								.count(rs.getInt(5))
								.build();
						products.add(product);
					}
					return products;
				} catch (Exception e) {
					System.out.println(TAG+"home : "+e.getMessage());
				}finally {
					DBConn.close(conn, pstmt);
				}
				return null;
	}
	
	public List<Product> first() {
		final String SQL = "select id,name,type,price,count from product";
				List<Product> products = new ArrayList<Product>();
				try {
					conn=DBConn.getConnection();
					pstmt = conn.prepareStatement(SQL);
					
					rs=pstmt.executeQuery();
					while (rs.next()) {
						Product product = Product.builder()
								.id(rs.getInt(1))
								.name(rs.getString(2))
								.type(rs.getString(3))
								.price(rs.getInt(4))
								.count(rs.getInt(5))
								.build();
						products.add(product);
					}
					return products;
				} catch (Exception e) {
					System.out.println(TAG+"home : "+e.getMessage());
				}finally {
					DBConn.close(conn, pstmt);
				}
				return null;
	}
	
	public List<Product> PriceDESC() {
		final String SQL = "select id,name,type,price,count from product order by price desc";
		List<Product> products = new ArrayList<Product>();
		try {
			conn=DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			System.out.println(TAG+"home : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return null;
}

	
	public List<Product> countDESC() {
		final String SQL = "select id,name,type,price,count from product order by count desc";
		List<Product> products = new ArrayList<Product>();
		try {
			conn=DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			rs=pstmt.executeQuery();
			while (rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt(1))
						.name(rs.getString(2))
						.type(rs.getString(3))
						.price(rs.getInt(4))
						.count(rs.getInt(5))
						.build();
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			System.out.println(TAG+"home : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
	
	public int deleteById(int id) {
		final String SQL = "delete from product where id = ?";
		try {
			conn=DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
	
			
		} catch (Exception e) {
			System.out.println(TAG+"home : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	}

	
