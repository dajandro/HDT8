/**
* Universidad del Valle de Guatemala
* Pablo Diaz 13203
* Daniel Orozco 13312
*/

/**
 *
 * @author Daniel Orozco <daniel.orozco>
 */
public class RedBlackNode {
    
        private Word element;
        private RedBlackNode left;
        private RedBlackNode right;
        private int color;
        
        // Constructor
        public RedBlackNode(Word word) {
            this(word, null, null );
        }
        
        // Constructor con parámetros
        public RedBlackNode(Word word, RedBlackNode lt, RedBlackNode rt ) {
            this.element  = word;
            this.left     = lt;
            this.right    = rt;
            this.color    = 1; // Represetna Black
        }
        
        public void setLeft(RedBlackNode node)
        {
            this.left = node;
        }
        
        public void setRight(RedBlackNode node)
        {
            this.right = node;
        }
        
        public void setColor(int col)
        {
            this.color = col;
        }
        
        public void setElement(Word e)
        {
            this.element = e;
        }
        
        public RedBlackNode getLeft()
        {
            return this.left;                    
        }
        
        public RedBlackNode getRight()
        {
            return this.right;
        }
        
        public int getColor()
        {
            return this.color;
        }
        
        public Word getElement()
        {
            return this.element;
        }
}
