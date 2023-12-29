package com.devops.JobPosting.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "JobPost")
public class JobPost {
    @Id
    private String id;
    private String desc;
    private Integer exp;
    private String profile;
    private String[] techs;
}
