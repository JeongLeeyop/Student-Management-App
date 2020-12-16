package com.example.app.model.domain.section;
import com.example.app.model.domain.Student;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
//@DynamicInsert
//@DynamicUpdate
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "Score_SEQ_NO")
    @SequenceGenerator(sequenceName = "Score_SEQ_NO", name = "Score_SEQ_NO", allocationSize = 1)
    private long scoreIdx;

    @Column(nullable=true)
    private BigDecimal score;

    @ManyToOne
    @JoinColumn(name = "sectionIdx")
    private Section section;

    @ManyToOne
    @JoinColumn(name = "StudentIdx")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "taskIdx")
    private Task task;
}