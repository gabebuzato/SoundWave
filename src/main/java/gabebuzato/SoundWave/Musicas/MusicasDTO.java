package gabebuzato.SoundWave.Musicas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MusicasDTO {
    private Long id;
    private String nome;
    private String artista;
    private String album;
    private generos genero;
    private Double duracao;
    private String caminhoArquivo;
    private LocalDateTime dataCadastro;
}
