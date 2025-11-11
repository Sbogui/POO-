import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Processo> processos = new ArrayList<>();
            List<Juiz> juizes = new ArrayList<>();
            List<Advogado> advogados = new ArrayList<>();
            
            int opcao;
            
            do {
                System.out.println("\n==== MENU DO SISTEMA JURÍDICO ====");
                System.out.println("1 - Cadastrar Juiz");
                System.out.println("2 - Cadastrar Advogado");
                System.out.println("3 - Cadastrar Processo");
                System.out.println("4 - Listar Processos");
                System.out.println("5 - Adicionar Resolução");
                System.out.println("6 - Excluir Processo");
                System.out.println("7 - Mostrar Todos os Dados");
                System.out.println("8 - Buscar Processo por Nome do Autor");
                System.out.println("0 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();
                
                switch (opcao) {
                    case 1 -> {
                        System.out.println("\n=== Cadastro de Juiz ===");
                        System.out.print("Nome: ");
                        String nomeJ = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endJ = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telJ = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpfJ = sc.nextLine();
                        Boolean duplicado = false;
                        for (Juiz j : juizes) {
                            if (j.getCpf().equals(cpfJ)) {
                                duplicado = true;
                                break;
                            }
                        }
                        if (duplicado) {
                            System.out.println("CPF já cadastrado! Juiz não adicionado.");
                        } else {
                            System.out.print("Registro Judiciário: ");
                            String regJ = sc.nextLine();
                            Juiz juiz = new Juiz(nomeJ, endJ, telJ, cpfJ, regJ);
                            juizes.add(juiz);
                            System.out.println("Juiz cadastrado com sucesso!");
                        }
                    }
                    
                    case 2 -> {
                        System.out.println("\n=== Cadastro de Advogado ===");
                        System.out.print("Nome: ");
                        String nomeA = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endA = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telA = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpfA = sc.nextLine();
                        System.out.print("Número da OAB: ");
                        String oab = sc.nextLine();
                        Boolean duplicado = false;
                        for (Advogado a : advogados) {
                            if (a.getCpf().equals(cpfA) || a.getOab().equals(oab)) {
                                duplicado = true;
                                break;
                            }
                        }
                        if (duplicado) {
                            System.out.println("CPF ou OAB já cadastrado! Advogado não adicionado.");
                        } else {
                        Advogado adv = new Advogado(nomeA, endA, telA, cpfA, oab);
                        advogados.add(adv);
                        System.out.println(" Advogado cadastrado com sucesso!");
                        }
                    }
                    
                    case 3 -> {
                        if (juizes.isEmpty() || advogados.isEmpty()) {
                            System.out.println(" É necessário ter pelo menos um juiz e um advogado cadastrados antes de criar um processo.");
                            break;
                        }
                        
                        System.out.println("\n=== Cadastro de Processo ===");
                        System.out.print("Nome do autor: ");
                        String nomeAutor = sc.nextLine();
                        System.out.print("CPF do autor: ");
                        String cpfAutor = sc.nextLine();
                        PessoaFisica autor = new PessoaFisica(nomeAutor, "Endereço não informado", "0000-0000", cpfAutor);
                        
                        System.out.print("Nome do réu: ");
                        String nomeReu = sc.nextLine();
                        System.out.print("CPF do réu: ");
                        String cpfReu = sc.nextLine();
                        PessoaFisica reu = new PessoaFisica(nomeReu, "Endereço não informado", "0000-0000", cpfReu);
                        
                        System.out.println("\nSelecione o advogado (índice):");
                        for (int i = 0; i < advogados.size(); i++) {
                            System.out.println(i + " - " + advogados.get(i).getNome());
                        }
                        int idxAdv = sc.nextInt();
                        sc.nextLine();
                        
                        System.out.println("Selecione o juiz (índice):");
                        for (int i = 0; i < juizes.size(); i++) {
                            System.out.println(i + " - " + juizes.get(i).getNome());
                        }
                        int idxJuiz = sc.nextInt();
                        sc.nextLine();
                        
                        int numeroProcesso = processos.size() + 1;
                        Processo proc = new Processo(numeroProcesso, autor, reu, advogados.get(idxAdv), juizes.get(idxJuiz));
                        processos.add(proc);
                        System.out.println(" Processo cadastrado com sucesso!");
                    }
                    
                    case 4 -> {
                        System.out.println("\n=== Lista de Processos ===");
                        if (processos.isEmpty()) {
                            System.out.println("Nenhum processo cadastrado.");
                        } else {
                            for (Processo p : processos) {
                                System.out.println("\n" + p);
                            }
                        }
                    }
                    
                    case 5 -> {
                        System.out.print("Digite o número do processo para adicionar resolução: ");
                        int num = sc.nextInt(); sc.nextLine();
                        Processo encontrado = null;
                        for (Processo p : processos) {
                            if (p.getNumero() == num) {
                                encontrado = p;
                                break;
                            }
                        }
                        if (encontrado != null) {
                            System.out.print("Digite o texto da resolução: ");
                            String texto = sc.nextLine();
                            Resolucao resolucao = new Resolucao(texto);
                            encontrado.setResolucao(resolucao);
                            System.out.println(" Resolução adicionada ao processo!");
                        } else {
                            System.out.println(" Processo não encontrado.");
                        }
                    }
                    
                    case 6 -> {
                        System.out.print("Digite o número do processo que deseja excluir: ");
                        int numeroExcluir = sc.nextInt();
                        sc.nextLine();
                        Processo remover = null;
                        for (Processo p : processos) {
                            if (p.getNumero() == numeroExcluir) {
                                remover = p;
                                break;
                            }
                        }
                        if (remover != null) {
                            processos.remove(remover);
                            System.out.println(" Processo removido com sucesso!");
                        } else {
                            System.out.println(" Processo não encontrado.");
                        }
                    }
                    
                    case 7 -> {
                        System.out.println("\n=== DADOS GERAIS DO SISTEMA ===");
                        
                        System.out.println("\n--- Juízes Cadastrados ---");
                        if (juizes.isEmpty()) System.out.println("Nenhum juiz cadastrado.");
                        else juizes.forEach(j -> System.out.println(j));
                        
                        System.out.println("\n--- Advogados Cadastrados ---");
                        if (advogados.isEmpty()) System.out.println("Nenhum advogado cadastrado.");
                        else advogados.forEach(a -> System.out.println(a));
                        
                        System.out.println("\n--- Processos Cadastrados ---");
                        if (processos.isEmpty()) System.out.println("Nenhum processo cadastrado.");
                        else processos.forEach(p -> System.out.println("\n" + p));
                    }
                    
                    case 8 -> {
                        System.out.println("\n=== Buscar Processo por Nome do Autor ===");
                        if (processos.isEmpty()) {
                            System.out.println("Nenhum processo cadastrado.");
                            break;
                        }
                        System.out.print("Digite o Nome do Autor (ou parte dele): ");
                        String nomeBusca = sc.nextLine();
                        if (nomeBusca.trim().isEmpty()) {
                            System.out.println("Nome inválido. Tente novamente.");
                            break;
                        }
                        boolean encontrado = false;
                        for (Processo p : processos) {
                            if (p.getAutor().getNome().toLowerCase().contains(nomeBusca.toLowerCase())) {
                                System.out.println(p);  // Imprime o processo completo
                                encontrado = true;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Nenhum processo encontrado com esse nome.");
                        }
                    }

                    case 0 -> System.out.println("Encerrando o sistema...");
                    
                    default -> System.out.println(" Opção inválida!");
                }
                
            } while (opcao != 0);
        }
    }
}
