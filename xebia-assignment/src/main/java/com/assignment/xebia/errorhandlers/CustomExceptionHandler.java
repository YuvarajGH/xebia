package com.assignment.xebia.errorhandlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javassist.NotFoundException;

/**
 * @author YU296490
 * Handles exceptions globally
 */

@ControllerAdvice
public class CustomExceptionHandler {
	
	/**
	 * @param request
	 * @param e
	 * @return
	 * Page/resource not found 
	 */
    @ExceptionHandler({NotFoundException.class, NoHandlerFoundException.class})
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
    	ModelAndView mv = new ModelAndView("error");
    	mv.addObject("status", "404");
        return mv;
    }
}
