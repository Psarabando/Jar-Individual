import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Sistema sistema = new Sistema();
        Scanner input = new Scanner(System.in);
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoMySql();
        SuporteConexao suporteConexao = new SuporteConexao();
        NotebookConexao notebookConexao = new NotebookConexao();


        System.out.println("╭━╮╱╭╮╱╱╱╱╱╱╱╱╱╭╮╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╭╮╱╱╱╱╱\n" +
                "┃┃╰╮┃┃╱╱╱╱╱╱╱╱╭╯╰╮╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╭╯╰╮╱╱╱╱\n" +
                "┃╭╮╰╯┃╭━━╮╭━━╮╰╮╭╯╭━━╮╭━╮╭━━╮╭╮╭╮╭━━╮╭━━╮╰╮╭╯╭━━╮\n" +
                "┃┃╰╮┃┃┃╭╮┃┃╭━╯╱┃┃╱┃╭╮┃┃╭╯┃╭╮┃┃╰╯┃┃┃━┫┃╭╮┃╱┃┃╱┃╭╮┃\n" +
                "┃┃╱┃┃┃┃╰╯┃┃╰━╮╱┃╰╮┃╰╯┃┃┃╱┃╭╮┃┃┃┃┃┃┃━┫┃┃┃┃╱┃╰╮┃╰╯┃\n" +
                "╰╯╱╰━╯╰━━╯╰━━╯╱╰━╯╰━━╯╰╯╱╰╯╰╯╰┻┻╯╰━━╯╰╯╰╯╱╰━╯╰━━╯\n" +
                "╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱\n" +
                "╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱");
        System.out.println("\nSeja bem-vindo(a)\n");

        Boolean loginRealizado = false;
        Suporte suporte = new Suporte();

        String email;
        String senha;

        do {
            System.out.println("Insira seu email:");
            email = input.nextLine();
            // Variável onde será salvo o email do usuário

            System.out.println("Insira sua senha:");
            senha = input.nextLine();
            // Variável onde será salva a senha, contendo pelo menos:
            // 8 caractéres, 1 caractere especial, 1 número e uma letra maiúscula

            if (suporte.login(email, senha)) {
                loginRealizado = true;
            }
        } while (!loginRealizado);
        // Loop do login, fazendo com que o usuário fique "preso" até inserir email e senha cadastrados

        System.out.println("""
                \nLogin realizado com sucesso!
                """);



        // Criação da empresa, para conseguirmos pegar dados de outros objetos
        Integer idEmpresa = suporte.buscarEmpresa(email, senha);
        Empresa empresa = suporteConexao.cadastrarEmpresa(idEmpresa);


        Boolean funcionarioVerificado = false;
        Funcionario funcionario = new Funcionario();

        String emailFuncionario;

        do {
            System.out.println("Insira o email do funcionário alocado a esta máquina:");
            emailFuncionario = input.nextLine();

            // Select que verifica se o email existe na empresa

                if (funcionario.funcionarioAlocado(emailFuncionario)){
                    funcionarioVerificado = true;
                }

        } while (!funcionarioVerificado);

        // Select que trará o número de série do notebook alocado ao usuário citado anteriormente:

        funcionario.cadastrarFuncionario(emailFuncionario);

        Integer idNotebook = funcionario.buscarNotebook(funcionario.getId(), empresa.getIdEmpresa());
        Notebook notebook = notebookConexao.cadastrarNotebook(idNotebook);

        InfoNotebook infoNotebook = new InfoNotebook();
        infoNotebook.capturarInformacoesNotebook(notebook.getIdNotebook(), empresa.getIdEmpresa());

        System.out.println("""
                \nIremos iniciar o monitoramento
                \n""");

        Registro registro = new Registro();
        ParametrosConexao parametrosConexao = new ParametrosConexao();
        Parametros parametros = parametrosConexao.capturarParametros(empresa.getIdEmpresa());

        do {
            registro.capturarDados(notebook.getIdNotebook(), empresa.getIdEmpresa());
            parametros.alertar(registro.getUsoCpu(), registro.getUsoDisco(), registro.getUsoMemoriaRam());

            try {
                TimeUnit.SECONDS.sleep(parametros.getTempoSegCapturaDeDados());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (loginRealizado);



    }
}