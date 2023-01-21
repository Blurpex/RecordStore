package edu.psu.oneupgames.jpa;

import edu.psu.oneupgames.model.Music;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaMusicRepository extends CrudRepository<Music, Long> {
    List<Music> findByMusicTitleContainingIgnoreCase(String title);
}
