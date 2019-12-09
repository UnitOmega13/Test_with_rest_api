package max.hruslov.controller;

import lombok.RequiredArgsConstructor;
import max.hruslov.model.Conference;
import max.hruslov.model.ConferenceRoom;
import max.hruslov.model.Participant;
import max.hruslov.repository.ConferenceRoomRepository;
import max.hruslov.repository.ParticipantRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import max.hruslov.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/database")
public class Controller {

    private ConferenceRepository conferenceRepository;
    private ConferenceRoomRepository conferenceRoomRepository;
    private ParticipantRepository participantRepository;

    @Autowired
    public void conferenceRepositoryDI(ConferenceRepository conferenceRepository){
        this.conferenceRepository = conferenceRepository;
    }

    @Autowired
    public void conferenceRoomRepositoryDI(ConferenceRoomRepository conferenceRoomRepository){
        this.conferenceRoomRepository = conferenceRoomRepository;
    }

    @Autowired
    public void ParticipantRepositoryDI(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    @PostMapping("/conference/create")
    public Conference create(@RequestBody Conference request){
        return conferenceRepository.save(request);
    }

    @RequestMapping("/conferences")
    public Iterable<Conference> getAll(){
        return conferenceRepository.findAll();
    }

    @RequestMapping("/remove/{conferenceID}")
    public void removeConference(@PathVariable("conferenceID") long conferenceID){
        conferenceRepository.deleteById(conferenceID);
    }

    @PostMapping("/{conferenceRoomID}}/seats")
    public Boolean getConferenceRoomBySeats(@PathVariable("conferenceRoomID") long conferenceRoomID){
        return conferenceRoomRepository.findAllByConferenceRoomID(conferenceRoomID).size() != 150;
    }

    @PostMapping("/{conferenceRoomID}}/location")
    public String findConferenceRoomByLocation(@PathVariable("conferenceRoomID") long conferenceRoomID){
        return conferenceRoomRepository.findConferenceRoomByLocation(conferenceRoomID).getLocation();
    }

    @PostMapping("/{conferenceRoomID}}/addParticipant")
    public Boolean addParticipant(@PathVariable("conferenceRoomID") long conferenceRoomID, Participant participant){
        if(conferenceRoomRepository.findAllByConferenceRoomID(conferenceRoomID).size() != 150) {
            conferenceRoomRepository.addParticipant(participant);
            return true;
        }else {
            ConferenceRoom conferenceRoom = conferenceRoomRepository.findByConferenceRoomID(conferenceRoomID);
            conferenceRoom.setAvailable(false);
            return conferenceRoomRepository.isAvailable(conferenceRoomID);
        }
    }

    @PostMapping("/{conferenceRoomID}}/removeParticipant")
    public Boolean removeParticipant(@PathVariable("conferenceRoomID") long conferenceRoomID, Participant participant){
       return conferenceRoomRepository.findAllByConferenceRoomID(conferenceRoomID).remove(participant);
    }

    @PostMapping("/participant/create")
    public Participant create(@RequestBody Participant participant){
        return participantRepository.save(participant);
    }

    @PostMapping("/{participantID}/remove")
    public void remove(@PathVariable("participantID") long participantID){
        participantRepository.deleteById(participantID);
    }

}
