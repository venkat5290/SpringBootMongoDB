package com.devops.JobPosting.Service;

import com.devops.JobPosting.Model.JobPost;
import com.devops.JobPosting.Repository.JobPostsRepository;
import com.devops.JobPosting.Repository.SearchPostsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostService {

    @Autowired
    private JobPostsRepository jobPostsRepository;

    @Autowired
    private SearchPostsRepositoryImpl searchRepo;

    public List<JobPost> getAllJobPosts(){
        return jobPostsRepository.findAll();
    }

    public ResponseEntity<Optional<JobPost>> getJobPostById(String id) {
        Optional<JobPost> jobPost = jobPostsRepository.findById(id);
        if(jobPost.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User with id %s not found", id));
        }

        return ResponseEntity.ok(jobPost);
    }

    public JobPost saveJobPost(JobPost post) {
        return jobPostsRepository.save(post);
    }

    public List<JobPost> getPostsBySearch(String text) {
        return searchRepo.searchByText(text);
    }
}
