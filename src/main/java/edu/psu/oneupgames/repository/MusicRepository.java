package edu.psu.oneupgames.repository;

import edu.psu.oneupgames.model.Music;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MusicRepository {
    List<Music> getMusics();

    void addMusic(Music music);

    List<Music> searchMusics(String term);

    long findMaxMusicId();

    Music getMusicById(Long musicId);

    void editMusic(Music music, Long musicId, String musicTitle, String musicArtist, String musicDateReleased, Music.Genre musicGenre, String musicNumTracks, String musicPrice);

    void deleteMusic(Long musicId);

}
