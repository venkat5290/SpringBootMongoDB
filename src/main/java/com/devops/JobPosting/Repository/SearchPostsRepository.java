package com.devops.JobPosting.Repository;

import com.devops.JobPosting.Model.JobPost;

import java.util.List;

public interface SearchPostsRepository {

    public List<JobPost> searchByText(String text);
}
