/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
* Con base en programa de: Eduardo Castellanos
*/

import java.util.TreeMap;

class WordSetFactory {
	
	// Metodo que genera un objeto que implementa WordSet
	// parametro tipo: 1 = SimpleSet
	//                         2 = implementado con Red black tree
	//                         3 = implementado con Splay Tree
	//                         4 = implementado con Hash Table
	//                         5 = implementado con TreeMap (de Java Collection Framework)
	
	public static WordSet generateSet(int tipo)
	{
	    if (tipo == 1)
                return new SimpleSet();                    
            else
                // aqui se regresara el set empleando sus implementaciones:
			// if tipo == 2 cree una instancia para un Wordset implementao con Red Black Tree
			// if tipo == 3 cree una instancia para un Wordset implementado con Splay Tree
			// if tipo == 4 cree una instancia para un Wordset implementado con Hash table
			// if tipo == 5 cree una instancia para un Wordset implementado con TreeMap
                if (tipo == 5)
                    return (WordSet) new TreeMap();
                else
                    if (tipo == 2)
                        return new RedBlackTree();
                    else
			return null; // modificarlo para que regrese la implementacion seleccionada
	}
	
	
}