package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistsRepository extends CrudRepository<Artist, Long>{

    @Query(nativeQuery =true, value = "SELECT * from artists WHERE event_id = ?1")
    List<Artist> findAllByEvent(long id);


}