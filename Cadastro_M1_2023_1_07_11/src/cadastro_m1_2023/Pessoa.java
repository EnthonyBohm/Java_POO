/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_m1_2023;

/**
 *
 * @author Felipe Marques
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private Data dataDeNascimento;
    private float altura;
    
    public Pessoa() { // Padrão
        this.nome = "Fulano de Tal";
        this.cpf = "";
        this.altura = 0.0f;
        this.dataDeNascimento = new Data(1, 1, 1900);
    }
    
    public Pessoa(String nome, String cpf, float altura, Data d) { // de Inicialiação
        this.nome = nome;
        this.cpf = cpf;
        this.altura = altura;
        this.dataDeNascimento = d;
    }
    
    public Pessoa(Pessoa p) { // de Cópia
        this.nome = p.nome;
        this.cpf = p.cpf;
        this.altura = p.altura;
        this.dataDeNascimento = p.dataDeNascimento;
    }
    
    String getNome() {
        return this.nome;
    }
    
    Data getData() {
        return this.dataDeNascimento;
    }
    
    float getAltura() {
        return this.altura;
    }
    
    void setNome(String nome) {
        this.nome = nome;
    } 
    
    void setData(Data data) {
        this.dataDeNascimento = data;
    }
    
    void setAltura(float altura) {
        this.altura = altura;
    }
    
    int calculaIdade() {
        return this.dataDeNascimento.calcularIdade();
    }
    
    @Override
    public String toString() {
        return "CPF: " + cpf + "\n" +
               "Nome: " + nome + " | Idade: " + calculaIdade() + "\n" +
               "Data de Nascimento: " + dataDeNascimento + "\n" +
               "Altura: " + altura;
    }

    @Override
    public boolean equals(Object o) {
       if (this == o) {  
           return true;  
       }  
       if (o instanceof Pessoa) {  
           Pessoa p = (Pessoa) o;  
           if (this.cpf.equals(p.cpf)) {  
               return true;  
           }  
       }  
       return false;              
    }
}
