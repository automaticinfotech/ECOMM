package com.aits.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.aits.dto.EndUserDetailsDto;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
 /*@Override
 public boolean preHandle(HttpServletRequest request,
   HttpServletResponse response, Object handler) throws Exception
 {
  String uri = request.getRequestURI();
  if(!uri.endsWith("based on required method set it method name"))
  {
   EndUserDetailsDto userData = (EndUserDetailsDto) request.getSession().getAttribute("LOGGEDIN_USER");
   if(userData == null)
   {
    response.sendRedirect("adminLogin");
    return false;
   }   
  }
  return true;
 }*/
}