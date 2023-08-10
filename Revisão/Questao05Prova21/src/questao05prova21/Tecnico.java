package questao05prova21;

public class Tecnico extends Funcionario{
    
    public Tecnico (String nome, double salario, String admissao){
        super(nome, salario, admissao);
    }
    
    @Override
    public String getNome(){
        return ("Nome: " + this.nome + "\nCargo: Tecnico");
    }
}
