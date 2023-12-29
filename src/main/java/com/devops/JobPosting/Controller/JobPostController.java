package com.devops.JobPosting.Controller;

import com.devops.JobPosting.Model.JobPost;
import com.devops.JobPosting.Service.JobPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class JobPostController {

    @Autowired
    private JobPostService jobPostService;

    @GetMapping("/")
    public RedirectView redirectSwaggerPage(){
        return new RedirectView("/swagger-ui/index.html");
    }

    @GetMapping("/posts")
    @CrossOrigin
    public List<JobPost> getPosts(){
        return jobPostService.getAllJobPosts();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<JobPost>> getPostById(@PathVariable String id){
        return jobPostService.getJobPostById(id);
    }

    @PostMapping("/post")
    public JobPost addPost(@RequestBody JobPost post){
        return jobPostService.saveJobPost(post);
    }

    @GetMapping("/posts/search")
    public List<JobPost> getTop2PostsByExpAndSorted(@RequestParam String text){
        return jobPostService.getPostsBySearch(text);
    }
}
