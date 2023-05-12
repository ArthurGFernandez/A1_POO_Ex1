package program;
import entities.Agenda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Agenda> agendas = new ArrayList<>();

        int inputValido = 0;
        int n;

        do {
            System.out.print("Quantas pessoas deseja adicionar a agenda? ");
            n = sc.nextInt();

            if(n > 0 && n < 11){
                inputValido = 1;
            }else System.out.print("Quantidade de pessoas deve ser superior a 0 e menor do que 10.");

        }while(inputValido == 0);

        for(int i = 0; i < n; i ++){
            System.out.print("\nDigite o nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Digite a idade: ");
            int idade = sc.nextInt();
            System.out.print("Digite a altura: ");
            float altura = sc.nextFloat();

            agendas.add(new Agenda(nome, idade, altura));

        }

        int i = 0;
        for (Agenda agenda1: agendas) {
            System.out.println("\nEste é o " + (i+1) + "º Da Agenda");
            System.out.println(agenda1.getNome());
            System.out.println(agenda1.getIdade());
            System.out.println(agenda1.getAltura());
            i++;
        }

        System.out.print("Digite um nome para remover da agenda: ");
        sc.nextLine();
        String removePessoa = sc.nextLine();
        Iterator<Agenda> iter = agendas.iterator();
        boolean pessoaRemovida = false;
        while (iter.hasNext()) {
            Agenda agenda = iter.next();
            if (agenda.getNome().equals(removePessoa)) {
                iter.remove();
                System.out.println("Pessoa removida da agenda.");
                pessoaRemovida = true;
            }
        }
        if(!pessoaRemovida) System.out.println("Pessoa não encontrada");


        i = 0;
        for (Agenda agenda: agendas) {
            System.out.println("\nEste é o " + (i+1) + "º Da Agenda");
            System.out.println(agenda.getNome());
            System.out.println(agenda.getIdade());
            System.out.println(agenda.getAltura());
            i++;
        }

        System.out.println("Qual nome gostaria de saber o indice na agenda? ");
        String buscaPessoa = sc.nextLine();
        boolean pessoaEncontrada = false;
        for (Agenda agenda : agendas) {
            if (agenda.getNome().equals(buscaPessoa)) {
                System.out.println("Numero do indice na agenda: " + agendas.indexOf(agenda));
                pessoaEncontrada = true;
                break;
            }
        }
        if (!pessoaEncontrada) {
            System.out.println("Pessoa não encontrada na agenda.");
        }

        System.out.print("\nAqui estão todos os dados da agenda até agora: ");
        i = 0;
        for (Agenda agenda: agendas) {
            System.out.println("\nEste é o " + (i+1) + "º Da Agenda");
            System.out.println(agenda.getNome());
            System.out.println(agenda.getIdade());
            System.out.println(agenda.getAltura());
            i++;
        }

        System.out.print("Escolha um indice na agenda para ver seus dados ");
        int imprimePessoa = sc.nextInt();
        if (imprimePessoa >= 0 && imprimePessoa < agendas.size()) {
            Agenda pessoaEscolhida = agendas.get((imprimePessoa));
            System.out.println("\nDados da pessoa escolhida:");
            System.out.println("Nome: " + pessoaEscolhida.getNome());
            System.out.println("Idade: " + pessoaEscolhida.getIdade());
            System.out.println("Altura: " + pessoaEscolhida.getAltura());
        } else {
            System.out.println("Índice inválido.");
        }
    }
}