package com.vlcc.app.controller;

import javax.validation.Valid;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.vlcc.app.model.Login;
import com.vlcc.app.service.LoginService;

@Controller
public class UserController {
	private static Cluster cluster;
	private static Session session;

	@Autowired
	LoginService service;
	@Autowired
	Login user;

	@RequestMapping(value = "/createuser", method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		System.out.println("Inside create user");
		return "createuser";
	}

	@RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	public ModelAndView showUserDetailsPage(ModelMap model) {
		System.out.println("Inside userdetails");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userdetails");
		 model.addAttribute("Logins",service.findAll() );
		return modelAndView;
	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(ModelMap model, @RequestParam(name = "userName") String userName) {
		System.out.println("Inside delete");
	    service.deleteById(userName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userdetails");
		modelAndView.addObject("Logins", service.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView editUser(ModelMap model, @RequestParam(name = "userName") String userName) {
		System.out.println("Inside edit==" + userName);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updateUser");
		modelAndView.addObject("editUser", service.findByFirstName(userName));
		return modelAndView;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
	public ModelAndView updateUser(ModelMap model, @ModelAttribute @Valid Login updateUser) {
		cluster = Cluster.builder().addContactPoint("127.0.0.1").withCredentials("vlcc", "vlcc").build();
		session = cluster.connect("dev");
		CassandraOperations cassandraOps = new CassandraTemplate(session);
		cassandraOps.update(updateUser);
		System.out.println("Inside updateuser");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("welcome");

		return modelAndView;
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public ModelAndView createUser(ModelMap model, @ModelAttribute @Valid Login newuser, BindingResult bindingResult) {
		System.out.println("new user name =" + newuser.getFirst_name());
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {

			System.out.println("BINDING RESULT ERROR");

			modelAndView.setViewName("createuser");

		} else {

			service.save(newuser);
			modelAndView.setViewName("welcome");
		}
		return modelAndView;

	}
}
