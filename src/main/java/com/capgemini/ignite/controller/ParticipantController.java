package com.capgemini.ignite.controller;

import com.capgemini.ignite.controller.entities.GenericResponse;
import com.capgemini.ignite.controller.entities.ParticipantRequest;
import com.capgemini.ignite.controller.entities.ParticipantResponse;
import com.capgemini.ignite.controller.entities.ParticipantsResponse;
import com.capgemini.ignite.model.Participant;
import com.capgemini.ignite.service.ParticipantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ParticipantController implements ParticipantResource {

    private final ParticipantService service;

    @Override
    public ResponseEntity<ParticipantResponse> get(String name) {
        Participant participant = service.get(name);
        return ParticipantMapper.map(participant);
    }

    @Override
    public ResponseEntity<ParticipantsResponse> getAll() {
        List<Participant> participants = service.getAll();
        return ParticipantMapper.map(participants);
    }

    @Override
    public ResponseEntity<ParticipantResponse> create(HttpServletRequest httpServletRequest, ParticipantRequest request) {
        Participant participant = service.create(request.fromThis());
        return ParticipantMapper.map(httpServletRequest, participant);
    }

    @Override
    public ResponseEntity<GenericResponse> amazing(String name) {
        boolean somethingAmazingIsDone = service.doSomethingAmazing(name);
        return somethingAmazingIsDone ? ResponseEntity.ok(new GenericResponse(true, "Wohu!"))
                : ResponseEntity.ok(new GenericResponse(false, "Uoh!"));
    }

    @Override
    public ResponseEntity<Void> delete(String name) {
        service.delete(name);
        return ResponseEntity.ok().build();
    }
}
