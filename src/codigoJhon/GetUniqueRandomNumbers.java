package codigoJhon;

import java.util.ArrayList; 
import java.util.Collections; 
 
public class GetUniqueRandomNumbers { 
	public int obtenerRandom() {
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        for (int i = 0; i < 5; i++) { 
            list.add(new Integer(i)); 
        } 
        Collections.shuffle(list); 
        return  list.get(0);
	}
} 
