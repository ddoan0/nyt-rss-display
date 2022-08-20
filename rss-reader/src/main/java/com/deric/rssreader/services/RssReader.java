package com.deric.rssreader.services;

import com.deric.rssreader.models.RssFeedItem;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class RssReader {

    @Value("${rssUrl}")
    private String url;
    private final List<RssFeedItem> feedItems;

    public RssReader() {
        feedItems = new ArrayList<>();
    }

    @Cacheable("feedItems")
    public List<RssFeedItem> getFeedItems() {
        return feedItems;
    }

    @Scheduled(fixedRate = 900000)
    @CacheEvict(cacheNames = "feedItems", allEntries = true)
    void getFeed() throws IOException {
        if(feedItems.size() > 0) {
            feedItems.clear();
        }

        try (XmlReader reader = new XmlReader(new URL(url))) {
            SyndFeed feed = new SyndFeedInput().build(reader);
            for (SyndEntry entry : feed.getEntries()) {
                RssFeedItem rssFeedItem = new RssFeedItem();
                rssFeedItem.setTitle(entry.getTitle());
                rssFeedItem.setDescription(entry.getDescription().getValue());
                rssFeedItem.setPubDate(entry.getPublishedDate().toLocaleString().substring(0, 12));
                rssFeedItem.setLink(entry.getLink());
                rssFeedItem.setAuthors(entry.getAuthor());
                for (Element e : entry.getForeignMarkup()) {
                    if(e.getAttribute("height") == null) continue;
                    rssFeedItem.setImageHeight(Integer.parseInt(e.getAttribute("height").getValue()));
                    rssFeedItem.setImageWidth(Integer.parseInt(e.getAttribute("width").getValue()));
                    rssFeedItem.setImageUrl(e.getAttribute("url").getValue());
                }
                feedItems.add(rssFeedItem);
            }
        } catch (FeedException e) {
            throw new RuntimeException(e);
        }
    }
}
