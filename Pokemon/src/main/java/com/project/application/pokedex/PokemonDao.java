package com.project.application.pokedex;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PokemonDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<Pokemon> findAll(){
	List<Pokemon> res = jdbcTemplate.query("select * from Pokedex", new Object[]{},
                                                                      new BeanPropertyRowMapper(Pokemon.class));
	return res;
			}

	public Pokemon findById(int id) {
		List<Pokemon> res = jdbcTemplate.query("select * from Pokedex", new Object[]{},
				new BeanPropertyRowMapper(Pokemon.class));
		Pokemon result=null;
		for(int i=0;i<res.size();i++) {
			if(res.get(i).getId()==id) {
				result=res.get(i);
			}
		}
	      return result;
	}

	public Pokemon findByName(String name) {
		// TODO Auto-generated method stub
		List<Pokemon> res = jdbcTemplate.query("select * from Pokedex", new Object[]{},
				new BeanPropertyRowMapper(Pokemon.class));
		Pokemon result=null;
		for(int i=0;i<res.size();i++) {
			if(res.get(i).getName().equals(name)) {
				result=res.get(i);
			}
		}
	      return result;
	}

}

