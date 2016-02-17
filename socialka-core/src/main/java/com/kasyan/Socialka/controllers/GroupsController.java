package com.kasyan.Socialka.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kasyan.Socialka.dto.Group;
import com.kasyan.Socialka.services.GroupDaoService;

@Controller
@RequestMapping("/groups")
public class GroupsController {
	
	@Autowired
	private GroupDaoService groupDaoService;
	private final Logger logger = Logger.getLogger(this.getClass().getName());
	
	
	public void setGroupDaoService(GroupDaoService groupDaoService) {
		this.groupDaoService = groupDaoService;
	}

	@RequestMapping(value="/{groupName}", method=RequestMethod.GET)
	public ModelAndView getGroup(@PathVariable String groupName){
		logger.debug("Group name "+groupName);
		Group group = groupDaoService.getGroup(groupName);
		logger.debug(group);
		ModelAndView mv = new ModelAndView();
		mv.addObject("description", group.getDescription());
		mv.addObject("title", group.getTitle());
		mv.addObject("town", group.getTown());
		mv.setViewName("group");
		return mv;
	}
	
	@RequestMapping("/my_groups")
	public ModelAndView getMyGroups(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("groups");
		return mv;
	}
}
