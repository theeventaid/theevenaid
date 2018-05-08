package com.tgj.eventaid.repositories;

import com.tgj.eventaid.models.Artist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistsRepository extends CrudRepository<Artist, Long>{

}