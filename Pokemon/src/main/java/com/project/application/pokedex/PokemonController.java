package com.project.application.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService ps;
	
	@RequestMapping("/findAll")
    public List<Pokemon> findAll() {
        return ps.findAll();
    }
	
	@RequestMapping("/{s}")
	public Pokemon findById(@PathVariable("s") String s) {
		if(ps.isNumeric(s)) {
			int id=Integer.parseInt(s);
			return ps.getPokeById(id);
		}
		else {
			return ps.getPokeByName(s);
		}
	}
	
    

}
