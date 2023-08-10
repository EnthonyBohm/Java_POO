package questao05prova21;

public class Gerente extends Funcionario{
    
    public Gerente(String nome, double salario, String admissao) {
        super(nome, salario, admissao);
    }
    
    @Override
    public void Aumento(){
        this.salario = this.salario * 0.15 + this.salario;
    }
    
    @Override
    public String getNome(){
        return ("Nome: " + this.nome + "\nCargo: Gerente");
    }
}
