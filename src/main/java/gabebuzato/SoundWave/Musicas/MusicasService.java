package gabebuzato.SoundWave.Musicas;

import gabebuzato.SoundWave.exceptions.RecursoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

public class MusicasService {

    private final MusicasRepository musicasRepository;
    private final MusicasMapper musicasMapper;

    public MusicasService(MusicasRepository musicasRepository, MusicasMapper musicasMapper ) {
        this.musicasRepository = musicasRepository;
        this.musicasMapper = musicasMapper;
    }


    public MusicasDTO listarMusicaPorId(Long id) {
        Optional<MusicaModel> musica = musicasRepository.findById(id);
        return musicasRepository.findById(id)
                .map(musicasMapper::map)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Música com ID " + id + " não encontrada"));
    }

    public MusicasDTO adicionarMusica(MusicasDTO musicasDTO) {
        MusicaModel novaMusica = musicasMapper.map(musicasDTO);
        musicasRepository.save(novaMusica);
        return musicasMapper.map(novaMusica);
    }

    public MusicasDTO atualizarMusica(Long id, MusicasDTO musica) {
        Optional<MusicaModel> musicaExistente = musicasRepository.findById(id);
        if (musicaExistente.isPresent()) {
            MusicaModel musicaAtualizada = musicasMapper.map(musica);
            musicaAtualizada.setId(id);
            MusicaModel musicaSalva = musicasRepository.save(musicaAtualizada);
            return musicasMapper.map(musicaSalva);
        }
        return null;
    }


    public void deletarMusica(Long id) {
        musicasRepository.deleteById(id);
    }
}
