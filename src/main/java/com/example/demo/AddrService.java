package com.example.demo;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AddrService
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView addr(HttpServletRequest req)
	{
		ModelAndView modelAndView = null;

		try
		{
			// 1. 서버 IP 구하기
			InetAddress inet = InetAddress.getLocalHost();

			String srv = inet.getHostAddress();

			// 2. 클라이언트 IP 구하기
			String cli = req.getHeader("X-Forwarded-For");

		    if (null == null)
		    	cli = req.getRemoteAddr();
	     
		    modelAndView = new ModelAndView();

	        modelAndView.setViewName("index");
	        modelAndView.addObject("srv", srv);
	        modelAndView.addObject("cli", cli);
		}
		catch (Exception e)
		{
			System.out.println("exception : [" + e.getMessage() + "]");

			e.printStackTrace();
		}

		return modelAndView;		
	}
}
