package com.lab2.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lab2.model.Profile;
import com.lab2.service.ProfileService;


@Controller
public class ProfileController {
	
	@Autowired
	private ProfileService profileService; 
	
	@RequestMapping(value="/profile/{id}",params={"firstname","lastname","email","address","organization","aboutMyself"}, method=RequestMethod.GET)
	public String createProfilefromURL(@PathVariable("id") String id,@RequestParam("firstname") String firstname,@RequestParam("lastname") String lastname,@RequestParam("email") String email,@RequestParam("address") String address,@RequestParam("organization") String organization, @RequestParam("aboutMyself") String aboutMyself,Map<String, Object> map)
	{
		Profile p=new Profile();
		p.setId(id);
		p.setFirstname(firstname);
		p.setLastname(lastname);
		p.setEmail(email);
		p.setAddress(address);
		p.setOrganization(organization);
		p.setAboutMyself(aboutMyself);
		Profile temp=profileService.getProfile(p.getId());
		if(temp==null)
		{
			profileService.add(p);	
		}
		else
		{
			profileService.edit(p);
		}
		map.put("profile",p);
		map.put("listOfProfiles", profileService.getAllProfile());
		return "showProfile";
	}


	@RequestMapping(value="/profile/{id}", method=RequestMethod.GET)
	public String getProfile(@PathVariable("id") String id, Model modelProfile)
	{
		//ModelAndView modelProfile = new ModelAndView("profile");		
		Profile p=new Profile();
		p=profileService.getProfile(id);
		if(p!=null)
		{
			modelProfile.addAttribute("profile",p);
		//modelProfile.addObject(p);
			modelProfile.addAttribute("listOfProfiles", profileService.getAllProfile());
			return "showProfile";
		}
		else
		{
			modelProfile.addAttribute("userid",id);
			return "notFound";
		}
	}
	
	@RequestMapping(value="/profile/{id}",params="brief", method=RequestMethod.GET)
	public String getPlainProfile(@PathVariable("id") String id,@RequestParam("brief") String brief, Model modelProfile)
	{
		//ModelAndView modelProfile = new ModelAndView("profile");		
		Profile p=new Profile();
		p=profileService.getProfile(id);
		modelProfile.addAttribute("profile",p);
		if(brief.equals("true"))
		{
			if(p!=null)
				return "showPlainProfile";
			else
			{
				modelProfile.addAttribute("userid",id);
				return "notFound";
			}
		}
		else
		{
			modelProfile.addAttribute("userid",id);
			return "notFound";
		}
	}
	
	@RequestMapping(value={"/profile/{id}","/profilechange"}, method=RequestMethod.POST)
	public String change(@ModelAttribute Profile profile, BindingResult result, @RequestParam String action, Map<String, Object> map){	
		//Profile p=profileService.getProfile(profile.getId());
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "update":
				profileService.edit(profile);
				map.put("profile",profile);
				map.put("listOfProfiles", profileService.getAllProfile());
				return "showProfile";
		case "delete":
			profileService.delete(profile.getId());
			return "createProfile";
		}
		return "showProfile";
	}
	
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String displayProfile()
	{
		return "createProfile";
	}
	
	@RequestMapping(value="/profilecreate",method=RequestMethod.POST)
	public String createProfile(@ModelAttribute Profile profile, BindingResult result, Map<String, Object> map)
	{
		Profile p=profileService.getProfile(profile.getId());
		if(p==null)
		{
			profileService.add(profile);	
		}
		else
		{
			profileService.edit(profile);
		}
		map.put("profile",profile);
		map.put("listOfProfiles", profileService.getAllProfile());
		return "showProfile";
	}
	
	
	
	@RequestMapping(value="/profile/{id}", method=RequestMethod.DELETE)
	public String deleteProfile(@PathVariable("id") String id, Model modelProfile)
	{
		//ModelAndView modelProfile = new ModelAndView("profile");		
		Profile p=new Profile();
		p=profileService.getProfile(id);
		if(p!=null)
		{
			profileService.delete(id);
			return "createProfile";
		}
		else
		{
			modelProfile.addAttribute("userid",id);
			return "notFound";
		}
	}
	
}
