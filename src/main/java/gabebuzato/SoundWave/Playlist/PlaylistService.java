package gabebuzato.SoundWave.Playlist;

import gabebuzato.SoundWave.Musicas.MusicaModel;
import gabebuzato.SoundWave.Musicas.MusicasRepository;
import gabebuzato.SoundWave.Usuario.UsuarioModel;
import gabebuzato.SoundWave.Usuario.UsuarioRepository;
import gabebuzato.SoundWave.exceptions.RecursoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistMapper playlistMapper;
    private final PlaylistRepository playlistRepository;
    private final MusicasRepository musicasRepository;
    private final UsuarioRepository usuarioRepository;

    public PlaylistService(PlaylistMapper playlistMapper,
                           PlaylistRepository playlistRepository,
                           MusicasRepository musicasRepository,
                           UsuarioRepository usuarioRepository) {
        this.playlistMapper = playlistMapper;
        this.playlistRepository = playlistRepository;
        this.musicasRepository = musicasRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<PlaylistDTO> getAllPlaylists() {
        return playlistRepository.findAll()
                .stream()
                .map(playlistMapper::map)
                .toList();
    }

    public PlaylistDTO getPlaylistById(Long id) {
        return playlistRepository.findById(id)
                .map(playlistMapper::map)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Playlist com ID " + id + " não encontrada"));
    }

    public PlaylistDTO adicionarPlaylist(PlaylistDTO playlistDTO) {
        PlaylistModel novaPlaylist = playlistMapper.map(playlistDTO);
        return playlistMapper.map(playlistRepository.save(novaPlaylist));
    }

    public PlaylistDTO adicionarMusica(Long playlistId, Long musicaId) {
        PlaylistModel playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Playlist com ID " + playlistId + " não encontrada"));

        MusicaModel musica = musicasRepository.findById(musicaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Música com ID " + musicaId + " não encontrada"));

        playlist.getMusicas().add(musica);
        return playlistMapper.map(playlistRepository.save(playlist));
    }

    public PlaylistDTO removerMusica(Long playlistId, Long musicaId) {
        PlaylistModel playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Playlist com ID " + playlistId + " não encontrada"));

        playlist.getMusicas().removeIf(m -> m.getId().equals(musicaId));
        return playlistMapper.map(playlistRepository.save(playlist));
    }

    public PlaylistDTO renomearPlaylist(Long playlistId, String nome) {
        PlaylistModel playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Playlist com ID " + playlistId + " não encontrada"));

        playlist.setNome(nome);
        return playlistMapper.map(playlistRepository.save(playlist));
    }

    public PlaylistDTO adicionarColaborador(Long playlistId, Long colaboradorId) {
        PlaylistModel playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Playlist com ID " + playlistId + " não encontrada"));

        UsuarioModel user = usuarioRepository.findById(colaboradorId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuario com ID " + colaboradorId + " não encontrado"));

        playlist.getColaboradores().add(user);
        return playlistMapper.map(playlistRepository.save(playlist));
    }

    public PlaylistDTO removerColaborador(Long playlistId, Long colaboradorId) {
        PlaylistModel playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Playlist com ID " + playlistId + " não encontrada"));

        playlist.getColaboradores().removeIf(c -> c.getId().equals(colaboradorId));
        return playlistMapper.map(playlistRepository.save(playlist));
    }

    public void deletarPlaylist(Long id) {
        if (!playlistRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Playlist com ID " + id + " não encontrada");
        }
        playlistRepository.deleteById(id);
    }
}