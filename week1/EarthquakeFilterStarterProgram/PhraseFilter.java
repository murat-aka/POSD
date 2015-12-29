
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter{
    
    private String where; 
    private String phrase; 
    
    public PhraseFilter(String w, String p) { 
        where = w;
        phrase = p;
    } 

    public boolean satisfies(QuakeEntry qe) { 
        
            if(where.equalsIgnoreCase("start"))
            {
                boolean  b = qe.getInfo().startsWith(phrase);  // true
                return b;
            }
            
            // Ends with
            if(where.equalsIgnoreCase("end"))
            {
                boolean  b = qe.getInfo().endsWith(phrase);  // true
                return b;
            }
            //b = string.endsWith("dam");             // true
            
            // Anywhere, including beginning
            if(where.equalsIgnoreCase("any"))
            {
                boolean  b = qe.getInfo().indexOf(phrase) >= 0;  // true
                return b;
            }
            
            return false;
            
    } 
    
    
    public String getName(){
        
        return "Phrase";
    }
    
    
//       if(where.equalsIgnoreCase("start"))
//             {
//                 boolean  b = qe.getInfo().startsWith(phrase);  // true
//                 if(b)answer.add(qe);
//             }
//             
//             // Ends with
//             if(where.equalsIgnoreCase("end"))
//             {
//                 boolean  b = qe.getInfo().endsWith(phrase);  // true
//                 if(b)answer.add(qe);
//             }
//             //b = string.endsWith("dam");             // true
//             
//             // Anywhere, including beginning
//             if(where.equalsIgnoreCase("any"))
//             {
//                 boolean  b = qe.getInfo().indexOf(phrase) >= 0;  // true
//                 if(b)answer.add(qe);
//             }

}
