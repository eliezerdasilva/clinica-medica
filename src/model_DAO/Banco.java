/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model_DAO;

import model.Agendamento;
import model.Cliente;
import model.Servico;
import model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Banco {
    
    public static ArrayList<Usuario> usuario;
    public static ArrayList<Cliente> cliente;
    public static ArrayList<Servico> servico;
    public static ArrayList<Agendamento> agendamento;
    
    
    public static void inicia(){
    
        //Instancia os Objetos
        usuario = new ArrayList<Usuario>();
        cliente = new ArrayList<Cliente>();
        servico = new ArrayList<Servico>();
        agendamento = new ArrayList<Agendamento>();
        
        //criando elementos
        
        Usuario usuario1 = new Usuario(1, "Gerente", 'M', "09/05/1996", "30212121", "Gerente@gmail.com", "521454123", "Gerente", "administrador");
        Usuario usuario2 = new Usuario(2, "estagiaria", 'F', "09/05/1996", "30212122", "estagiario@barbershop.com", "451244123", "estagiario", "funcionario");
         
        Cliente cliente1 = new Cliente(1, "Alan da Silva", 'M', "30/01/1995", "30212126", "Alan.h607@gmail.com", "5142487", "Rua Gaspar 35 Canudos NH",  "93300012");
        Cliente cliente2 = new Cliente(2, "Ian Luis", 'F', "30/08/1994", "30212127", "Ian@gmail.com", "5142487745", "Rua Blumenau 78 Centro NH",  "93300045");
        Cliente cliente3 = new Cliente(3, "jose Ricado", 'M', "24/04/1997", "30212128", "Jose@gmail.com", "78451458", "Rua Campo Grande 30 Rio de janeiro - NH",  "933007496");
        Cliente cliente4 = new Cliente(4, "Marcelo Santos", 'M', "20/08/1995", "30212130", "Marcelo@gmail.com", "2745487", "Rua Londrina 40 Canudos NH",  "93300748");
        Cliente cliente5 = new Cliente(5, "Carlos Pipoqueiro", 'M', "13/09/1992", "30212131", "Carlos@gmail.com", "4742487", "Rua Sao Paulo quaresma 784 Canudos Belgica",  "933000847");
        Cliente cliente6 = new Cliente(6, "João Pareira", 'M', "17/08/1994", "302122324", "Joao@gmail.com", "78512457", "Rua Campinas 10 bela vista Franca",  "933000782");
        Cliente cliente7 = new Cliente(7, "Maria Eduarda", 'F', "25/03/1993", "302121292", "Maria@gmail.com", "4658237314", "Rua Timbo 215 fortaleza NH",  "93352012");
        Cliente cliente8 = new Cliente(8, "Larrisa lima ", 'F', "04/03/1990", "302121451", "Larissa@gmail.com", "8475123687", "Rua Brusque 32 centro NH",  "93333747");
        Cliente cliente9 = new Cliente(9, "Pedro Carlos", 'M', "09/02/1998", "302121189", "Pedro@gmail.com", "74595142487", "Rua Ilhota 12 centro  NH",  "9330046364");
        Cliente cliente10 = new Cliente(10, "Elian Luis", 'M', "12/06/1999", "3021212478", "elian@gmail.com", "845713647", "Rua Flores 1023 margem esquerda NH",  "933000874");
        
        Servico servico1 = new Servico(1, "Consulta", 18);
        Servico servico3 = new Servico(3, "tratamento", 15);
        Servico servico2 = new Servico(2, " ;| ", 15);
        Servico servico4 = new Servico(4, "Consulta  e tratamento", 25);
        Servico servico5 = new Servico(5, "Cirurgia", 10);
        Servico servico6 = new Servico(6, "pos-tratamento", 3);

        Agendamento agendamento1 = new Agendamento(1, cliente1, servico2, 30, "17/05/2023 09:30");
        Agendamento agendamento2 = new Agendamento(2, cliente3, servico4, 40, "14/12/2023 10:00");
        Agendamento agendamento3 = new Agendamento(3, cliente4, servico1, 18, "13/12/2023 10:30");
        
        //Adiciona Elementos na lista
        usuario.add(usuario1);
        usuario.add(usuario2);
        
        cliente.add(cliente1);
        cliente.add(cliente2);
        cliente.add(cliente3);
        cliente.add(cliente4);
        cliente.add(cliente5);
        cliente.add(cliente6);
        cliente.add(cliente7);
        cliente.add(cliente8);
        cliente.add(cliente9);
        cliente.add(cliente10);
        
        servico.add(servico1);
        servico.add(servico2);
        servico.add(servico3);
        servico.add(servico4);
        servico.add(servico5);
        servico.add(servico6);
        
        agendamento.add(agendamento1);
        agendamento.add(agendamento2);
        agendamento.add(agendamento3);
        
    }
    
    
}
