package com.deric.rssreader.models;

import java.util.Date;

public class RssFeedItem {
    private int id;
    private String title;
    private String link;
    private Date pubDate;
    private String description;
    private String imageUrl;
    private int imageHeight;
    private int imageWidth;

    public RssFeedItem() {
    }

    public RssFeedItem(String title, String link, Date pubDate, String description, String imageUrl, int imageHeight, int imageWidth) {
        this.title = title;
        this.link = link;
        this.pubDate = pubDate;
        this.description = description;
        this.imageUrl = imageUrl;
        this.imageHeight = imageHeight;
        this.imageWidth = imageWidth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }
}
