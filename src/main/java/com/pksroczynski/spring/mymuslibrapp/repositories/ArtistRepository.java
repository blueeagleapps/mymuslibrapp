package com.pksroczynski.spring.mymuslibrapp.repositories;

import com.pksroczynski.spring.mymuslibrapp.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
