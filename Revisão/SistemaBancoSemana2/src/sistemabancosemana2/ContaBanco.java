
package sistemabancosemana2;
public class ContaBanco {
    int numero;
    String dono;
    double saldo;
    double limite;
     
    public ContaBanco(String dono, double saldo, int numContas){
        this.dono = dono;
        this.saldo = saldo;
        this.numero = numContas;
        this.limite = atualizaLimite();
    }
    
    public double Sacar(double valor){
        if (saldo == 0 ){
            System.out.println("Seu saldo está vazio");
        }
        else if(valor > limite){
            System.out.println("Valor a ser sacado é maior que o limite");
        }
        else{
            saldo -= limite;
            atualizaLimite();
            return valor;
        }
    }
    
    public void Deposita(double quantia){
        this.saldo += quantia;
    }
    
    
    public double atualizaLimite(){
        return (this.saldo * 8) / 100;
    }

    public void mostraTitular(){
        System.out.println("Titular da Conta: " + getDono());
    }
    
    public void mostraSaldo(){
        System.out.println("Saldo da conta: R$" + getSaldo());
    }
    
    public void Transferencia(ContaBanco destinatario, double quantia){
        destinatario.saldo += quantia;
        this.saldo -= quantia;
        atualizaLimite();
    }
    
    public void ImprimeDados(){
        System.out.println("Nome do cliente: " + this.Dono);
        System.out.println("Saldo do cliente" + this.saldo);
        System.out.println("Numero da conta: " + this.numero);
        System.out.println("Limite: " + this.limite);
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}

