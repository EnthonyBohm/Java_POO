package questao05prova21;

public class Funcionario {
    // Atributos
    protected String nome;
    protected double salario;
    protected String admissao;

    
    //Métodos Especiais 
    
    public Funcionario(String nome, double salario, String admissao) {
        this.nome = nome;
        this.salario = salario;
        this.admissao = admissao;
    }
    
    public void Aumento(){
        this.salario = this.salario * 0.1 + this.salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getAdmissao() {
        return admissao;
    }

    public void setAdmissao(String admissao) {
        this.admissao = admissao;
    }
    
    
}
