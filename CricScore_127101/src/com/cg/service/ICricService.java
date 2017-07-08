package com.cg.service;

import java.util.ArrayList;

import com.cg.beans.PlayerBean;
import com.cg.exception.CricketException;

public interface ICricService {
	
	public ArrayList<PlayerBean> viewPlayerDetails() throws CricketException;
	public boolean insertPlayerDetails(PlayerBean playerobj) throws CricketException;


}
