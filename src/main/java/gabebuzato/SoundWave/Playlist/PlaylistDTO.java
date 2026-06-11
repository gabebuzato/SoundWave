package gabebuzato.SoundWave.Playlist;

import gabebuzato.SoundWave.Musicas.MusicaModel;
import gabebuzato.SoundWave.Usuario.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String caminhoArquivo;
    private LocalDateTime dataCriacao;
    private List<MusicaModel> musicas;
    private UsuarioModel usuario;
    private List<UsuarioModel> colaboradores;
}
