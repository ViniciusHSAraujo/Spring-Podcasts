package com.vhsadev.springpodcasts.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vhsadev.springpodcasts.models.Episodio;

public interface EpisodioRepository extends JpaRepository<Episodio, Integer> {

}
