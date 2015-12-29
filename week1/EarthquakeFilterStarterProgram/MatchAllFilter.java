
/**
 * Write a description of MatchAllFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class MatchAllFilter implements Filter{

        private ArrayList<Filter> filters;
        
        public MatchAllFilter(){
            
           filters = new ArrayList<Filter>();
        }
        
        public boolean satisfies(QuakeEntry qe) { 
          return false; 
        } 
}
