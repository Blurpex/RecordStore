package edu.psu.oneupgames.repository.impl;

import edu.psu.oneupgames.jpa.JpaMusicRepository;
import edu.psu.oneupgames.model.Music;
import edu.psu.oneupgames.repository.MusicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class MusicRepositoryImpl implements MusicRepository {

    private final JpaMusicRepository jpaMusicRepository;

    public MusicRepositoryImpl(JpaMusicRepository jpaMusicRepository) {
        this.jpaMusicRepository = jpaMusicRepository;
    }

    @Override
    public List<Music> getMusics() {
        return (List<Music>) jpaMusicRepository.findAll();
    }

    @Override
    public void addMusic(Music music) {
        jpaMusicRepository.save(music);
    }

    @Override
    public List<Music> searchMusics(String term) {
        return jpaMusicRepository.findByMusicTitleContainingIgnoreCase(term);
    }

    @Override
    public long findMaxMusicId() {
        return 0L;
    }

    @Override
    public Music getMusicById(Long musicId) {
        var optional = jpaMusicRepository.findById(musicId);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new IllegalStateException("music with ID " + musicId + " not found");
    }

    @Override
    public void editMusic(Music music, Long musicId, String musicTitle, String musicArtist, String musicDateReleased, Music.Genre musicGenre, String musicNumTracks, String musicPrice) {
        music.setMusicTitle(musicTitle);
        music.setMusicArtist(musicArtist);
        music.setMusicDateReleased(musicDateReleased);
        music.setMusicGenre(musicGenre);
        music.setMusicNumTracks(Integer.parseInt(musicNumTracks));
        music.setMusicPrice(Double.parseDouble(musicPrice));

        jpaMusicRepository.save(music);
    }

    @Override
    public void deleteMusic(Long musicId) {
        jpaMusicRepository.deleteById(musicId);
    }
}