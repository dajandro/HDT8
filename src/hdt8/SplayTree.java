/**
* Universidad Del Valle 
* Pablo Díaz 13203
* Daniel Orozco 13312
*/


/**
 *
 * @author Pablo, Daniel
 */
public class SplayTree implements WordSet{

    private SplayNode raiz;
    
    /**
     * metodo para agregar una palabra al arbol
     * @param wordIngresado
     */
    @Override
     public void add(Word wordIngresado) 
     //pre: recibe la palabra leida del acrhivo
     //post: la mete al arbol, ordena si es necesario
     {
         
         SplayNode nodoSiguiente = raiz;
         SplayNode nodoactual=null;
         
         while(nodoSiguiente!=null)
         {
             nodoactual=nodoSiguiente;
             //comparar valor del noodo
             if (nodoactual.getWord().compareTo(wordIngresado)>0)
                 nodoSiguiente = nodoSiguiente.getDerecha();
             else
                 nodoSiguiente = nodoSiguiente.getIzquierda();
         }
         
         //ingresar al arbol
         nodoSiguiente = new SplayNode();
         nodoSiguiente.setWord(wordIngresado);
         nodoSiguiente.setRoot(nodoactual);
         
         if (nodoactual==null)
             raiz = nodoSiguiente;
         else if (nodoactual.getWord().compareTo(wordIngresado)>0)
             nodoactual.setDerecha(nodoSiguiente);
         else
             nodoactual.setIzquierda(nodoSiguiente);
         //realizar el cambio de nodos
         Splay(nodoSiguiente);
         
         
     }

    
    private void Splay(SplayNode nodoSiguiente)
    //pre: recibe el nodo siguiente a evaluar
    //post: no devuelve nada pero ordena el arbol
    {
        while (nodoSiguiente.getRoot() != null)
        {

            //Nodos a utilizar
            SplayNode nodoPadre = nodoSiguiente.getRoot();
            SplayNode nodoAbuelo= nodoPadre.getRoot();

            //verificar zig /zag
            if (nodoAbuelo == null){
                if (nodoSiguiente == nodoPadre.getIzquierda())
                    Zig(nodoSiguiente, nodoPadre);
                else
                    Zag(nodoSiguiente, nodoPadre);               
            }

            //Si existen dos nodos padres
            else{
                  if (nodoSiguiente == nodoPadre.getIzquierda())
                  {

                    if (nodoPadre == nodoAbuelo.getIzquierda())
                    {
                        Zig(nodoPadre, nodoAbuelo);
                        Zig(nodoSiguiente, nodoPadre);
                    }else{
                        Zig(nodoSiguiente, nodoSiguiente.getRoot());
                        Zag(nodoSiguiente, nodoSiguiente.getRoot());
                    }
                }else {
                    
                    if (nodoPadre == nodoAbuelo.getIzquierda())
                    {
                        Zag(nodoSiguiente, nodoSiguiente.getRoot());
                        Zig(nodoSiguiente, nodoSiguiente.getRoot());
                    }else{
                        Zag(nodoPadre, nodoAbuelo);
                        Zag(nodoSiguiente, nodoPadre);
                    }
                }
            }
        }
        raiz = nodoSiguiente;
     }
    
    
    
    public void Zig(SplayNode hijo, SplayNode padre)
    //pre: recibe dos nodos conectados
    //post: ordenamiento zig
    {
       
        //Se verifica el nodo padre para la primera rotacion
        if (padre.getRoot() != null){
            if (padre == padre.getRoot().getIzquierda())
                padre.getRoot().setIzquierda(hijo);
                
            else
                padre.getRoot().setDerecha(hijo);

        }

        if (hijo.getDerecha() != null)
            hijo.getDerecha().setRoot(padre);


        //Se hace la rotacion
        hijo.setRoot(padre.getRoot());
        padre.setRoot(hijo);
        padre.setIzquierda(hijo.getDerecha());
        hijo.setDerecha(padre);

            
    }

 

   
    public void Zag(SplayNode hijo, SplayNode padre)
   //pre: recibe dos nodos conectados
    //post: ordenamiento zag
    {

        //rotacion del padre
        if (padre.getRoot() != null)
        {
            if (padre == padre.getRoot().getIzquierda()){
                padre.getRoot().setIzquierda(hijo);
            }
            else
                padre.getRoot().setDerecha(hijo);
                
        }

        if (hijo.getIzquierda() != null)
            hijo.getIzquierda().setRoot(padre);
           

        //Se hace la rotacion
        hijo.setRoot(padre.getRoot());
        padre.setRoot(hijo);
        padre.setDerecha(hijo.getIzquierda());
        hijo.setIzquierda(padre);
        
    }

    
    @Override
    public Word get(Word word){

        SplayNode nodoEvaluar = raiz;
        while (nodoEvaluar != null){

            if (nodoEvaluar.getWord().compareTo(word)>0)
            {
                nodoEvaluar = nodoEvaluar.getDerecha();
            }

            else if (nodoEvaluar.getWord().compareTo(word)<0)
            {
                nodoEvaluar = nodoEvaluar.getIzquierda();
            }

            else
                 return nodoEvaluar.getWord();
            
        }
        return null;
    }
    
}
