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
    } else {
        veiculos.add(veiculo);
    }
}

void listar() {
    for (int i = 1; i <= veiculos.size(); i++) {
        IO.println(i + " - " + veiculos.get(i - 1));
    }
}

void excluir () {
    listar();
    int indice = input.scanInt("Digite o índice do veículo");
    if (indice > veiculos.size() || indice <= 0)
        IO.println("Veículo não encontrado");
    else {
        veiculos.remove(indice - 1);
        IO.println("Veículo removido com sucesso");
    }

}