package gabebuzato.SoundWave.Musicas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "tb_musicas")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class MusicaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "artista")
    private String artista;

    @Column(name = "album")
    private String album;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private generos genero;

    @Column(name = "duracao")
    private Double duracao;

    @Column(name = "caminho_arquivo")
    private String caminhoArquivo;

    @Column(updatable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist() {
        this.dataCadastro = LocalDateTime.now();
    }
}
