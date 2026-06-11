package gabebuzato.SoundWave.Playlist;

import org.springframework.stereotype.Component;

@Component
public class PlaylistMapper {
    public PlaylistModel map(PlaylistDTO playlistDTO) {
        PlaylistModel playlistModel = new PlaylistModel();
        playlistModel.setId(playlistDTO.getId());
        playlistModel.setNome(playlistDTO.getNome());
        playlistModel.setColaboradores(playlistDTO.getColaboradores());
        playlistModel.setUsuario(playlistDTO.getUsuario());
        playlistModel.setDataCriacao(playlistDTO.getDataCriacao());
        return playlistModel;
    }

    public PlaylistDTO map(PlaylistModel playlistModel) {
        PlaylistDTO playlistDTO = new PlaylistDTO();
        playlistDTO.setId(playlistModel.getId());
        playlistDTO.setNome(playlistModel.getNome());
        playlistDTO.setColaboradores(playlistModel.getColaboradores());
        playlistDTO.setUsuario(playlistModel.getUsuario());
        playlistDTO.setDataCriacao(playlistModel.getDataCriacao());
        return playlistDTO;
    }
}
