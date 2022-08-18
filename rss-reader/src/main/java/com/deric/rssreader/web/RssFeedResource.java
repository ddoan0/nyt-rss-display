package com.deric.rssreader.web;

import com.deric.rssreader.models.RssFeedItem;
import com.deric.rssreader.services.RssReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RssFeedResource {

    @Autowired
    RssReader rssReader;

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/rss")
    public List<RssFeedItem> getAllFeedItems() {
        return rssReader.getFeedItems();
    }
}
