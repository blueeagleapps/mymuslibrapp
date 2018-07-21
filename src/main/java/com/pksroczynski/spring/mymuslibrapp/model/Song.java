package com.pksroczynski.spring.mymuslibrapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String year;

    @OneToOne
    private RecordLabel recordLabel;

    @ManyToMany
    @JoinTable(name = "artist_song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists = new HashSet<>();

    public Song(String title, String genre, String year, RecordLabel recordLabel) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.recordLabel = recordLabel;
    }

}
