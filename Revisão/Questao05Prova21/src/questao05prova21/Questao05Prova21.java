package questao05prova21;

public class Questao05Prova21 {

    public static void main(String[] args) {
        Empresa amazing = new Empresa("AMAZING", "9984.2344.8902-95", 3);
//        Funcionario[] funcionarios = new Funcionario[amazing.getQtdeFuncionarios()];
        
        amazing.inserirAnalista( "Mauricio Veiga", "12/08/22", 2900.00);
        amazing.inserirGerente( "Junior Couto", "07/05/2008", 14000.00);
        amazing.inserirTecnico("Amanda Vieira", "09/12/2020", 7000.00);
        
        amazing.info();
        amazing.aumentaSalario();
        amazing.info();
    }
    
}
