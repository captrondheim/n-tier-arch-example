package com.capgemini.ignite.controller;

import com.capgemini.ignite.controller.entities.GenericResponse;
import com.capgemini.ignite.controller.entities.ParticipantRequest;
import com.capgemini.ignite.controller.entities.ParticipantResponse;
import com.capgemini.ignite.controller.entities.ParticipantsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@Tag(name = "Participants")
@RequestMapping("/api/v1/participants")
public interface ParticipantResource {

    @Operation(summary = "Retrieves a customers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Particiapnt",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ParticipantResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "Could not find participant",
                    content = @Content) })
    @GetMapping(value = "/{name}", produces = {"application/json", "application/xml"})
    ResponseEntity<ParticipantResponse> get(@PathVariable String name);

    @Operation(summary = "Retrieves a list of participants")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of participants",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ParticipantsResponse.class)) }),
            @ApiResponse(responseCode = "404", description = "Could not find any customers",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponse.class))) })
    @GetMapping(produces = {"application/json", "application/xml"})
    ResponseEntity<ParticipantsResponse> getAll();

    @Operation(summary = "Create a new participant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "New participant created",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ParticipantResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "",
                    content = @Content)})
    @PostMapping(consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ParticipantResponse> create(HttpServletRequest httpServletRequest,
                                               @Valid @RequestBody ParticipantRequest request);

    @Operation(summary = "Do something amazing")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amazing work done",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GenericResponse.class)) }),
            @ApiResponse(responseCode = "400", description = "",
                    content = @Content)})
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/{name}/amazing", produces = {"application/json", "application/xml"})
    ResponseEntity<GenericResponse> amazing(@PathVariable String name);

    @Operation(summary = "Deletes a participant")
    @DeleteMapping(value = "/{name}", produces = {"application/json", "application/xml"})
    ResponseEntity<Void> delete(@PathVariable String name);
}
