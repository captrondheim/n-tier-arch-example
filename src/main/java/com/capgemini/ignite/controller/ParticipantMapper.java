package com.capgemini.ignite.controller;

import com.capgemini.ignite.controller.entities.ParticipantResponse;
import com.capgemini.ignite.controller.entities.ParticipantsResponse;
import com.capgemini.ignite.model.Participant;
import lombok.experimental.UtilityClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@UtilityClass
public final class ParticipantMapper {

    public static ResponseEntity<ParticipantResponse> map(Participant participant) {
        return ResponseEntity.ok(ParticipantResponse.from(participant));
    }

    public static ResponseEntity<ParticipantsResponse> map(List<Participant> participants) {
        return ResponseEntity.ok(ParticipantsResponse.from(participants));
    }

    public static ResponseEntity<ParticipantResponse> map(HttpServletRequest httpServletRequest, Participant participant) {
        URI uri = ServletUriComponentsBuilder.fromContextPath(httpServletRequest)
                .path("/api/v1/participants/{name}")
                .buildAndExpand(participant.getName())
                .toUri();
        return ResponseEntity.created(uri).body(ParticipantResponse.from(participant));
    }
}
