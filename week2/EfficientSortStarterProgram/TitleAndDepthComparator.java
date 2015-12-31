
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class TitleAndDepthComparator implements Comparator<QuakeEntry>{
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        if(q1.getInfo().compareTo(q2.getInfo())==0){
            return Double.compare(q1.getDepth(), q2.getDepth());
        }
        return q1.getInfo().compareTo(q2.getInfo());
    }
    
}
