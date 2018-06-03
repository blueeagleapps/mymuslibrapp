package com.pksroczynski.spring.mymuslibrapp.dbinit;

import com.pksroczynski.spring.mymuslibrapp.model.Artist;
import com.pksroczynski.spring.mymuslibrapp.model.Song;
import com.pksroczynski.spring.mymuslibrapp.repositories.ArtistRepository;
import com.pksroczynski.spring.mymuslibrapp.repositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DbDataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private SongRepository songRepository;
    private ArtistRepository artistRepository;

    public DbDataLoad(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init(){
        Song aBoyNamedSue = new Song("A Boy Named Sue", "country", "1969", "Columbia Records");
        Artist johnnyCash = new Artist("Johnny", "Cash", "Sue");
        aBoyNamedSue.getArtists().add(johnnyCash);
        johnnyCash.getSongs().add(aBoyNamedSue);

        artistRepository.save(johnnyCash);
        songRepository.save(aBoyNamedSue);

    }
}
