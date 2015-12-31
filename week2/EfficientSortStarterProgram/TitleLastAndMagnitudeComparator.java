
/**
 * Write a description of TitleLastAndMagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry>{
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        
        String t1 = q1.getInfo();
        String t2 = q2.getInfo();
        String l1 = t1.substring(t1.lastIndexOf(" ")+1);
        String l2 = t2.substring(t2.lastIndexOf(" ")+1);
        
        if(l1.compareTo(l2)==0){
            return Double.compare(q1.getMagnitude(), q2.getMagnitude());
        }
        return l1.compareTo(l2);
    }
    
//         String lastWord = test.substring(test.lastIndexOf(" ")+1);
//         System.out.println(lastWord);
    
}
