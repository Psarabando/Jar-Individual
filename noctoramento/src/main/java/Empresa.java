import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Empresa {

    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoMySql();

    private Integer id;
    private String razaoSocial;
    private String cnpj;
    private Parametros parametros;
    private List<Funcionario> funcionarios;

    public Empresa(Integer id, String razaoSocial, String cnpj, Parametros parametros, List<Funcionario> funcionarios) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.parametros = parametros;
        this.funcionarios = funcionarios;
    }

    public Empresa(Integer id){
        this.id = id;
    }

    public void registrarEmpresa(){

        EmpresaConexao empresaConexao = new EmpresaConexao();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Parametros getParametros() {
        return parametros;
    }

    public void setParametros(Parametros parametros) {
        this.parametros = parametros;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
