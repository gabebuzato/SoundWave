package gabebuzato.SoundWave.Musicas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicas")
public class MusicasController {

    private final MusicasService musicasService;

    public MusicasController(MusicasService musicasService) {
        this.musicasService = musicasService;
    }

    // get /musicas
    @GetMapping("/{id}")
    public ResponseEntity<MusicasDTO> getMusica(@PathVariable Long id) {
        return ResponseEntity.ok(musicasService.listarMusicaPorId(id));
    }

    // post /musicas
    @PostMapping("/adicionar")
    public ResponseEntity<MusicasDTO> adicionarMusica(@RequestBody MusicasDTO musicasDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicasService.adicionarMusica(musicasDTO));
    }

    // put /musicas/{id}
    @PutMapping("/editar/{id}")
    public ResponseEntity<MusicasDTO> editarMusica(@PathVariable Long id, @RequestBody MusicasDTO musicaEditada){
        return ResponseEntity.ok(musicasService.atualizarMusica(id, musicaEditada));
    }

    // delete /musicas/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMusica(@PathVariable Long id){
        musicasService.deletarMusica(id);
        return ResponseEntity.noContent().build();
    }
}
