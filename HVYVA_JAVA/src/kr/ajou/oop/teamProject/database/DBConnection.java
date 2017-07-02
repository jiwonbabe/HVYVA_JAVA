
package kr.ajou.oop.teamProject.database;

import java.sql.Statement;

import javax.swing.JOptionPane;

import kr.ajou.ajou.teamProject.oop.gui.LogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private String result;
	
	public DBConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop_tutorial?useSSL=false", "root","dbpassword");
			st = con.createStatement();
			createTables();
		}catch(Exception e)
		{
			System.out.println("Database connection error:"+e.getMessage());
		}
	}
	
	public void createTables(){
		PreparedStatement create;
		try {
			//create progress table in database
			create = con.prepareStatement("CREATE TABLE IF NOT EXISTS progress(id varchar(20) not null, "
					+ "num int not null, "
					+ "year int not null, "
					+ "month int not null, "
					+ "date int not null, "
					+ "lecture_name varchar(50) not null, "
					+ "PRIMARY KEY(id, date, lecture_name)) "
					+ "engine = innoDB");
			
			create.executeUpdate();
			
			//create user_data table in database
			create = con.prepareStatement("CREATE TABLE IF NOT EXISTS progress(id varchar(20) not null PRIMARY KEY, "
					+ "password varchar(20) not null) "
					+ "engine = innoDB");
			create.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public boolean insertUserDataToDB(String id, String pwd) {

		String SQL = "INSERT INTO user_data(id, password) VALUES('"+id+"', '"+pwd+"')";
		try{
			st.executeUpdate(SQL);
			System.out.println("true");
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println("Database insert error:" + e.getMessage());
			System.out.println("false");
		}
		return false;
		
	}
	
	
	public boolean checkUserDataInDB(String id, String password){
				
		try{
			//System.out.println(id+" "+ password);
			PreparedStatement cus = con.prepareStatement("select * from user_data where id = '"+id+"'");
			ResultSet result = cus.executeQuery();
		
			if(result.next()){
				cus = con.prepareStatement("select * from user_data where password = '"+password+"'");
				result = cus.executeQuery();
				if(result.next()){
					return true;
				}
				return false;
			}
			return false;

		}catch(Exception e)
		{
			System.out.println("Database select error:" + e.getMessage());
		}
		return false;

	}
	
	public boolean checkIDDuplication(String id){
		String check = "SELECT * FROM user_data WHERE id='"+id+"'";
		try {
		ResultSet result = st.executeQuery(check);
		
			if(result.next())
			return true;
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
		
		
	}
	public boolean saveUserProgressInDB(String y, String m, String d, String n , String l){
		System.out.println(y+m+d+n+l);
		FinishTimeData f = new FinishTimeData();
		f.num = n;
		f.year = y;
		f.month = m;
		f.date = d;
		f.lecture_name = l;
		String SQL = "INSERT INTO progress (id,num,year,month,date,lecture_name)VALUES ("+LogIn.getlogInID()+","+f.num+","
													+f.year+","
													+ f.month+","
													+ f.date+",'"
													+ f.lecture_name+"')";
		try{
			st.executeUpdate(SQL);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println("Database insert error:" + e.getMessage());
		}
		return false;
	}
	public String saveUserProgressInCal(int year, int month, int date){
//		FinishTimeData f = new FinishTimeData();

		String SQL = "SELECT year, month, date,lecture_name FROM progress WHERE id = '"+LogIn.getlogInID() + "' and year = '"+year+"' and month = '"+month+"' and date = '"+date+"'" ;
		String outputLectureName = "";
		try{
			rs=st.executeQuery(SQL);
			while(rs.next()){
				outputLectureName+=", " +rs.getString("lecture_name");
			}
	
		}catch(Exception e)
		{
			System.out.println("Database select error:" + e.getMessage());
		}
		return outputLectureName;
	}
	
}
