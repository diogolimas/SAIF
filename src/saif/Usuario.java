
package saif;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author 20181041110042
 */
public abstract class Usuario {

  
    String nome;
    String matricula;
    String senha;
     

 
    public Usuario(String nome, String matricula, String senha) {
        this.nome = nome;
        this.matricula = matricula;
        this.senha = senha;
    }
    Scanner kk = new Scanner(System.in);

    

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.matricula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "\nnome: " + nome + ", matricula: " + matricula + ", senha: " + senha + ' ';
    }

 

}
