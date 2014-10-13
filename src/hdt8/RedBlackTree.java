/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
*/

/**
 *
 * @author Daniel Orozco <daniel.orozco>
 */
public class RedBlackTree implements WordSet {
    
    private final int BLACK = 1;
    private final int RED   = 0;
    private RedBlackNode header;
    private static final RedBlackNode nullNode;
    static         // Inicializador de nodo nullo
    {
        nullNode = new RedBlackNode( null );        
        nullNode.setLeft(nullNode);
        nullNode.setRight(nullNode);
    }    
    private static RedBlackNode current;
    private static RedBlackNode parent;
    private static RedBlackNode grand;
    private static RedBlackNode great;
    
    // Constructor
    public RedBlackTree( ) {
        header = new RedBlackNode(null);        
        header.setLeft(nullNode);
        header.setRight(nullNode);
    }
    
    /**     
     * Tipo especial de compare
     * Compara el item y el elemento correspondiente al RBNode
     */
    private final int compare( Word item, RedBlackNode t ) {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.getElement() );
    }    
    
    /**     
     * Reorientación utilizada si un nodo tiene dos hijos rojos
     */
    private void handleReorient(Word item ) {
        // Flip de color
        RedBlackNode temp;        
        current.setColor(RED);                
        current.getLeft().setColor(BLACK);        
        current.getRight().setColor(BLACK);
        if( parent.getColor() == RED )
        {            
            grand.setColor(RED);
            if( ( compare( item, grand ) < 0 ) !=
                    ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );
            current = rotate( item, great );            
            current.setColor(BLACK);
        }        
        header.getRight().setColor(BLACK);
    }
    
    /**     
     * Realiza una simple o doble rotación
     */
    private RedBlackNode rotate( Word item, RedBlackNode parent ) {
        RedBlackNode temp;
        if( compare( item, parent ) < 0 )
        {   
            temp = compare( item, parent.getLeft() ) < 0 ?
                rotateWithLeftChild( parent.getLeft() )  :
                rotateWithRightChild( parent.getLeft() ) ;
            parent.setLeft(temp);
            return temp;
        }
        else
        {
            temp = compare( item, parent.getRight() ) < 0 ?
                rotateWithLeftChild( parent.getRight() ) :
                rotateWithRightChild( parent.getRight() );
            parent.setRight(temp);
            return temp;
        }
    }
    
    /**     
     * Rota con el hijo izquierdo
     */
    private static RedBlackNode rotateWithLeftChild( RedBlackNode k2 ) {
        RedBlackNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        return k1;
    }
    
    /**
     * Rota con el hijo derecho
     */
    private static RedBlackNode rotateWithRightChild( RedBlackNode k1 ) {
        RedBlackNode k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        return k2;
    }

    @Override
    public void add(Word wordObject) {
        current = parent = grand = header;
        nullNode.setElement(wordObject);
        
        while( compare( wordObject, current ) != 0 ) {
            great = grand; grand = parent; parent = current;
            current = compare( wordObject, current ) < 0 ?
                current.getLeft() : current.getRight();
            
            // Evaluar si hay dos hijos rojos            
            if( current.getLeft().getColor() == RED && current.getRight().getColor() == RED)
                handleReorient( wordObject );
        }
        
        // El agregar falla cuando existe un elemento repetido
        current = new RedBlackNode( wordObject, nullNode, nullNode );        
        
        if( compare( wordObject, parent ) < 0 )            
            parent.setLeft(current);
        else            
            parent.setRight(current);
        handleReorient( wordObject );
    }

    @Override
    public Word get(Word word) {
        nullNode.setElement(word);
        current = header.getRight();        
        for( ; ; ) {
            if( word.compareTo( current.getElement() ) < 0 )
                current = current.getLeft();
            else if( word.compareTo( current.getElement() ) > 0 )
                current = current.getRight();
            else if( current != nullNode )
                return current.getElement();
            else
                return null;
        }
    }    
}
