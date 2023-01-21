package edu.psu.oneupgames.service.impl;

import edu.psu.oneupgames.model.Music;
import edu.psu.oneupgames.repository.MusicRepository;
import edu.psu.oneupgames.service.MusicService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    public MusicServiceImpl(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public List<Music> getMusics() {
        return musicRepository.getMusics();
    }

    @Override
    public List<Music> searchMusics(String term) {
        if (! StringUtils.hasText(term)) {
            throw new IllegalArgumentException("term can't be empty");
        }
        return musicRepository.searchMusics(term);
    }

    @Override
    public void addMusic(String musicTitle, String musicArtist, String musicDateReleased, Music.Genre musicGenre, String musicNumTracks, String musicPrice) {
        if (! StringUtils.hasText(musicTitle)) {
            throw new IllegalArgumentException("music title is required");
        }
        if (! StringUtils.hasText(musicArtist)) {
            throw new IllegalArgumentException("music artist is required");
        }
        if (! StringUtils.hasText(musicDateReleased)) {
            throw new IllegalArgumentException("music date released is required");
        }
//        if (! StringUtils.hasText(musicGenre)) {                                       TODO genre has text
//            throw new IllegalArgumentException("music genre is required");
//        }
        if (! StringUtils.hasText(musicNumTracks)) {
            throw new IllegalArgumentException("music date released is required");
        }
        if (! StringUtils.hasText(musicPrice)) {
            throw new IllegalArgumentException("music date released is required");
        }

        int numTracks;
        double price;
        try {
            numTracks = Integer.parseInt(musicNumTracks);
            price = Double.parseDouble(musicPrice);
        } catch (Exception exception) {
            throw new IllegalArgumentException("unable to parse the price and numTracks");
        }
        long musicId = musicRepository.findMaxMusicId();

        var music = new Music(musicTitle, musicArtist, musicDateReleased, musicGenre, numTracks, price);
        musicRepository.addMusic(music);
    }

    @Override
    public Music getMusicById(Long musicId) {
        if (musicId == null || musicId <=0) {
            throw new IllegalArgumentException("game ID is required");
        }

        return musicRepository.getMusicById(musicId);
    }

    @Override
    public void editMusic(Long musicId, String musicTitle, String musicArtist, String musicDateReleased, Music.Genre musicGenre, String musicNumTracks, String musicPrice) {
        var music = musicRepository.getMusicById(musicId);
        if (music == null) {
            throw new IllegalArgumentException("Music not found");
        }
        musicRepository.editMusic(music, musicId, musicTitle, musicArtist, musicDateReleased, musicGenre, musicNumTracks, musicPrice);
    }

    @Override
    public void deleteMusic(Long musicId) {
        musicRepository.deleteMusic(musicId);
    }
}
