/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saif;

/**
 *
 * @author 20181041110042
 */
public class Aluno extends Usuario{
	 int nota1;
	 int nota2;
	
	
    public Aluno(String nome, String matricula, String senha, int nota1, int nota2) {
        super(nome, matricula, senha);
        this.nota1=nota1;
        this.nota2=nota2;
        
    }


    
}
