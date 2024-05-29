import conexao.FuncionarioConexao;

public class Funcionario {

    protected int id;
    protected String nome;
    protected String email;
    protected String senha;

    public Funcionario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Boolean funcionarioAlocado(String email){

        Boolean loginRealizado = false;

            // Conexão com banco da dados para sabermos qual usuário está alocado a está máquina

            FuncionarioConexao funcionarioConexao = new FuncionarioConexao();

            Integer usuarioExistentes = funcionarioConexao.contarUsuarioExistente(email);
            if (usuarioExistentes == 1) {
                System.out.println("Usuário alocado");
                loginRealizado = true;
            } else {
                System.out.println("\nEste email de funcionário não existe\n");

            }

        return loginRealizado;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
