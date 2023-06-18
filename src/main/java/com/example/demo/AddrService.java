package com.example.demo;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class AddrService
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView addr(HttpServletRequest req, Model model)
	{
		ModelAndView modelAndView = new ModelAndView();

		try
		{
			// 1. ���� IP ���ϱ�
			InetAddress inet = InetAddress.getLocalHost();

			String srv = inet.getHostAddress();

			// 2. Ŭ���̾�Ʈ IP ���ϱ�
			String cli = req.getHeader("X-Forwarded-For");

		    if (null == null)
		    	cli = req.getRemoteAddr();

		    model.addAttribute("srv", srv);
		    model.addAttribute("cli", cli);

		    System.out.println("src : [" + srv + "]");
		    System.out.println("src : [" + cli + "]");
		    
	        
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
