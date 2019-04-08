package com.project.application.pokedex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PokemonService {

	@Autowired
	private PokemonDao pd;
	
	
	public List<Pokemon> findAll(){
		return pd.findAll();
	}
	
	
	//获取单个pokemon信息
	public Pokemon getPokeById(int id) {
		return pd.findById(id);
	}
	
	//添加topic
	public Pokemon getPokeByName(String name) {
		return pd.findByName(name);
	}

	//编辑topic
	 public List<Pokemon> getSet(ArrayList<Integer> set) {
		 int count=0;
		 List<Pokemon> result=null;
		 for(int i=0;i<set.size();i++) {
			 Pokemon p=pd.findById(set.get(i));
			 result.add(p);
		 }
		 return result;	
	}
//
//	 //删除topic
//	public void deleteTopic(String id) {
//		topicRepository.deleteById(id);
//	}
	
	public boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
}

