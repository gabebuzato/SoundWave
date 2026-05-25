package gabebuzato.SoundWave.Playlist;

import gabebuzato.SoundWave.Musicas.MusicaModel;
import gabebuzato.SoundWave.Usuario.UsuarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table (name = "tb_playlists")
public class PlaylistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column
    private List<MusicaModel> musica = new ArrayList<>();

    @Column
    private double tempoTotal;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioModel usuario;

    @ManyToMany
    @JoinTable (
    name = "tb_playlist_musicas",
    joinColumns = @JoinColumn(name = "playlist_id"),
    inverseJoinColumns = @JoinColumn(name = "musica_id")
    )
    private List<MusicaModel> musicas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "tb_playlist_colaboradores",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<UsuarioModel> colaboradores = new ArrayList<>();

    @Column(updatable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }

    public double getTempoTotal() {
        return musicas.stream()
                .mapToDouble(MusicaModel::getDuracao)
                .sum(); // soma a duração de todas as músicas para ser exibida pelo service
    }

}
