package com.example.demo;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddrService
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String addr(HttpServletRequest req, Model model)
	{
		try
		{
			// 1. 서버 IP 구하기
			InetAddress inet = InetAddress.getLocalHost();

			String srv = inet.getHostAddress();

			// 2. 클라이언트 IP 구하기
			String cli = req.getHeader("X-Forwarded-For");

		    if (null == null)
		    	cli = req.getRemoteAddr();

		    model.addAttribute("srv", srv);
		    model.addAttribute("cli", cli);

		    System.out.println("src : [" + srv + "]");
		    System.out.println("src : [" + cli + "]");
		}
		catch (Exception e)
		{
			System.out.println("exception : [" + e.getMessage() + "]");

			e.printStackTrace();
		}

		return "index";
	}
}
