import gabebuzato.SoundWave.Playlist.PlaylistDTO;
import gabebuzato.SoundWave.Playlist.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping
    public ResponseEntity<List<PlaylistDTO>> listarPlaylists() {
        return ResponseEntity.ok(playlistService.getAllPlaylists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistDTO> acessarPlaylist(@PathVariable Long id) {
        return ResponseEntity.ok(playlistService.getPlaylistById(id));
    }

    @PostMapping
    public ResponseEntity<PlaylistDTO> adicionarPlaylist(@RequestBody PlaylistDTO playlistDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playlistService.adicionarPlaylist(playlistDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlaylistDTO> renomearPlaylist(@PathVariable Long id, @RequestBody String nome) {
        return ResponseEntity.ok(playlistService.renomearPlaylist(id, nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerPlaylist(@PathVariable Long id) {
        playlistService.deletarPlaylist(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/musicas/{musicaId}")
    public ResponseEntity<PlaylistDTO> adicionarMusica(@PathVariable Long id, @PathVariable Long musicaId) {
        return ResponseEntity.ok(playlistService.adicionarMusica(id, musicaId));
    }

    @DeleteMapping("/{id}/musicas/{musicaId}")
    public ResponseEntity<Void> removerMusica(@PathVariable Long id, @PathVariable Long musicaId) {
        playlistService.removerMusica(id, musicaId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/colaboradores/{usuarioId}")
    public ResponseEntity<PlaylistDTO> adicionarColaborador(@PathVariable Long id, @PathVariable Long usuarioId) {
        return ResponseEntity.ok(playlistService.adicionarColaborador(id, usuarioId));
    }

    @DeleteMapping("/{id}/colaboradores/{usuarioId}")
    public ResponseEntity<Void> removerColaborador(@PathVariable Long id, @PathVariable Long usuarioId) {
        playlistService.removerColaborador(id, usuarioId);
        return ResponseEntity.noContent().build();
    }
}