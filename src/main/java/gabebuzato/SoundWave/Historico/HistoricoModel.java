package gabebuzato.SoundWave.Historico;

import gabebuzato.SoundWave.Musicas.MusicaModel;
import gabebuzato.SoundWave.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "tb_historico")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class HistoricoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "musica_id")
    private MusicaModel musica;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    private LocalDateTime timestamp;

    private Double percentualOuvido;
}