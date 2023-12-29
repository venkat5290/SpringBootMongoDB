package com.devops.JobPosting.Repository;

import com.devops.JobPosting.Model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostsRepository extends MongoRepository<JobPost, String> {
}
