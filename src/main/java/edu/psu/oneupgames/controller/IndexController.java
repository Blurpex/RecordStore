package edu.psu.oneupgames.controller;

import edu.psu.oneupgames.model.Music;
import edu.psu.oneupgames.service.MusicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    private final MusicService musicService;

    public IndexController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Music> musics = musicService.getMusics();
        model.addAttribute("musics", musics);
        return "index";
    }

    @GetMapping("/success")
    public String success(Model model) {
        List<Music> musics = musicService.getMusics();
        model.addAttribute("musics", musics);
        model.addAttribute("successMessage", "Data was saved successfully.");
        return "index";
    }

    @GetMapping("/search")
    public String searchMusics(@RequestParam String term, Model model) {
        List<Music> musics = musicService.searchMusics(term);
        model.addAttribute("musics", musics);
        return "index";
    }
}
