package com.devops.JobPosting.Repository;

import com.devops.JobPosting.Model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Return top most 2 posts which are sorted in ascending order expereince wise and has technology java
 */
@Component
public class SearchPostsRepositoryImpl implements SearchPostsRepository{

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter converter;
    @Override
    public List<JobPost> searchByText(String text) {

        final List<JobPost> posts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("learner");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", "techs"))),
                new Document("$sort", new Document("exp", -1L)),
                new Document("$limit", 2L)));

        result.forEach(doc -> posts.add(converter.read(JobPost.class,doc)));

        return posts;
    }
}
