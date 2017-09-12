package com.mygdx.game.BaseDonnees;

import java.util.Random;
import java.util.Vector;


public class Mot {
	private static Random random = new Random();
	private int id;
	private String mot;
	private boolean trouve = false;
	
	public Mot(String str,int num) {
		mot = str;
		id = num;
	}

	public String getMot() {
		return mot;
	}
	public boolean isTrouve() {
		return trouve;
	}

	public void setTrouve(boolean trouve) {
		this.trouve = trouve;
	}

	public int getID() {
		return id;
	}
	public static Mot genererMot(Vector<Mot> tabMot  ) {
		boolean trouve =true;
		int i=0;
		while(trouve) {
			i = random.nextInt(tabMot.size());
			trouve = tabMot.elementAt(i).isTrouve();
		}
		return tabMot.elementAt(i);
		
	}
	
	static int present(char c, String s){
		int i=0; 
		while(i<s.length()) {
			if(s.charAt(i)==c) 
				return i;
			i++;
		}
		return -1;
	}
	
}
