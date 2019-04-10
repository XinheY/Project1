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

import com.project.application.pokedex.Pokemon;
import com.project.application.pokedex.PokemonService;



@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@Autowired
	private PokemonService ps;
	
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
	
	@RequestMapping(path="/login")
	public	@ResponseBody  Map<String, String> login (@RequestParam String email, @RequestParam String password) {
		Map<String, String>  response= new HashMap<>();
		System.out.println("userlogin: "+" email-"+email+" password-"+password);
		User checkuser = new User();
		checkuser = us.findByEmail(email);
		//if user exist
		if(checkuser != null) {
			if(password.equals(checkuser.getPassword())){
				//login success
				response.put("message", "login success");
				checkuser.setOnline(true);
				System.out.println("id:"+checkuser.getId()+"  email: "+checkuser.getEmail()+"  password:"+checkuser.getPassword()+"  online:"+checkuser.isOnline());
				us.updateUser(checkuser);
			}
			else {
				response.put("message", "login fail");
			}
			
		}
		else {
			//user not exist
			response.put("message", "user doesn't exist!");
		}
		return response;
	}
	
	@RequestMapping(path="/logout")
	public	@ResponseBody  Map<String, String> logout (@RequestParam String email) {
		Map<String, String>  response= new HashMap<>();
		System.out.println("userlogin: "+" email-"+email);
		User checkuser = new User();
		checkuser = us.findByEmail(email);
		//if user is online
		if(checkuser.isOnline()==true) {
				response.put("message", "logout success");
				checkuser.setOnline(false);
//				System.out.println("id:"+checkuser.getId()+"  email: "+checkuser.getEmail()+"  password:"+checkuser.getPassword()+"  online:"+checkuser.isOnline());
				us.updateUser(checkuser);		
		}
		else {
			//user doesn't online
			response.put("message", "user doesn't online!");
		}
		return response;
	}

	@RequestMapping(path="/addcard")
	public	@ResponseBody Map<String, String>  addNewCard ( @RequestParam int cardId,@RequestParam String email) {
		Map<String, String>  response= new HashMap<>();
		User checkuser = new User();
		checkuser = us.findByEmail(email);
		String deck=checkuser.getDeck();
		if(deck.equals("Empty")) {
			deck=cardId+" ";
		}
		else {
			deck+=cardId+" ";
		}
		response.put("Message","Add card to deck successfully" );
		checkuser.setDeck(deck);
		us.updateUser(checkuser);
		return response;
	}

	@RequestMapping(path="/deletecard")
	public	@ResponseBody Map<String, String>  deleteCard ( @RequestParam int count, @RequestParam String email) {
		Map<String, String>  response= new HashMap<>();
		User checkuser = new User();
		checkuser = us.findByEmail(email);
		String deck="";
		String[] ab=checkuser.getDeck().split(" ");
		if(checkuser.getDeck().equals("Empty")) {
			response.put("Error:", "No card in the deck");
		}
		else if(ab.length<count+1) {
			response.put("Error:", "Out of bound");
		}
		else {
		for(int i=0;i<ab.length;i++) {
			if(i!=count) {
				deck+=ab[i]+" ";
			}
		}
		response.put("Message","Delete card from deck successfully" );
		checkuser.setDeck(deck);
		us.updateUser(checkuser);
		}
		return response;
	}

	@RequestMapping("/getdeck")
    public List<Pokemon> getDeck(@RequestParam String email ) {
       List<Pokemon> poke=new ArrayList<Pokemon>();
       User checkuser = us.findByEmail(email);
       String[] deck=checkuser.getDeck().split(" ");
       for(int i=0;i<deck.length;i++) {
    	   poke.add(ps.getPokeById(Integer.parseInt(deck[i])));
       }
		return poke;
    }
}
