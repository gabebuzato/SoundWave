package gabebuzato.SoundWave.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecursoNaoEncontradoException extends RuntimeException {
    public RecursoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
