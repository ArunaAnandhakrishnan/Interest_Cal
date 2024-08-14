package com.vernite.cal.service;

import com.vernite.cal.dto.CardDetailsResponse;

import java.text.ParseException;
import java.util.Date;

public interface InterestCalculateService {

   Double getInterest(String cardNo, Date cycleDate, String cardType);
   CardDetailsResponse getCardDeatils(String numberx) throws ParseException;
}
