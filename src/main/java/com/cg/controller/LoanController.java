package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Loan;
import com.cg.service.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {
	
	 @Autowired
	    private LoanService service;

	    @PostMapping
	    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {

	        Loan saved = service.createLoan(loan);

	        return new ResponseEntity<>(saved, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Loan>> getAllLoans() {

	        return new ResponseEntity<>(service.getAllLoans(), HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Loan> getLoanById(@PathVariable Long id) {

	        return new ResponseEntity<>(service.getLoanById(id), HttpStatus.OK);
	    }

	    @PutMapping("/{id}/status")
	    public ResponseEntity<Loan> updateStatus(@PathVariable Long id,
	                                             @RequestBody String status) {

	        return new ResponseEntity<>(service.updateStatus(id, status), HttpStatus.OK);
	    }

}
