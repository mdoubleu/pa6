package org.MemoryAndroid;

import java.util.HashMap;
import java.util.LinkedList;

public class Level {
	HashMap<String, String> level=new HashMap<String, String>();
	LinkedList<String> questions= new LinkedList<String>();
	LinkedList<String> answers= new LinkedList<String>();
	public Level(int stage){
			if(stage==1){
				questions.add("8-1");
				questions.add("3+11");
				questions.add("6-6");
				questions.add("15-9");
				
				answers.add("7");
				answers.add("14");
				answers.add("6");
				answers.add("0");
				
				level.put("8-1", "7");
				level.put("3+11", "14");
				level.put("6-6", "0");
				level.put("15-9", "6");
			}
			
		}
		
		public LinkedList<String> getQuestion(){
			return questions;
		}
		public LinkedList<String> getAnswer(){
			return answers;
		}
		public HashMap<String, String> getMap(){
			return level;
		}
	}
