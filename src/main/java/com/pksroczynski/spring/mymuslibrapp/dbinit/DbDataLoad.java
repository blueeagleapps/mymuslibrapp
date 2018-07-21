package com.pksroczynski.spring.mymuslibrapp.dbinit;

import com.pksroczynski.spring.mymuslibrapp.model.Artist;
import com.pksroczynski.spring.mymuslibrapp.model.RecordLabel;
import com.pksroczynski.spring.mymuslibrapp.model.Song;
import com.pksroczynski.spring.mymuslibrapp.repositories.ArtistRepository;
import com.pksroczynski.spring.mymuslibrapp.repositories.RecordLabelRepository;
import com.pksroczynski.spring.mymuslibrapp.repositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DbDataLoad implements ApplicationListener<ContextRefreshedEvent> {

    private SongRepository songRepository;
    private ArtistRepository artistRepository;
    private RecordLabelRepository recordLabelRepository;

    public DbDataLoad(SongRepository songRepository, ArtistRepository artistRepository, RecordLabelRepository recordLabelRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.recordLabelRepository = recordLabelRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init(){
        RecordLabel columbiaRecords = new RecordLabel("Columbia Records", "www.colrecords.com", "boss@colrecords.com", "No one know Street 12560, Columiba, Iran");
        recordLabelRepository.save(columbiaRecords);

        Song aBoyNamedSue = new Song("A Boy Named Sue", "country", "1969", columbiaRecords);
        Artist johnnyCash = new Artist("Johnny", "Cash", "Sue");
        aBoyNamedSue.getArtists().add(johnnyCash);
        johnnyCash.getSongs().add(aBoyNamedSue);

        artistRepository.save(johnnyCash);
        songRepository.save(aBoyNamedSue);

        Artist johnFromDatabase = artistRepository.findByFirstName("Johnny").get();

        RecordLabel islandRecords = new RecordLabel("Island Records", "www.islandrecords.com", "boss@islandrecords.com", "Orange County, Florida, Pakistan");
        recordLabelRepository.save(islandRecords);


        Song threeLittle = new Song("Three little birds", "raggae", "1977", islandRecords);
        Artist bobMarley = new Artist("Bob", "Marley", "bob");
        threeLittle.getArtists().add(bobMarley);
        bobMarley.getSongs().add(threeLittle);

        artistRepository.save(bobMarley);
        songRepository.save(threeLittle);

        RecordLabel emi = new RecordLabel("EMI", "www.emi.com", "boss@emi.com", "9210 Beverly Hills, LA, Poland");
        recordLabelRepository.save(emi);

        Song callingAllGirls= new Song("Calling All Girls", "rock", "1982", emi);
        Artist freddieMercury = new Artist("Freddie", "Mercury", "freddie");
        callingAllGirls.getArtists().add(freddieMercury);
        freddieMercury.getSongs().add(callingAllGirls);

        artistRepository.save(freddieMercury);
        songRepository.save(callingAllGirls);


    }
}
