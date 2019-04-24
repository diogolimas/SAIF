/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saif;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 20181041110042
 */
class Administrador extends Usuario {

    int quantidadeDeUs = 1;
    int indice = quantidadeDeUs - 1;
   // vamos utilizar um array list pra ficar melhor

   // Usuario usuarios[] = new Usuario[quantidadeDeUs];
    public Administrador(String nome, String matricula, String senha) {
        super(nome, matricula, senha);

    }
    Scanner sc = new Scanner(System.in);


}
