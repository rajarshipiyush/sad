package com.cg.service;

import java.util.ArrayList;

import com.cg.beans.PlayerBean;
import com.cg.dao.CricScoreDaoImpl;
import com.cg.dao.ICricScoreDao;
import com.cg.exception.CricketException;

public class CricServiceImpl implements ICricService {
	
	ICricScoreDao dao;
	public void setdao(ICricScoreDao dao)
	{
		this.dao = dao;
	}
	public CricServiceImpl()
	{
		dao = new CricScoreDaoImpl();
	}

	@Override
	public ArrayList<PlayerBean> viewPlayerDetails() throws CricketException {
		// TODO Auto-generated method stub
		return dao.viewPlayerDetails();
	}

	@Override
	public boolean insertPlayerDetails(PlayerBean playerobj) throws CricketException {
		// TODO Auto-generated method stub
		return dao.insertPlayerDetails(playerobj);
	}

}
