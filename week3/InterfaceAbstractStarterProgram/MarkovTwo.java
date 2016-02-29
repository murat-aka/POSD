
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Random;
import java.util.*;

public class MarkovTwo  extends AbstractMarkovModel{

	
	public MarkovTwo() {
		myRandom = new Random();
	}

	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		
		StringBuffer sb =  new StringBuffer();
		int index = myRandom.nextInt(myText.length()-2);
		String key = myText.substring(index,index+2);
		sb.append(key);
		for(int k=0; k < numChars-2; k++){
			
		    ArrayList<String> follows = getFollows(key);
		    if(follows.size() == 0){
		        break;
		      }
		      
		    index = myRandom.nextInt(follows.size());
		    String next = follows.get(index);
		    sb.append(next);
		    key = next;
		}
		
		return sb.toString();
	}
}
