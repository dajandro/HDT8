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
    static         // Static initializer for nullNode
    {
        nullNode = new RedBlackNode( null );        
        nullNode.setLeft(nullNode);
        nullNode.setRight(nullNode);
    }    
    
    // Used in insert routine and its helpers
    private static RedBlackNode current;
    private static RedBlackNode parent;
    private static RedBlackNode grand;
    private static RedBlackNode great;
    
    /**
     * Compare item and t.element, using compareTo, with
     * caveat that if t is header, then item is always larger.
     * This routine is called if is possible that t is header.
     * If it is not possible for t to be header, use compareTo directly.
     */
    private final int compare( Comparable item, RedBlackNode t ) {
        if( t == header )
            return 1;
        else
            return item.compareTo( t.getElement() );
    }    
    
    /**
     * Internal routine that is called during an insertion
     * if a node has two red children. Performs flip and rotations.
     * @param item the item being inserted.
     */
    private void handleReorient(Word item ) {
        // Do the color flip
        RedBlackNode temp;
        //current.color = RED;                
        current.setColor(RED);        
        //current.left.color = BLACK;        
        current.getLeft().setColor(BLACK);
        //current.right.color = BLACK;        
        current.getRight().setColor(BLACK);
        if( parent.getColor() == RED )   // Have to rotate
        {
            //grand.color = RED;
            grand.setColor(RED);
            if( ( compare( item, grand ) < 0 ) !=
                    ( compare( item, parent ) < 0 ) )
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate( item, great );
            //current.color = BLACK;
            current.setColor(BLACK);
        }
        //header.right.color = BLACK; // Make root black        
        header.getRight().setColor(BLACK);
    }
    
    /**
     * Internal routine that performs a single or double rotation.
     * Because the result is attached to the parent, there are four cases.
     * Called by handleReorient.
     * @param item the item in handleReorient.
     * @param parent the parent of the root of the rotated subtree.
     * @return the root of the rotated subtree.
     */
    private RedBlackNode rotate( Comparable item, RedBlackNode parent ) {
        RedBlackNode temp;
        if( compare( item, parent ) < 0 )
        {   
            temp = compare( item, parent.getLeft() ) < 0 ?
                rotateWithLeftChild( parent.getLeft() )  :  // LL
                rotateWithRightChild( parent.getLeft() ) ;  // LR
            parent.setLeft(temp);
            return temp;
        }
        else
        {
            temp = compare( item, parent.getRight() ) < 0 ?
                rotateWithLeftChild( parent.getRight() ) :  // RL
                rotateWithRightChild( parent.getRight() );  // RR
            parent.setRight(temp);
            return temp;
        }
    }
    
    /**
     * Rotate binary tree node with left child.
     */
    private static RedBlackNode rotateWithLeftChild( RedBlackNode k2 ) {
        RedBlackNode k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        return k1;
    }
    
    /**
     * Rotate binary tree node with right child.
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
            
            // Check if two red children; fix if so
            //if( current.left.color == RED && current.right.color == RED )
            if( current.getLeft().getColor() == RED && current.getRight().getColor() == RED)
                handleReorient( wordObject );
        }
        
        // Insertion fails if already present
        if( current != nullNode )
            throw new DuplicateItemException( wordObject.toString( ) );
        current = new RedBlackNode( wordObject, nullNode, nullNode );
        
        // Attach to parent
        if( compare( wordObject, parent ) < 0 )
            //parent.left = current;
            parent.setLeft(current);
        else
            //parent.right = current;
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
