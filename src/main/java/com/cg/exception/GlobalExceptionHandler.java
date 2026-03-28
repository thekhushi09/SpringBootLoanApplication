package com.cg.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(InvalidLoanAmountException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ErrorResponse handleAmount(InvalidLoanAmountException ex){

	        return new ErrorResponse("InvalidLoanAmountException", ex.getMessage());
	    }

	    @ExceptionHandler(DuplicateLoanApplicationException.class)
	    @ResponseStatus(HttpStatus.CONFLICT)
	    public ErrorResponse handleDuplicate(DuplicateLoanApplicationException ex){

	        return new ErrorResponse("DuplicateLoanApplicationException", ex.getMessage());
	    }

	    @ExceptionHandler(LoanNotFoundException.class)
	    @ResponseStatus(HttpStatus.NOT_FOUND)
	    public ErrorResponse handleNotFound(LoanNotFoundException ex){

	        return new ErrorResponse("LoanNotFoundException", ex.getMessage());
	    }

}
