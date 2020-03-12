package com.vhsadev.springpodcasts.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vhsadev.springpodcasts.models.Podcast;

public interface PodcastRepository extends JpaRepository<Podcast, Integer> {

}
