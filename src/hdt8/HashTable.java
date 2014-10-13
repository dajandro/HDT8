import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

/**
* Universidad Del Valle 
* Pablo Díaz 13203
* Daniel Orozco 13312
*/

/**
 *
 * @author Pablo, Daniel
 */
class HashTable implements WordSet {

    private final HashMap<Integer,Word> map;
    private int key;
    
    public HashTable() {
        map = new HashMap();
        key = 0;
        
    }

    @Override
    public void add(Word wordObject) {
        map.put(key, wordObject);
        key++;
    }

    @Override
    public Word get(Word word) {
      Iterator<Integer> it = map.keySet().iterator();
        while(it.hasNext())
        {
            Integer keyIt = it.next();
            if (map.get(keyIt).equals(word)) return map.get(keyIt);
        }
        return null;  
    }

}
