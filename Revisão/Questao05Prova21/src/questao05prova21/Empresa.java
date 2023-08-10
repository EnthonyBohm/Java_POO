package questao05prova21;

public class Empresa {
    //Atributos
    private String nome;
    private String CNPJ;
    private Funcionario[] funcionarios;
    private int totFuncionarios, qtdeFuncionarios = 0;
    
    
    //Metodos
    
    public void inserirGerente(String nome, String admissao, double salario){
        funcionarios[qtdeFuncionarios] = new Gerente(nome, salario, admissao);
        qtdeFuncionarios++;
    }
    
    public void inserirTecnico(String nome, String admissao, double salario){
        funcionarios[qtdeFuncionarios] = new Tecnico(nome, salario, admissao);
        qtdeFuncionarios++;
    }
    
    public void inserirAnalista(String nome, String admissao, double salario){
        funcionarios[qtdeFuncionarios] = new Analista(nome, salario, admissao);
        qtdeFuncionarios++;
    }
    
    public void aumentaSalario(){
        for(int i = 0; i < this.qtdeFuncionarios; i++){
            funcionarios[i].Aumento();
        }   
    }
    
    public void info(){
        System.out.println("Nome da empresa: " + this.nome);
        System.out.println("Quantidade de funcionarios: " + this.qtdeFuncionarios + "\nFuncionarios:");
        for (int i = 0; i < qtdeFuncionarios; i++){
            System.out.println(funcionarios[i].getNome()+"\nSalario: " + funcionarios[i].getSalario());
            System.out.println("");
        }
        System.out.println("");
    }
    
    //Metodos Especiais
    public Empresa(String nome, String CNPJ, int qtdeFuncionarios) {
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.funcionarios = new Funcionario[qtdeFuncionarios];
    }

    public String getNome() {
        return nome;
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }
    
    
    
    
}
 