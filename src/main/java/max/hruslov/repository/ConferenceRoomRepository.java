package max.hruslov.repository;

import max.hruslov.model.ConferenceRoom;
import max.hruslov.model.Participant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoom, Long> {

    ConferenceRoom findByConferenceRoomID(long conferenceRoomID);

    Boolean getConferenceRoomBySeats(long conferenceRoomID);

    List<Participant> findAllByConferenceRoomID(long conferenceRoomID);

    ConferenceRoom findConferenceRoomByLocation(long conferenceRoomID);

    ConferenceRoom addParticipant(Participant participant);

    Boolean isAvailable(long conferenceRoomID);

}
