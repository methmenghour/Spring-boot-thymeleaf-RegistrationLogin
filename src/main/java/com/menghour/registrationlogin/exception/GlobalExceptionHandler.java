package com.menghour.registrationlogin.exception;

import java.util.stream.Collectors;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public String handleApiException(ApiException e,RedirectAttributes redirectAttributes){

		   redirectAttributes.addFlashAttribute("Error",e.getMessage());	   
		   return "redirect:/users";

	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public String notValid(MethodArgumentNotValidException e, RedirectAttributes redirectAttributes) {
	   String Error = e.getBindingResult()
                         .getFieldErrors()
                         .stream()
                         .map(FieldError::getDefaultMessage)
                         .collect(Collectors.toSet())
                         .toString()
                         .replaceAll("\\[*]*", "");
	   
	   redirectAttributes.addFlashAttribute("Error", Error);   
	   return "redirect:/users";

    }
	@ExceptionHandler(HttpMessageNotReadableException.class)
    public String jsonFormatPattern(HttpMessageNotReadableException e,RedirectAttributes redirectAttributes) {

	   String Error = "Error LocalDateTime Pattern";            
       redirectAttributes.addFlashAttribute("Error", Error);	   
	   return "redirect:/users";
    }
}
