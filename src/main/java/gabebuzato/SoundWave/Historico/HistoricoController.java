package gabebuzato.SoundWave.Historico;

import gabebuzato.SoundWave.Musicas.MusicaModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico")
public class HistoricoController {
    // Post /historico
    @PostMapping
    public String adicionarAoHistorico(MusicaModel musica){

    }

    // get /historico?usuarioId
}
