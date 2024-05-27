public class Suporte extends Funcionario{

    public Suporte(int id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }

    public static Boolean login(String email, String senha){
        Boolean loginRealizado = false;
        if (senha.length() >= 8) {
            // Conexão com banco da dados para login ficará aqui, eu acho ?
            if (email.equals("fernanda.caramico@sptech.school") && senha.equals("C@ramic0")) {
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
