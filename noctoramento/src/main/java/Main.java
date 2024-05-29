import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import conexao.Conexao;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Sistema sistema = new Sistema();
        Scanner input = new Scanner(System.in);
        Conexao conexao = new Conexao();
        JdbcTemplate con = conexao.getConexaoMySql();


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
        Suporte suporte = null;

        do {
            System.out.println("Insira seu email:");
            String email = input.nextLine();
            // Variável onde será salvo o email do usuário

            System.out.println("Insira sua senha:");
            String senha = input.nextLine();
            // Variável onde será salva a senha, contendo pelo menos:
            // 8 caractéres, 1 caractere especial, 1 número e uma letra maiúscula

            if (suporte.login(email, senha)) {
                loginRealizado = true;
            }
        } while (!loginRealizado);
        // Loop do login, fazendo com que o usuário fique "preso" até inserir email e senha cadastrados

        System.out.println("""
                \nLogin realizado com sucesso!
                \n""");

        Empresa empresa = null;
        empresa.registrarEmpresa();

        Boolean funcionarioVerificado = false;
        Funcionario funcionario = null;

        do {
            System.out.println("Insira o email do funcionário alocado a esta máquina:");
            String emailFuncionario = input.nextLine();

            // Select que verifica se o email existe na empresa

                if (funcionario.funcionarioAlocado(emailFuncionario)){
                    funcionarioVerificado = true;
                }

        } while (!funcionarioVerificado);

        // Select que trará o número de série do notebook alocado ao usuário citado anteriormente:

        System.out.println("""
                \nFuncionário nomeFuncionario alocado com o Notebook numeroSerie 
                
                Iremos iniciar o monitoramento
                \n""");

        //Notebook notebook = new Notebook();
        //Parametros parametros = new Parametros();
        Registro registro = new Registro();

        InfoNotebook infoNotebook = new InfoNotebook();
        infoNotebook.capturarInformacoesNotebook(1, 1);

        do {
            registro.capturarDados(1, 1);

            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (loginRealizado);



    }
}