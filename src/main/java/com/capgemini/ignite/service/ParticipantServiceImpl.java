package com.capgemini.ignite.service;

import com.capgemini.ignite.exceptions.NotFoundException;
import com.capgemini.ignite.model.Participant;
import com.capgemini.ignite.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ParticipantRepository repository;

    @Override
    public Participant get(String name) {
        return repository.findParticipantByName(name)
                .orElseThrow(() -> new NotFoundException("Could not find participant: %s", name));
    }

    @Override
    public List<Participant> getAll() {
        return repository.findAll();
    }

    @Override
    public Participant create(Participant participant) {
        return repository.save(participant);
    }

    @Override
    @Transactional
    public void delete(String name) {
        repository.deleteParticipantByName(name);
    }

    @Override
    public boolean doSomethingAmazing(String name) {
        Participant participant = get(name);
        return generateRandomNumber(participant.getAge()) > 25;
    }

    private int generateRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
