package com.cg.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.beans.PlayerBean;
import com.cg.exception.CricketException;
import com.cg.service.CricServiceImpl;
import com.cg.service.ICricService;

/**
 * Servlet implementation class CricketController
 */
@WebServlet("/CricketController")
public class CricketScoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ICricService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
       
    /* Below constructor is to call service methods*/   
    public CricketScoreController() 
    {
       service = new CricServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String qStr = request.getParameter("action");
		/*Below if method will be called from html page */
		if("playerList".equals(qStr))
		{
			try
			{
				ArrayList<PlayerBean> playerlist = service.viewPlayerDetails();
				System.out.println(playerlist);
				session.setAttribute("playerrecords",playerlist);
				RequestDispatcher dispatch = request.getRequestDispatcher("ViewPlayers.jsp");
				dispatch.forward(request, response);
			}
			catch(CricketException e)
			{
				System.out.println(e.getMessage());
			}
		}
		if("insertPlayerPage".equals(qStr))
		{
			RequestDispatcher dispatch = request.getRequestDispatcher("NewPlayer.jsp");
			dispatch.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String qStr = request.getParameter("action");
		if("insertPlayer".equals(qStr))
		{
			boolean flag=false;
			try
			{
				String playerName = request.getParameter("player");
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String inputdob = request.getParameter("dateBirth");
				LocalDate dob = LocalDate.parse(inputdob,format);
				String country = request.getParameter("team");
				String battingStyle = request.getParameter("batstyle");
				int century = Integer.parseInt(request.getParameter("centuries"));
				int matches = Integer.parseInt(request.getParameter("matchesplayed"));
				int totalRunScore = Integer.parseInt(request.getParameter("scoreRun"));
				PlayerBean playerBean = new PlayerBean();
				playerBean.setPlayerName(playerName);
				playerBean.setDateOfBirth(dob);
				playerBean.setCountry(country);
				playerBean.setBattingStyle(battingStyle);
				playerBean.setCentury(century);
				playerBean.setMatches(matches);
				playerBean.setTotalRunScore(totalRunScore);
				flag = service.insertPlayerDetails(playerBean);
				System.out.println(playerBean);
				RequestDispatcher dispatch = request.getRequestDispatcher("insertsuccess.jsp");
				dispatch.forward(request, response);
				
			}
			catch(CricketException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}

}
