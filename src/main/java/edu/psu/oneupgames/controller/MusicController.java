package edu.psu.oneupgames.controller;

import edu.psu.oneupgames.model.Music;
import edu.psu.oneupgames.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MusicController {

    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/music/add")
    public String addMusicView(Model model) {
        return "addMusic";
    }

    @PostMapping("/music/add")
    public String addMusicSubmit(Model model, @RequestParam String musicTitle, @RequestParam String musicArtist, @RequestParam String musicDateReleased, @RequestParam Music.Genre musicGenre, @RequestParam String musicNumTracks, @RequestParam String musicPrice) {
        try {
            musicService.addMusic(musicTitle, musicArtist, musicDateReleased, musicGenre, musicNumTracks, musicPrice);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
            return "addMusic";
        }

        model.addAttribute("successMessage", "The game was successfully saved");
        return "addMusic";
    }

    @GetMapping("/music/edit/{musicId}")
    public String editMusicView(@PathVariable Long musicId, Model model) {
        Music music = musicService.getMusicById(musicId);
        model.addAttribute("musicTitle", music.getMusicTitle());
        model.addAttribute("musicArtist", music.getMusicArtist());
        model.addAttribute("musicDateReleased", music.getMusicDateReleased());
        model.addAttribute("musicGenre", music.getMusicGenre());
        model.addAttribute("musicNumTracks", music.getMusicNumTracks());
        model.addAttribute("musicPrice", music.getMusicPrice());
        return "editMusic";
    }

    @PostMapping("/music/edit")
    public String editMusicSubmit(@RequestParam Long musicId, @RequestParam String musicTitle, @RequestParam String musicArtist, @RequestParam String musicDateReleased, @RequestParam Music.Genre musicGenre, @RequestParam String musicNumTracks, @RequestParam String musicPrice, Model model) {
        try {
            this.musicService.editMusic(musicId, musicTitle, musicArtist, musicDateReleased, musicGenre, musicNumTracks, musicPrice);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "redirect:/success";
    }

    @GetMapping("/music/delete/{musicId}")
    public String deleteMusic(@PathVariable Long musicId, Model model) {
        try {
            this.musicService.deleteMusic(musicId);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
        }
        return "redirect:/success";
    }

    @GetMapping("/view")
    public String view(Model model) {
        List<Music> musics = musicService.getMusics();
        model.addAttribute("musics", musics);
        return "view";
    }
}