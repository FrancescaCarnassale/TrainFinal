package com.manager;

import com.beans.Alias;
import com.dao.AliasDao;
import com.dao.impl.AliasDaoImpl;

//Class used to create an alias manager to manage comunication with dao
public class AliasManager {
	private AliasDao aliasDao= new AliasDaoImpl();
	
	public void setAlias(Alias alias) {
		// TODO Auto-generated method stub

		aliasDao.create(alias);
	}
}
