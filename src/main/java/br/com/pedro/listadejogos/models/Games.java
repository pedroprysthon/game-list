package br.com.pedro.listadejogos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "games")
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "games_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "starting_date")
    private Date startingDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "review_score")
    private Integer reviewScore;

    @Column(name = "review_note")
    private String reviewNote;

    @ManyToOne
    @JoinColumn(name = "games_category_id")
    @JsonIgnoreProperties("games")
    private GamesCategory gamesCategory;

    public Games() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(Integer reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getReviewNote() {
        return reviewNote;
    }

    public void setReviewNote(String reviewNote) {
        this.reviewNote = reviewNote;
    }

    public GamesCategory getGamesCategory() {
        return gamesCategory;
    }

    public void setGamesCategory(GamesCategory gamesCategory) {
        this.gamesCategory = gamesCategory;
    }
}
