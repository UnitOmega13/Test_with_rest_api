package max.hruslov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "CONFERENCE_ROOM")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceRoom {

    @Id
    @GeneratedValue
    private Long conferenceRoomID;
    private String location;
    private Integer roomNumber;
    private Integer seats;
    private Date startDate;
    private Participant participant;
    private Boolean available;

}
