package com.capgemini.ignite.repository;

import com.capgemini.ignite.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, UUID> {

    Optional<Participant> findParticipantByName(String name);

    void deleteParticipantByName(String name);

}
