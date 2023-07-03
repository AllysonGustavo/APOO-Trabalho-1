// Executar código: sh -c javac -classpath .:target/dependency/* -d . $(find . -type f -name '*.java')
// Aluno: ALLYSON GUSTAVO SILVA DO CARMO
// Matricula: 20210051717
// Aluna: LUANA GABRIELLY PALHANO DE OLIVEIRA SILVA
// Matricula: 20230000232
// Aluno: RENATO PALMIERY DA SILVA CAMPOS
// Matricula: 20190040818
// DIM0504 - ANÁLISE E PROJETO ORIENTADO A OBJETOS - T01 (2023.1 - 24M34)

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cantina {
  static int tipoPedido = 0;
  static int formaPagamento = 0;
  static Scanner scanner = new Scanner(System.in);
  static int choice;
  static ArrayList < String > pedidos = new ArrayList < > ();

  public static void main(String[] args) {
    do {
      clearConsole(); // Limpar o console
      displayMenu();
      choice = scanner.nextInt();
      clearConsole(); // Limpar o console

      switch (choice) {
      case 1:
        fazerPedido();
        break;
      case 2:
        verificarCardapio();
        break;
      case 3:
        alterarPedido();
        break;
      case 4:
        prepararPedido();
        break;
      case 5:
        System.out.println("Saindo do programa...");
        break;
      default:
        System.out.println("Opção inválida. Tente novamente.");
      }
    } while (choice != 5);

    scanner.close();
  }

  public static void displayMenu() {
    System.out.println("====== MENU ======");
    System.out.println("1. Fazer pedido");
    System.out.println("2. Verificar cardápio");
    System.out.println("3. Alterar pedido");
    System.out.println("4. Preparar pedido");
    System.out.println("5. Sair");
    System.out.println("==================");
    System.out.print("Escolha uma opção: ");
  }

  public static void fazerPedido() {
    String choiceCantina = "0";
    String choiceAdicionar;

    System.out.println("Opção selecionada: Fazer pedido");

    do {
      // 1. O cliente escolhe a cantina/refeitório em que deseja pedir.
      System.out.println("==== CANTINAS ====");
      System.out.println("1. Cantina 1");
      System.out.println("2. Cantina 2");
      System.out.println("3. Cantina 3");
      System.out.println("==================");
      System.out.println("0. Voltar ao menu");
      System.out.println("");

      System.out.println("Escolha a cantina/refeitório em que deseja pedir:");
      choiceCantina = scanner.next();
      choiceCantina = verificarOpcao(choiceCantina, "0", "1", "2", "3");
      clearConsole(); // Limpar o console

      if (choiceCantina.equalsIgnoreCase("0")) {
        break; // Volta para o menu
      } else if (choiceCantina.equalsIgnoreCase("1")) {
        System.out.println("Opção selecionada: Cantina 1\n");

        // 3. O cliente escolhe o seu tipo de pedido: padrão(cantina) ou R.U(refeição
        // com desconto para cadastrados no RU) para a cantina/refeitório selecionado.
        System.out.println("1. Padrão (cantina)");
        System.out.println("2. R.U (refeição com desconto para cadastrados no RU)\n");
        System.out.println("Escolha o tipo de pedido:");
        String choicePedido = scanner.next();
        choicePedido = verificarOpcao(choicePedido, "1", "2");

        if (choicePedido.equalsIgnoreCase("1")) {
          clearConsole(); // Limpar o console
          System.out.println("Opção selecionada: Padrão (cantina)\n");
          System.out.println("1. (PF) Frango a milanesa,feijão preto, arroz branco - R$ 10,00");
          System.out.println("2. (PF) Carne de sol, feijão carioca, arroz integral - R$ 20,00");
          System.out.println("3. (PF) Ovo mexido, macarrão parafuso, queijo ralado - R$ 30,00\n");
          System.out.println("Escolha uma opção de refeição:");
          choicePedido = scanner.next();
          choicePedido = verificarOpcao(choicePedido, "1", "2", "3");
          if (choicePedido.equalsIgnoreCase("1")) {
            pedidos.add("(PF) Frango a milanesa,feijão preto, arroz branco - R$ 10,00");
          } else if (choicePedido.equalsIgnoreCase("2")) {
            pedidos.add("(PF) Carne de sol, feijão carioca, arroz integral - R$ 20,00");
          } else if (choicePedido.equalsIgnoreCase("3")) {
            pedidos.add("(PF) Ovo mexido, macarrão parafuso, queijo ralado - R$ 30,00");
          }
          System.out.println("Opção " + choicePedido + " selecionada com sucesso!");
        } else if (choicePedido.equalsIgnoreCase("2")) {
          clearConsole(); // Limpar o console
          System.out.println("Opção selecionada: R.U (refeição com desconto para cadastrados no RU)(10%)\n");
          System.out.println("(PF) Frango a milanesa,feijão preto, arroz branco - R$ 9,00");
          System.out.println("(PF) Carne de sol, feijão carioca, arroz integral - R$ 18,00");
          System.out.println("(PF) Ovo mexido, macarrão parafuso, queijo ralado - R$ 27,00");
          System.out.println("Prato do dia no R.U: Frango cozido, arroz branco, farofa amarela, carne de soja(vegano) - R$ 8,00\n");
          System.out.println("Escolha uma opção de refeição:");
          choicePedido = scanner.next();
          choicePedido = verificarOpcao(choicePedido, "1", "2", "3", "4");
          if (choicePedido.equalsIgnoreCase("1")) {
            pedidos.add("(PF) Frango a milanesa,feijão preto, arroz branco - R$ 9,00");
          } else if (choicePedido.equalsIgnoreCase("2")) {
            pedidos.add("(PF) Carne de sol, feijão carioca, arroz integral - R$ 18,00");
          } else if (choicePedido.equalsIgnoreCase("3")) {
            pedidos.add("(PF) Ovo mexido, macarrão parafuso, queijo ralado - R$ 27,00");
          } else if (choicePedido.equalsIgnoreCase("4")) {
            pedidos.add("Prato do dia no R.U: Frango cozido, arroz branco, farofa amarela, carne de soja(vegano) - R$ 8,00");
          }
          System.out.println("Opção " + choicePedido + " selecionada com sucesso!");
        }
      } else if (choiceCantina.equalsIgnoreCase("2")) {
        System.out.println("Opção selecionada: Cantina 2\n");

        // 3. O cliente escolhe o seu tipo de pedido: padrão(cantina) ou R.U(refeição
        // com desconto para cadastrados no RU) para a cantina/refeitório selecionado.
        System.out.println("1. Padrão (cantina)");
        System.out.println("2. R.U (refeição com desconto para cadastrados no RU)\n");
        System.out.println("Escolha o tipo de pedido:");
        String choicePedido = scanner.next();
        choicePedido = verificarOpcao(choicePedido, "1", "2");
        if (choicePedido.equalsIgnoreCase("1")) {
          clearConsole(); // Limpar o console
          System.out.println("Opção selecionada: Padrão (cantina)\n");
          System.out.println("1. Leite de vaca integral, chocolate em pó - R$ 5,00");
          System.out.println("2. Pão frances, ovo mexido - R$ 7,00");
          System.out.println("3. Frandinha recheada com frango desfiado - R$ 11,00\n");
          System.out.println("Escolha uma opção de refeição:");
          choicePedido = scanner.next();
          choicePedido = verificarOpcao(choicePedido, "1", "2", "3");
          if (choicePedido.equalsIgnoreCase("1")) {
            pedidos.add("Leite de vaca integral, chocolate em pó - R$ 5,00");
          } else if (choicePedido.equalsIgnoreCase("2")) {
            pedidos.add("Pão frances, ovo mexido - R$ 7,00");
          } else if (choicePedido.equalsIgnoreCase("3")) {
            pedidos.add("Frandinha recheada com frango desfiado - R$ 11,00");
          }
          System.out.println("Opção " + choicePedido + " selecionada com sucesso!");
        } else if (choicePedido.equalsIgnoreCase("2")) {
          clearConsole(); // Limpar o console
          System.out.println("Opção selecionada: R.U (refeição com desconto para cadastrados no RU)\n");
          System.out.println("1. Leite de vaca integral, chocolate em pó - R$ 4,50");
          System.out.println("2. Pão frances, ovo mexido - R$ 6,30");
          System.out.println("3. Frandinha recheada com frango desfiado - R$ 9,90");
          System.out.println("4. Prato do dia no R.U: Quejadinha recheada com queijo prato, café preto - R$ 8,00\n");
          System.out.println("Escolha uma opção de refeição:");
          choicePedido = scanner.next();
          choicePedido = verificarOpcao(choicePedido, "1", "2", "3", "4");
          if (choicePedido.equalsIgnoreCase("1")) {
            pedidos.add("Leite de vaca integral, chocolate em pó - R$ 4,50");
          } else if (choicePedido.equalsIgnoreCase("2")) {
            pedidos.add("Pão frances, ovo mexido - R$ 6,30");
          } else if (choicePedido.equalsIgnoreCase("3")) {
            pedidos.add("Frandinha recheada com frango desfiado - R$ 9,90");
          } else if (choicePedido.equalsIgnoreCase("4")) {
            pedidos.add("Prato do dia no R.U: Quejadinha recheada com queijo prato, café preto - R$ 8,00");
          }
          System.out.println("Opção " + choicePedido + " selecionada com sucesso!");
        }
      } else if (choiceCantina.equalsIgnoreCase("3")) {
        System.out.println("Opção selecionada: Cantina 3\n");
        // 3. O cliente escolhe o seu tipo de pedido: padrão(cantina) ou R.U(refeição
        // com desconto para cadastrados no RU) para a cantina/refeitório selecionado.
        System.out.println("1. Padrão (cantina)");
        System.out.println("2. R.U (refeição com desconto para cadastrados no RU)\n");
        System.out.println("Escolha o tipo de pedido:");
        String choicePedido = scanner.next();
        choicePedido = verificarOpcao(choicePedido, "1", "2");

        if (choicePedido.equalsIgnoreCase("1")) {
          clearConsole(); // Limpar o console
          System.out.println("Opção selecionada: Padrão (cantina)\n");
          System.out.println("1. Pão com mortadela - R$ 13,00");
          System.out.println("2. Sopa de carne - R$ 12,00");
          System.out.println("3. Sopa de frango - R$ 9,50\n");
          System.out.println("Escolha uma opção de refeição:");
          choicePedido = scanner.next();
          choicePedido = verificarOpcao(choicePedido, "1", "2", "3");
          if (choicePedido.equalsIgnoreCase("1")) {
            pedidos.add("Pão com mortadela - R$ 13,00");
          } else if (choicePedido.equalsIgnoreCase("2")) {
            pedidos.add("Sopa de carne - R$ 12,00");
          } else if (choicePedido.equalsIgnoreCase("3")) {
            pedidos.add("Sopa de frango - R$ 9,50");
          }
          System.out.println("Opção " + choicePedido + " selecionada com sucesso!");
        } else if (choicePedido.equalsIgnoreCase("2")) {
          clearConsole(); // Limpar o console
          System.out.println("Opção selecionada: R.U (refeição com desconto para cadastrados no RU)\n");
          System.out.println("1. Pão com mortadela - R$ 11,70");
          System.out.println("2. Sopa de carne - R$ 10,80");
          System.out.println("3. Sopa de frango - R$ 8,55");
          System.out.println("4. Prato do dia no R.U: Pão com hamburguer, sopa de carne - R$ 8,00\n");
          System.out.println("Escolha uma opção de refeição:");
          choicePedido = scanner.next();
          choicePedido = verificarOpcao(choicePedido, "1", "2", "3", "4");
          if (choicePedido.equalsIgnoreCase("1")) {
            pedidos.add("Pão com mortadela - R$ 11,70");
          } else if (choicePedido.equalsIgnoreCase("2")) {
            pedidos.add("Sopa de carne - R$ 10,80");
          } else if (choicePedido.equalsIgnoreCase("3")) {
            pedidos.add("Sopa de frango - R$ 8,55");
          } else if (choicePedido.equalsIgnoreCase("4")) {
            pedidos.add("Prato do dia no R.U: Pão com hamburguer, sopa de carne - R$ 8,00");
          }
          System.out.println("Opção " + choicePedido + " selecionada com sucesso!");
        } else {
          clearConsole(); // Limpar o console
          System.out.println("Opção inválida. Tente novamente.");
        }
      }
      // 5. O sistema pergunta se deseja adicionar outro item ao pedido.
      System.out.println("Deseja adicionar outro item ao pedido? (S/N)");
      choiceAdicionar = scanner.next();
      choiceAdicionar = verificarOpcao(choiceAdicionar, "s", "n");

      // 6. Cliente informa que não deseja outro item.
      if (choiceAdicionar.equalsIgnoreCase("N")) {
        clearConsole();
        System.out.println("Opção selecionada: N\n");

        // 7. Sistema pergunta forma de pagamento.
        System.out.println("1. Pix/cartão");
        System.out.println("2. Pagar no momento da retirada\n");
        System.out.println("Escolha a forma de pagamento:");

        String choicePagar = scanner.next();
        choicePagar = verificarOpcao(choicePagar, "1", "2");

        // 8. Cliente escolhe pagar com pix/cartão ou pagar no momento da retirada do pedido.
        if (choicePagar.equalsIgnoreCase("1")) {
          // 9. Se a forma de pagamento for o pix, o sistema gera um código para o pagamento,
          // caso seja cartão, o sistema pergunta se será débito ou crédito,
          // em seguida é solicitado os dados do cartão e depois é feita a validação do mesmo,
          // e caso a opção seja para pagamento no local, o sistema informa a cantina para preparar o pedido do cliente
          System.out.println("1. Pix");
          System.out.println("2. Cartão");
          System.out.println("Escolha a forma de pagamento:");

          choicePagar = scanner.next();
          choicePagar = verificarOpcao(choicePagar, "1", "2");
          if (choicePagar.equalsIgnoreCase("1")) {
            clearConsole();
            // 2a1. Cliente escolhe pagamento via pix
            System.out.println("Opção selecionada: Pagamento via Pix\n");
            // 2a2. O sistema gera o código pix para o cliente pagar
            // 2a3. O sistema aguarda pagamento
            // 2a4. Quando a transferência é feita com sucesso, o sistema informa para a cantina preparar o pedido.
            System.out.println("Pagamento via Pix realizado com sucesso!");
            scanner.nextLine();
            System.out.println("Pressione Enter para voltar ao menu...");
            scanner.nextLine();
          } else if (choicePagar.equalsIgnoreCase("2")) {
            clearConsole();
            // Implemente a lógica para pagamento com cartão
            System.out.println("Opção selecionada: Pagamento com Cartão\n");

            System.out.println("1. Débito");
            System.out.println("2. Crédito");
            System.out.println("Escolha o tipo de cartão:");
            scanner.next();

            choicePagar = verificarOpcao(choicePagar, "1", "2");
            System.out.println("Número do cartão:");
            scanner.next();
            System.out.println("Mês de vencimento do cartão:");
            scanner.next();
            System.out.println("Ano de vencimento do cartão:");
            scanner.next();
            System.out.println("CVV do cartão:");
            scanner.next();

            System.out.println("Pagamento via Cartão realizado com sucesso!");
          }
        } else if (choicePagar.equalsIgnoreCase("2")) {
          clearConsole();
          // Implemente a lógica para pagamento no local
          System.out.println("Opção selecionada: Pagamento no Local\n");
        }
        // 10. Após o pagamento ser confirmado, o sistema informa a cantina para preparar o pedido do cliente.
        // 11. O pedido estando pronto, o cliente recebe um aviso no aplicativo que o seu pedido já está pronto para retirar no local.
        System.out.println("Seu pedido está pronto para retirar no local.");

        break;
      }
      System.out.println("Opção selecionada: S");
      clearConsole(); // Limpar o console

    } while (choiceAdicionar.equalsIgnoreCase("S"));
  }

  public static void verificarCardapio() {
    int choiceCantina = 0;

    System.out.println("Opção selecionada: Verificar Cardápio\n");

    System.out.println("==== VERIFICAR CARDÁPIOS ====");
    System.out.println("1. Cantina 1");
    System.out.println("2. Cantina 2");
    System.out.println("3. Cantina 3");
    System.out.println("==================");
    System.out.println("Escolha a cantina para verificar o cardápio:");

    choiceCantina = scanner.nextInt();
    clearConsole(); // Limpar o console

    switch (choiceCantina) {
    case 1:
      System.out.println("Opção selecionada: Cantina 1\n");
      System.out.println("Cardápio da Cantina 1:\n");
      System.out.println("1. (PF) Frango a milanesa, feijão preto, arroz branco - R$ 10,00");
      System.out.println("2. (PF) Carne de sol, feijão carioca, arroz integral - R$ 20,00");
      System.out.println("3. (PF) Ovo mexido, macarrão parafuso, queijo ralado - R$ 30,00\n");
      break;
    case 2:
      System.out.println("Opção selecionada: Cantina 2\n");
      System.out.println("Cardápio da Cantina 2:\n");
      System.out.println("1. Leite de vaca integral, chocolate em pó - R$ 5,00");
      System.out.println("2. Pão francês, ovo mexido - R$ 7,00");
      System.out.println("3. Fraldinha recheada com frango desfiado - R$ 11,00\n");
      break;
    case 3:
      System.out.println("Opção selecionada: Cantina 3\n");
      System.out.println("Cardápio da Cantina 3:\n");
      System.out.println("1. Pão com mortadela - R$ 13,00");
      System.out.println("2. Sopa de carne - R$ 12,00");
      System.out.println("3. Sopa de frango - R$ 9,50\n");
      break;
    default:
      System.out.println("Opção inválida. Tente novamente.");
      verificarCardapio();
    }

    scanner.nextLine();
    System.out.println("Pressione Enter para voltar ao menu...");
    scanner.nextLine();
  }

  public static float calcularPedido() {
    int total = 0;
    if (pedidos.isEmpty()) {
      System.out.println("Nenhum pedido realizado até o momento.");
    } else {
      System.out.println("Pedido atual:");
      // Imprimir todos os pedidos e calcular valor total
      for (int i = 0; i < pedidos.size(); i++) {
        System.out.println((i + 1) + ". " + pedidos.get(i));
        ArrayList < String > match1 = getRegex(pedidos.get(i));
        String match2 = match1.get(0).replace(",", ".");
        float match = Float.parseFloat(match2);
        total += match;
      }
    }
    return total;
  }

  public static void alterarPedido() {
    System.out.println("Opção selecionada: Alterar pedido");

    if (pedidos.isEmpty()) {
      System.out.println("Não há pedidos para alterar.");
      return;
    }

    System.out.println("Pedidos:");
    for (int i = 0; i < pedidos.size(); i++) {
      System.out.println((i + 1) + ". " + pedidos.get(i));
    }
    System.out.println("\n0. Voltar ao menu.");

    System.out.print("Digite o número do pedido que deseja cancelar: ");
    int numeroPedido = scanner.nextInt();

    if (numeroPedido == 0) {
      System.out.println("Alteração do pedido cancelada.");
      return;
    }

    if (numeroPedido < 1 || numeroPedido > pedidos.size()) {
      System.out.println("Número de pedido inválido.");
      return;
    }

    pedidos.remove(numeroPedido - 1);
    System.out.println("Pedido cancelado com sucesso.");
  }

  public static void prepararPedido() {
    System.out.println("Opção selecionada: Preparar pedido\n");
    float total = calcularPedido();
    scanner.nextLine();
    System.out.println("Total: R$" + total);
    System.out.println("Pedido efetuado. Aguarde a preparação do seu pedido...");
    choice = 5;
    scanner.nextLine();
  }

  public static ArrayList < String > getRegex(String input) {
    String regex = "(\\d+(?:,\\d{2})?)(?!.*\\d)"; // Match entre o primeiro e ultimo número
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    ArrayList < String > matches = new ArrayList < > ();

    while (matcher.find()) {
      matches.add(matcher.group());
    }

    return matches;
  }

  // Método para limpar o console
  public static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  // Método para verificar se o usuario digitou alguma das opções esperadas
  public static String verificarOpcao(String userInput, String...expectedStrings) {
    Scanner scanner = new Scanner(System.in);
    boolean stringFound = false;

    while (!stringFound) {
      for (String expectedString: expectedStrings) {
        if (userInput.equalsIgnoreCase(expectedString)) {
          stringFound = true;
          break;
        }
      }

      if (!stringFound) {
        System.out.println("Opção inválida. Tente novamente.");
        userInput = scanner.nextLine();
      }
    }
    return userInput;
  }

}