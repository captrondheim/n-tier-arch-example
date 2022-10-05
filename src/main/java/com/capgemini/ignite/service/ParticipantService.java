package com.capgemini.ignite.service;

import com.capgemini.ignite.model.Participant;

import java.util.List;

public interface ParticipantService {

    Participant get(String name);

    List<Participant> getAll();

    Participant create(Participant participant);

    void delete(String name);

    boolean doSomethingAmazing(String name);
}
