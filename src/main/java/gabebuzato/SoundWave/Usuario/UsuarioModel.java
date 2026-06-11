package gabebuzato.SoundWave.Usuario;

import gabebuzato.SoundWave.Historico.HistoricoModel;
import gabebuzato.SoundWave.Musicas.generos;
import gabebuzato.SoundWave.Playlist.PlaylistModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "senha", nullable = false)
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlaylistModel> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true) //Quando deletat o usuário todos os dados(playlists, histórico) serão deletados juntos automaticamente
    private List<HistoricoModel> historico = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_usuario_generos", joinColumns = @JoinColumn(name = "usuario_id"))
    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private List<generos> generosPreferidos = new ArrayList<>();

    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
    }
}
