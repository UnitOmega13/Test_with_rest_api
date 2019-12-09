package max.hruslov.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Participant")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})
public class Participant {

    @Id
    @GeneratedValue
    private Long userID;
    private String name;
    private String surName;
    private Data birthDay;
    private Integer age;
    private String subject;

}