import java.util.ArrayList;
import java.util.List;

List<String> veiculos = new ArrayList<>();
void main() {
    IO.println("Bem-vindo ao sistema CadVeículos");

    String menu = """
            MENU DE OPÇÕES
            1 - Cadastrar Veículo
            2 - Listar Veículos
            3 - Remover Veículos
            4 - Buscar Veículo
            0 - Sair
            """;
    
    int opcao;

    do {
        IO.println(menu);
        opcao = input.scanInt("Digite a opção desejada: ");

        switch (opcao) {
            case 1 -> {
                cadastrar();
                IO.readln("Pressione ENTER para continuar.");
            }
            case 2 -> {
                listar();
                IO.readln("Pressione ENTER para continuar");
            }
            case 3 -> {
                excluir();
                IO.readln("Pressione ENTER para continuar");
            }
            case 4 -> {
                buscarPorNome();
                IO.readln("Pressione ENTER para continuar");
            }
            case 0 -> {
                // TO DO Sair
                IO.println("Volte sempre!!!");
            }
            default -> {
                IO.println("Opção Inválida");
                IO.println("Pressione ENTER para continuar.");
            }
        }
    } while (opcao != 0);
}

void cadastrar() {
    String veiculo = IO.readln("Digite o nome do veículo: ");
    veiculo = veiculo.trim();
    if (veiculo.isEmpty()) {
        IO.println("Nome do veículo inválido.");
    } 
    
    for (String v : veiculos) {
        if (v.equalsIgnoreCase(veiculo)) {
            IO.println("Este veículo já está cadastrado");
            return;
        }
    }
    
    veiculos.add(veiculo);
    
}

void listar() {
    if (veiculos.isEmpty()) {
        IO.println("Lista vazia, não há veículos cadastrados.");
        return;
    }
    
    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }
}

void excluir() {
    listar();
    int indice = input.scanInt("Digite o índice do veículo: ");
    if (indice > veiculos.size() || indice <= 0)
        IO.println("Veículo não encontrado");
    else {
        veiculos.remove(indice - 1);
        IO.println("Veículo removido com sucesso");
    }
}

void buscarPorNome() {
    String nome_busca = IO.readln("Digite o nome do carro que deseja buscar: ");

    if (nome_busca.isEmpty()) {
        IO.println("Nome do veículo inválido.");
        return;
    }

    List<String> temp = new ArrayList<>();
    String buscaLower = nome_busca.toLowerCase();

    for (String v : veiculos) {
        if (v.toLowerCase().contains(buscaLower)) {
            temp.add(v);
        }
    }

    if (temp.isEmpty()) {
        IO.println("Nenhum veículo encontrado.");
    } else {
        IO.println("Veículos encontrados:");
        for (String nome : temp) {
            IO.println(nome);
        }
        IO.println("Número de veículos encontrados: " + temp.size());
    }
}

