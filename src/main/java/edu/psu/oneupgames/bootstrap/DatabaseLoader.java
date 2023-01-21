package edu.psu.oneupgames.bootstrap;

import edu.psu.oneupgames.model.ApplicationUser;
import edu.psu.oneupgames.model.Music;
import edu.psu.oneupgames.repository.ApplicationUserRepository;
import edu.psu.oneupgames.repository.MusicRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final MusicRepository musicRepository;
    private final ApplicationUserRepository applicationUserRepository;

    public DatabaseLoader(MusicRepository musicRepository, ApplicationUserRepository applicationUserRepository) {

        // spring managed
        this.musicRepository = musicRepository;

        // developer managed
//        musicRepository = new MusicRepositoryImpl();
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("*** SPRING APPLICATION IS STARTING!");

        //
        //  add musics to the database
        musicRepository.addMusic(new Music("Starboy", "Weeknd", "12/25/2016", Music.Genre.POP, 1, 24.99));
        musicRepository.addMusic(new Music("Kamikaze", "Eminem", "09/29/2018", Music.Genre.HIPHOP, 11, 59.99));
        musicRepository.addMusic(new Music("DiCaprio 2", "JID", "07/13/2019", Music.Genre.HIPHOP, 12, 44.49));

        //
        //  add users to the database
        var encoder = new BCryptPasswordEncoder();
        var user1 = new ApplicationUser("admin", encoder.encode("secretpassword"), true);
        applicationUserRepository.addUser(user1);
        var user2 = new ApplicationUser("joemama", encoder.encode("123456"), false);
        applicationUserRepository.addUser(user2);
    }
}
