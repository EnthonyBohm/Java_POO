package questao05prova21;
public class Analista extends Funcionario{
    
    public Analista(String nome, double salario, String admissao){
        super(nome, salario, admissao);
    }
    
    @Override
    public String getNome(){
        return ("Nome: " + this.nome + "\nCargo: ANALista");
    }
}
