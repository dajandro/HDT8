/**
* Universidad Del Valle 
* Pablo Díaz 13203
* Daniel Orozco
*/



/**
 *
 * @author Pablo, Daniel
 */
public class SplayNode {

    private SplayNode izquierda, derecha;
    private SplayNode root;
    private Word word;
    
    public SplayNode(){
        this(null,null,null,null);
    }
  
  
    public SplayNode (Word word, SplayNode izquierda, SplayNode derecha, SplayNode root)
    {
        this.izquierda=izquierda;
        this.derecha=derecha;
        this.word = word;
        this.root = root;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
  
    
    public SplayNode getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(SplayNode izquierda) {
        this.izquierda = izquierda;
    }

    public SplayNode getDerecha() {
        return derecha;
    }

    public void setDerecha(SplayNode derecha) {
        this.derecha = derecha;
    }

    public SplayNode getRoot() {
        return root;
    }

    public void setRoot(SplayNode root) {
        this.root = root;
    }

    
}
