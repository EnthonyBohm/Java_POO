package ufpel.enthony.trabalhofinal;

public class ImpossibleToPassTrapException extends RuntimeException{
    
    public ImpossibleToPassTrapException (){
        super();
    }

    public ImpossibleToPassTrapException (String reason){
        super(reason);
    }
}
