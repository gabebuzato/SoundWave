package gabebuzato.SoundWave.Musicas;

import org.springframework.stereotype.Component;

@Component
public class MusicasMapper {

    public MusicaModel map(MusicasDTO musicasDTO) {
        MusicaModel musicaModel = new MusicaModel();
        musicaModel.setId(musicasDTO.getId());
        musicaModel.setNome(musicasDTO.getNome());
        musicaModel.setDuracao(musicasDTO.getDuracao());
        musicaModel.setArtista(musicasDTO.getArtista());
        musicaModel.setAlbum(musicasDTO.getAlbum());
        musicaModel.setDuracao(musicasDTO.getDuracao());
        musicaModel.setGenero(musicasDTO.getGenero());
        musicaModel.setCaminhoArquivo(musicasDTO.getCaminhoArquivo());
        musicaModel.setDataCadastro(musicasDTO.getDataCadastro());
        return musicaModel;
    }

    public MusicasDTO map(MusicaModel musicaModel) {
        MusicasDTO musicasDTO = new MusicasDTO();
        musicasDTO.setId(musicaModel.getId());
        musicasDTO.setNome(musicaModel.getNome());
        musicasDTO.setDuracao(musicaModel.getDuracao());
        musicasDTO.setArtista(musicaModel.getArtista());
        musicasDTO.setAlbum(musicaModel.getAlbum());
        musicasDTO.setDuracao(musicaModel.getDuracao());
        musicasDTO.setGenero(musicaModel.getGenero());
        musicasDTO.setCaminhoArquivo(musicaModel.getCaminhoArquivo());
        musicasDTO.setDataCadastro(musicaModel.getDataCadastro());
        return musicasDTO;
    }
}
