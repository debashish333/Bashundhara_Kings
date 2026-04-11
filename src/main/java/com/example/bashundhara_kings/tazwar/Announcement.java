package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Announcement implements Serializable {
    private String announcementId;
    private String title;
    private LocalDate postedDate;
    private String postedBy;
    private String content;

    public Announcement(String announcementId, String title, LocalDate postedDate, String postedBy, String content) {
        this.announcementId = announcementId;
        this.title = title;
        this.postedDate = postedDate;
        this.postedBy = postedBy;
        this.content = content;
    }

    public String getAnnouncementId() { return announcementId; }
    public void setAnnouncementId(String announcementId) { this.announcementId = announcementId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getPostedDate() { return postedDate; }
    public void setPostedDate(LocalDate postedDate) { this.postedDate = postedDate; }

    public String getPostedBy() { return postedBy; }
    public void setPostedBy(String postedBy) { this.postedBy = postedBy; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
