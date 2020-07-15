package com.mylibrary.book.admin.controller;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mylibrary.book.admin.service.bookhope.BookhopeService;

@Controller
@RequestMapping("/admin")
public class BookhopeController {

	@Autowired
	BookhopeService bookhopeService;

	@RequestMapping("/bhMain")
	public ModelAndView showMain() {
		ModelAndView mav = new ModelAndView();
		System.out.println("북호프 컨트롤러 왔음");
		mav.addObject("bookhopelist", bookhopeService.showAll());
		mav.setViewName("admin/bookhope");
		return mav;
	}

	
	 @RequestMapping("/bhDel")
	 public String bhDelete(@RequestParam String bhid) {
		 System.out.println("Del 컨트롤러 왔음");
		 bookhopeService.deletebh(bhid);
		 System.out.println("DEL succ");
		 return "redirect:bhMain";
		 }
			/*
			 * @RequestMapping("/bhInsert") public String bhInsert(@RequestParam String
			 * bhid) { bookhopeService.bhinsert(bhid); return "redirect:bhMain"; }
			 */
}