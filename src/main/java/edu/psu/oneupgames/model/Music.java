package edu.psu.oneupgames.model;

import javax.persistence.*;

@Entity
public class Music {

    // enum type
    public enum Genre {
        ROCK, CLASSICAL, POP, JAZZ, HIPHOP
    }

    // instance data
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "music_id_seq")
    @SequenceGenerator(name = "music_id_seq", sequenceName = "music_id_seq", allocationSize = 100)
    private Long musicId;

    private String musicTitle;
    private String musicArtist;
    private String musicDateReleased;        // TODO turn this into musicDateReleased type
    private Genre musicGenre;
    private Integer musicNumTracks;
    private Double musicPrice;


    // constructor
    public Music() {}

    public Music(String musicTitle, String musicArtist, String musicDateReleased, Genre musicGenre, Integer musicNumTracks, Double musicPrice) {
//        this.musicId = musicId;
        this.musicTitle = musicTitle;
        this.musicArtist = musicArtist;
        this.musicDateReleased = musicDateReleased;
        this.musicGenre = musicGenre;
        this.musicNumTracks = musicNumTracks;
        this.musicPrice = musicPrice;
    }


    // getter methods
    public Long getMusicId()             { return musicId; }
    public String getMusicTitle()        { return musicTitle; }
    public String getMusicArtist()       { return musicArtist; }
    public String getMusicDateReleased() { return musicDateReleased; }
    public Genre getMusicGenre()         { return musicGenre; }
    public Integer getMusicNumTracks()   { return musicNumTracks; }
    public Double getMusicPrice()        { return musicPrice; }


    // setter methods
    public void setMusicId(Long musicId)                      { this.musicId = musicId; }
    public void setMusicTitle(String musicTitle)              { this.musicTitle = musicTitle; }
    public void setMusicArtist(String musicArtist)            { this.musicArtist = musicArtist; }
    public void setMusicDateReleased(String musicDateReleased){ this.musicDateReleased = musicDateReleased; }
    public void setMusicGenre(Genre musicGenre)               { this.musicGenre = musicGenre; }
    public void setMusicNumTracks(Integer musicNumTracks)     { this.musicNumTracks = musicNumTracks; }
    public void setMusicPrice(Double musicPrice)              { this.musicPrice = musicPrice; }
}
