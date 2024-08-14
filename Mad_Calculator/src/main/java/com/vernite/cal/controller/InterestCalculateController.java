package com.vernite.cal.controller;

import com.vernite.cal.dto.CardDetailsResponse;
import com.vernite.cal.model.CAddresses;
import com.vernite.cal.model.Cardx;
import com.vernite.cal.model.People;
import com.vernite.cal.repository.CardxRepository;
import com.vernite.cal.service.InterestCalculateService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class InterestCalculateController {

    @Autowired
    InterestCalculateService interestCalculateService;
    @Autowired
    CardxRepository cardxRepository;

    @GetMapping("/get_interest")
    public ResponseEntity<Map<String, Double>> getInterest(@RequestParam(name = "creditCardType", required = false) String creditCardType,
                                         @RequestParam("cycleDate") @DateTimeFormat(pattern = "dd-MM-yyyy") Date cycleDate,
                                         @RequestParam(name = "cardNo", required = false) String cardNo){

       Double interest = interestCalculateService.getInterest(cardNo, cycleDate,creditCardType);
         Map<String,Double> interestAmount = new HashMap<>();
         interestAmount.put("Interst Amount", interest);

        return new ResponseEntity<>(interestAmount, HttpStatus.OK);
    }
    @GetMapping("/card")
    public ResponseEntity<?> fetchCardDetails(@RequestParam(name = "cardNumber", required = false) String cardNumber)
//                                              @RequestParam(name = "cardSerno", required = false) Long cardSerno,
//                                              @RequestParam(name = "custIdNumber", required = false) String cusIdNumber,
//                                              @RequestParam(name = "mobileNo", required = false) String mobileNo)
            throws ValidationException, ParseException {

        String data = null;
        try {
            CardDetailsResponse response = null;

            if (cardNumber != null) {
                if (cardNumber.length() != 15 && cardNumber.length() != 16) {
                    throw new ValidationException("Please enter a valid card number.");
                }

                Cardx cardDetail = cardxRepository.findByNumberx(cardNumber);
                response = new CardDetailsResponse();
                if (cardDetail == null) {
                    data = "Card Number: " + cardNumber;
                    throw new ValidationException("Card number is not present.");
                } else {
                    response = interestCalculateService.getCardDeatils(cardNumber);
                }
            }

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception ex) {
            if (ex.getMessage() != null) {
                throw new ValidationException(ex.getMessage());
            }
            throw new ValidationException("Card details not found for this" + data);
        }
    }
}
