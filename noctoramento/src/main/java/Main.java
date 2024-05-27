import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {
    public static void main(String[] args) {
        Looca looca = new Looca();
        Scanner input = new Scanner(System.in);
        Sistema sistema = new Sistema();
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
        System.out.println("Seja bem-vindo(a)");

        Boolean loginRealizado = false;
        do {
            System.out.println("Insira seu email:");
            String email = input.nextLine();
            // Variável onde será salvo o email do usuário

            System.out.println("Insira sua senha:");
            String senha = input.nextLine();
            // Variável onde será salva a senha, contendo pelo menos:
            // 8 caractéres, 1 caractere especial, 1 número e uma letra maiúscula

            if (Suporte.login(email, senha)) {
                loginRealizado = true;
            }
        } while (!loginRealizado);
        // Loop do login, fazendo com que o usuário fique "preso" até inserir email e senha cadastrados


        // Suporte suporte = new Suporte();
        // Empresa empresa = new Empresa();
        // Parametros parametros = new Parametros();
        // Notebook notebook = new Notebook();
        // Componente componente = new Componente();

        // Como fazer um insert:
        // con.update("INSERT INTO Cargo VALUES (null, ?)",
                //"teste");

        // String sql = "SELECT * FROM EMPRESA WHERE idEmpresa = 1";


        System.out.println("""
                \nLogin realizado com sucesso!
                \n""");
        do {

            System.out.println(looca.getMemoria());

            //Criação do gerenciador - Discos
            DiscoGrupo grupoDeDiscos = looca.getGrupoDeDiscos();

            //Obtendo lista de discos a partir do getter
            List<Disco> discos = grupoDeDiscos.getDiscos();

            for (Disco disco : discos) {
                System.out.println(disco);
            }

            //Processos
            ProcessoGrupo grupoDeProcessos = looca.getGrupoDeProcessos();


            List<Processo> processos = grupoDeProcessos.getProcessos();

            for (Processo processo : processos) {
                System.out.println(processo.getNome() + processo.getBytesUtilizados());
            }

            Double usoCpu = 0.0;
            Double usoDisco = 0.0;
            Double tempoAtividadeDisco = 0.0;
            Double usoMemoriaRam = 0.0;
            Integer qtdJanelasEmUso = 0;
            Date dtHoraCaptura = null;
            Integer fkNotebook = 0;
            Integer fkEmpresa = 0;

            con.update("INSERT INTO RegistroUsoNotebook VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)",
                    usoCpu, usoDisco, tempoAtividadeDisco, usoMemoriaRam, qtdJanelasEmUso,dtHoraCaptura, fkNotebook, fkEmpresa);

            try {
                TimeUnit.SECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (loginRealizado);



    }
}