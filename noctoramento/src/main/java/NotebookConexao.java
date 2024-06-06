import org.springframework.jdbc.core.JdbcTemplate;

public class NotebookConexao {

    Conexao conexaoMySQL = new Conexao();
    JdbcTemplate con = conexaoMySQL.getConexaoMySql();

    

}
