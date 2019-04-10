package com.project.application.pokedex;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pokedex")
public class Pokemon {
	
	@Id
    private int id;
	private String Name;
	private int ATK;
	private int DFS;
	private int CP;
	
	public Pokemon() {
		
	}
	
	public Pokemon(int id, String name, int atk, int dfs, int cp) {
		this.id=id;
		this.Name=name;
		ATK=atk;
		DFS=dfs;
		CP=cp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getDFS() {
		return DFS;
	}

	public void setDFS(int dFS) {
		DFS = dFS;
	}

	public int getCP() {
		return CP;
	}

	public void setCP(int cP) {
		CP = cP;
	}
	
	
}
