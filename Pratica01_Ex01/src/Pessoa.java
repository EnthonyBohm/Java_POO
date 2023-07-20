/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author felipe
 */

public class Pessoa {
    private String nome;
    private Data dataDeNascimento;
    private float altura;

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Data getDataDeNscimento() {
        return dataDeNascimento;
    }

    /**
     * @param dataDeNascimento the dataDeNascimento to set
     */
    public void setDataDeNascimento(Data dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Data de Nascimento: " +
                this.dataDeNascimento.dia() + "/" +
                this.dataDeNascimento.mes() + "/" +
                this.dataDeNascimento.ano());
        System.out.println("Altura: " + this.altura);
    }
    
    public int calcularIdade(Data dataAtual) {
        int idade = dataAtual.ano() - this.dataDeNascimento.ano();
        if (dataAtual.mes() < this.dataDeNascimento.mes())
            idade--;
        else if (dataAtual.mes() == this.dataDeNascimento.mes() &&
                dataAtual.dia() < this.dataDeNascimento.dia())
            idade--;
        return idade;
    }
    
    
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.setNome("Felipe");
        Data d = new Data(11, 8, 2000);
        p1.setDataDeNascimento(d);
        p1.setAltura(1.67f);
       
        p1.imprimir();
        
        System.out.println("Idade: " + p1.calcularIdade(new Data(20, 6, 2023)));
    }
}
