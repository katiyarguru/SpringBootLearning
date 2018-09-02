package com.pagination.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.pagination.model.PagerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.pagination.serviceImpl.ClientRepository;
import com.pagination.model.Login;

@Controller
public class ClientController {
	
	private static final int BUTTONS_TO_SHOW = 3;
	private static final int INITIAL_PAGE = 0;
	private static final int INITIAL_PAGE_SIZE = 5;
	private static final int[] PAGE_SIZES = { 5, 10};
	@Autowired
	ClientRepository clientrepository;
	
	@GetMapping("/")
	public ModelAndView homepage(@RequestParam("pageSize") Optional<Integer> pageSize,
			@RequestParam("page") Optional<Integer> page){
		
		
		ModelAndView modelAndView = new ModelAndView("index");
		//
		// Evaluate page size. If requested parameter is null, return initial
		// page size
		int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
		// Evaluate page. If requested parameter is null or less than 0 (to
		// prevent exception), return initial size. Otherwise, return value of
		// param. decreased by 1.
		int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get() - 1;
		// print repo
		System.out.println("here is client repo " + clientrepository.findAll());
		List<Login> clientlist = clientrepository.findAll();
		System.out.println("client list get total pages" + clientlist.size()+ "client list get number " + clientlist.size());
		PagerModel pager = new PagerModel(clientlist.size(),clientlist.size(),BUTTONS_TO_SHOW);
		// add clientmodel
		modelAndView.addObject("clientlist",clientlist);
		// evaluate page size
		modelAndView.addObject("selectedPageSize", evalPageSize);
		// add page sizes
		modelAndView.addObject("pageSizes", PAGE_SIZES);
		// add pager
		modelAndView.addObject("pager", pager);
		return modelAndView;
		
	}
	

	
}