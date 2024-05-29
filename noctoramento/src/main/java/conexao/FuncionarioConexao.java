package conexao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import java.sql.SQLException;

public class FuncionarioConexao {

    public Integer contarUsuarioExistente(String email){

        Conexao conexaoMySQL = new Conexao();
        JdbcTemplate con = conexaoMySQL.getConexaoMySql();

        String sql = "SELECT COUNT(*) FROM Usuario WHERE emailUsuario = ?;";

        try {
            Integer countLocal = con.queryForObject(sql, Integer.class, email);
            return countLocal;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            if (con != null){
                try{
                    con.getDataSource().getConnection().close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }

    }

}
