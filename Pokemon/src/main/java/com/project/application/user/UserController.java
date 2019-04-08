package com.project.application.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(path="/signup")
	public	@ResponseBody Map<String, String>  addNewUser ( @RequestParam String email, @RequestParam String password) {
		Map<String, String>  response= new HashMap<>();
		User checkuser = new User();
		checkuser = us.findByEmail(email);
		//if user exist
		if(checkuser != null) {
			System.out.println(" email-"+email+" exist!");
			response.put("code", "0");
			response.put("message", "user exist!");
		}
		//add to database
		else {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setDeck("Empty");
			user.setOnline(false);
			System.out.println("addnewuser: "+" email-"+email+" password-"+password+"  ID:"+user.getId()+" Set: "+user.getDeck());
			us.addNew(user);
			response.put("code", "1");
			response.put("message", "signup success");
		}
		return response;
	}

	@RequestMapping("/findAll")
    public List<User> findAll() {
        return us.findAll();
    }
	
}
