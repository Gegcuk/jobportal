package uk.gegc.jobportal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "job_post_activity")
public class JobPostActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobPostId;

    @ManyToOne
    @JoinColumn(name = "postedById", referencedColumnName = "userId")
    private Users postedById;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "jobLocationId", referencedColumnName = "id")
    private JobLocation jobLocationId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobCompanyId", referencedColumnName = "id")
    private JobCompany jobCompanyId;

    @Transient
    private boolean isActive;

    @Transient
    private Boolean isSaved;

    @Length(max=10000)
    private String descriptionOfJob;

    private String jobType;
    private String salary;
    private String remote;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date postedDate;
    private String jobTitle;

}
