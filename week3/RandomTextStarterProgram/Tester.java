
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;

public class Tester {
    
    public void testGetFollows(){
        MarkovOne obj1 = new MarkovOne();        
        obj1.setTraining("this is a test yes this is a test.");
        ArrayList<String> follows= obj1.getFollows("es"); 
        
        System.out.println(follows);
      
    }
    
    public void testGetFollowsWithFile(){
        
        FileResource fr = new FileResource();
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovOne obj1 = new MarkovOne();
        obj1.setTraining(st);
        ArrayList<String> follows= obj1.getFollows("t"); 
        
        System.out.println(follows.size());

        
    }

}
