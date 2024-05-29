import conexao.SuporteConexao;

public class Suporte extends Funcionario{

    public Suporte(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    public Boolean login(String email, String senha){
        Boolean loginRealizado = false;
        if (senha.length() >= 8) {

            // Conexão com banco da dados para login
            SuporteConexao suporteConexao = new SuporteConexao();

            Integer usuarioExistentes = suporteConexao.contarUsuarioExistente(email, senha);

            if (usuarioExistentes == 1) {
                System.out.println("Login bem-sucedido");
                loginRealizado = true;
            } else {
                System.out.println("\nEmail e/ou senha incorretos, tente novamente\n");
            }

        } else {
            System.out.println("\nSenha não cadastrada\n");
        }
        return loginRealizado;
    }

}
