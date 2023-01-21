package edu.psu.oneupgames.service;

import edu.psu.oneupgames.model.Music;
import org.springframework.ui.Model;

import java.util.List;

public interface MusicService {
    List<Music> getMusics();

    List<Music> searchMusics(String term);

    void addMusic(String musicTitle, String musicArtist, String musicDateReleased, Music.Genre musicGenre, String musicNumTracks, String musicPrice);

    Music getMusicById(Long gameId);

    void editMusic(Long musicId, String musicTitle, String musicArtist, String musicDateReleased, Music.Genre musicGenre, String musicNumTracks, String musicPrice);

    void deleteMusic(Long musicId);
}
