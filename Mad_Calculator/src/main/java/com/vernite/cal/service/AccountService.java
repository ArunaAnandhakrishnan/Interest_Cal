package com.vernite.cal.service;

import java.text.ParseException;
import java.util.List;

import com.vernite.cal.model.Cstatements;

public interface AccountService {
	

	public List<Cstatements> getStatement(String date) throws ParseException;

}
