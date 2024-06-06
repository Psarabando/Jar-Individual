import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscoGrupo;
import com.github.britooo.looca.api.group.discos.Volume;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.util.Conversor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;


public class Registro {
    Conexao conexao = new Conexao();
    JdbcTemplate con = conexao.getConexaoMySql();
    Looca looca = new Looca();
    Sistema sistema = new Sistema();
    LocalDateTime dataHora = LocalDateTime.now();

    private Integer id = 0;
    private Double usoCpu;
    private Double usoDisco;
    private String tempoAtividadeDisco;
    private Double usoMemoriaRam;
    private Integer qtdJanelasEmUso;
    private LocalDateTime dtHoraCaptura;

    public Registro() {
    }

    public void capturarDados(Integer fkNotebook, Integer fkEmpresa){

        double usoCpu = Math.round(looca.getProcessador().getUso()); // "%.0f".formatted(looca.getProcessador().getUso());
        double usoDisco = 0.0;
        String tempoAtividadeDisco = (Conversor.formatarSegundosDecorridos(sistema.getTempoDeAtividade()));
        double usoMemoriaRam = Math.round(Double.valueOf(looca.getMemoria().getEmUso())/ Math.pow(1024,3)); //
        Integer qtdJanelasEmUso = looca.getGrupoDeJanelas().getTotalJanelas();
        LocalDateTime dtHoraCaptura = dataHora;
        Integer fkNotebookInsert = fkNotebook;
        Integer fkEmpresaInsert = fkEmpresa;

        List<Disco> discos = looca.getGrupoDeDiscos().getDiscos();
        List<Volume> volumes = looca.getGrupoDeDiscos().getVolumes();

        for (int i = 0; i < volumes.size(); i++){
            Double totalMemoria = volumes.get(i).getTotal() / Math.pow(1024,3);
            Double discoDisponivel = volumes.get(i).getDisponivel() / Math.pow(1024,3);
            Double totalDisco = discos.get(i).getTamanho() / Math.pow(1024,3);

            usoDisco = Math.round(((((totalMemoria - discoDisponivel) * 100) / totalMemoria)));

        }

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

        for (Disco disco : discos) {
            System.out.println(disco);
        }

        System.out.println("Total de janelas em uso:");
        System.out.println(looca.getGrupoDeJanelas().getTotalJanelas());

        //Processos
        System.out.println("aqui 2");
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

    public String getTempoAtividadeDisco() {
        return tempoAtividadeDisco;
    }

    public void setTempoAtividadeDisco(String tempoAtividadeDisco) {
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

    public LocalDateTime getDtHoraCaptura() {
        return dtHoraCaptura;
    }

    public void setDtHoraCaptura(LocalDateTime dtHoraCaptura) {
        this.dtHoraCaptura = dtHoraCaptura;
    }
}
