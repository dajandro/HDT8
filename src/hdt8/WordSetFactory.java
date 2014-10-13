/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
* Con base en programa de: Eduardo Castellanos
*/

//import java.util.TreeMapN;

class WordSetFactory {
	
	// Metodo que genera un objeto que implementa WordSet
	// parametro tipo: 1 = SimpleSet
	//                         2 = implementado con Red black tree
	//                         3 = implementado con Splay Tree
	//                         4 = implementado con Hash Table
	//                         5 = implementado con TreeMapN (de Java Collection Framework)
	
	public static WordSet generateSet(int tipo)
	{
	    if (tipo == 1)
                return new SimpleSet();     
            if (tipo ==2 )
                return new RedBlackTree();
            if (tipo==3)
                return new SplayTree();
            if (tipo==4)
                return new HashTable();
            if (tipo==5)
                return new TreeMapN();
            else
                return null; // modificarlo para que regrese la implementacion seleccionada
	}
	
	
}