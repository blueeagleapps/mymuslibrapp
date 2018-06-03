package com.pksroczynski.spring.mymuslibrapp.repositories;

import com.pksroczynski.spring.mymuslibrapp.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
