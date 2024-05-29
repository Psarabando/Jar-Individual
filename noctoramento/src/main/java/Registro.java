import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import conexao.Conexao;
import org.h2.store.Data;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;


public class Registro {
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoMySql();
    Looca looca = new Looca();
    Sistema sistema = new Sistema();

    private Integer id = 0;
    private Double usoCpu;
    private Double usoDisco;
    private Double tempoAtividadeDisco;
    private Double usoMemoriaRam;
    private Integer qtdJanelasEmUso;
    private Date dtHoraCaptura;

    public Registro() {
    }

    public void capturarDados(Integer fkNotebook, Integer fkEmpresa){

        Double usoCpu = 0.0;
        Double usoDisco = 0.0;
        Double tempoAtividadeDisco = 0.0;
        Double usoMemoriaRam = 0.0;
        Integer qtdJanelasEmUso = 0;
        Date dtHoraCaptura = null;
        Integer fkNotebookInsert = fkNotebook;
        Integer fkEmpresaInsert = fkEmpresa;

        con.update("INSERT INTO RegistroUsoNotebook VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)",
                usoCpu, usoDisco, tempoAtividadeDisco, usoMemoriaRam, qtdJanelasEmUso,dtHoraCaptura, fkNotebookInsert, fkEmpresaInsert);

        // Guardando dados no objeto:

        setId(id++);
        setUsoCpu(usoCpu);
        setUsoDisco(usoDisco);
        setTempoAtividadeDisco(tempoAtividadeDisco);
        setUsoMemoriaRam(usoMemoriaRam);
        setQtdJanelasEmUso(qtdJanelasEmUso);
        setDtHoraCaptura(dtHoraCaptura);

        // Exibição dos dados na tela

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

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUsoCpu() {
        return usoCpu;
    }

    public void setUsoCpu(Double usoCpu) {
        this.usoCpu = usoCpu;
    }

    public Double getUsoDisco() {
        return usoDisco;
    }

    public void setUsoDisco(Double usoDisco) {
        this.usoDisco = usoDisco;
    }

    public Double getTempoAtividadeDisco() {
        return tempoAtividadeDisco;
    }

    public void setTempoAtividadeDisco(Double tempoAtividadeDisco) {
        this.tempoAtividadeDisco = tempoAtividadeDisco;
    }

    public Double getUsoMemoriaRam() {
        return usoMemoriaRam;
    }

    public void setUsoMemoriaRam(Double usoMemoria) {
        this.usoMemoriaRam = usoMemoria;
    }

    public Integer getQtdJanelasEmUso() {
        return qtdJanelasEmUso;
    }

    public void setQtdJanelasEmUso(Integer qtdJanelasEmUso) {
        this.qtdJanelasEmUso = qtdJanelasEmUso;
    }

    public Date getDtHoraCaptura() {
        return dtHoraCaptura;
    }

    public void setDtHoraCaptura(Date dtHoraCaptura) {
        this.dtHoraCaptura = dtHoraCaptura;
    }
}
