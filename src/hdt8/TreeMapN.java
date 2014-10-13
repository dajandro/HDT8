/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
*/


import java.util.Iterator;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel Orozco <daniel.orozco>
 */
public class TreeMapN implements WordSet {
    
    private TreeMap<Integer,Word> map;
    private int key;
    
    public TreeMapN()
    {
        map = new TreeMap<Integer,Word>();
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
