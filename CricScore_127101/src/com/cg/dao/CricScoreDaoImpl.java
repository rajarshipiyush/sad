package com.cg.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import com.cg.beans.PlayerBean;
import com.cg.dbutil.DBUtil;
import com.cg.exception.CricketException;

public class CricScoreDaoImpl implements ICricScoreDao {
	
	Connection con;
	
	public CricScoreDaoImpl()
	{
		con = DBUtil.getConnection(); 
	}

	@Override
	public ArrayList<PlayerBean> viewPlayerDetails() throws CricketException {
		// TODO Auto-generated method stub
		ArrayList<PlayerBean> playerlist = new ArrayList<PlayerBean>();
		try
		{
			String sql = "SELECT * FROM CRICKET_SCORE";
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
				PlayerBean playerobj = new PlayerBean();
				playerobj.setPlayerId(result.getInt(1));
				playerobj.setPlayerName(result.getString(2)); //1
				
				LocalDate playerdob=(result.getDate(3).toLocalDate());//2
				Period diff = playerdob.until(LocalDate.now());
				int age = diff.getYears();
				playerobj.setAge(age);
				playerobj.setCountry(result.getString(4));//3
				playerobj.setBattingStyle(result.getString(5));//4
				playerobj.setCentury(result.getInt(6));//5
				playerobj.setMatches(result.getInt(7));//6
				playerobj.setTotalRunScore(result.getInt(8));//7
				playerlist.add(playerobj);
			}
			if(playerlist.size()==0)
			{
				throw new CricketException("No Player Details to Display");
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return playerlist;
	}

	@Override
	public boolean insertPlayerDetails(PlayerBean playerobj) throws CricketException {
		// TODO Auto-generated method stub
		boolean flag = false;
		try
		{
			System.out.println("dao class"+playerobj);
			String sql = "INSERT INTO CRICKET_SCORE VALUES(player_seq.NEXTVAL,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,playerobj.getPlayerName());
			pstmt.setDate(2,Date.valueOf(playerobj.getDateOfBirth()));
			pstmt.setString(3,playerobj.getCountry());
			pstmt.setString(4,playerobj.getBattingStyle());
			pstmt.setInt(5,playerobj.getCentury());
			pstmt.setInt(6,playerobj.getMatches());
			pstmt.setInt(7,playerobj.getTotalRunScore());
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
