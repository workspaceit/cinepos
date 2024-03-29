package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import entity.app.jsonview.film.schedule.FilmTimeJsonView;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created by mi on 1/17/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "film_time")
public class FilmTime {

    @JsonView(FilmTimeJsonView.Basic.class)
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonView(FilmTimeJsonView.Basic.class)
    @Basic
    @Column(name = "film_schedule_id")
    private Integer filmScheduleId;

//    @JsonView({FilmTimeJsonView.Summary.class,FilmTimeJsonView.Details.class})
    @JsonView(FilmTimeJsonView.Summary.class)
    @OneToOne
    @JoinColumn(name = "film_id" , referencedColumnName = "id")
    private Film film;

    @JsonView(FilmTimeJsonView.Basic.class)
    @Basic
    @Column(name = "start_time")
    private Time startTime;

    @JsonView(FilmTimeJsonView.Basic.class)
    @Basic
    @Column(name = "end_time")
    private Time endTime;

    @JsonView(FilmTimeJsonView.Basic.class)
    @Basic
    @Column(name = "status")
    private boolean status;

    @JsonIgnore
    @Basic
    @Column(name = "created_by")
    private Integer createdBy;

    @JsonIgnore
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getFilmScheduleId() {
        return filmScheduleId;
    }

    public void setFilmScheduleId(Integer filmScheduleId) {
        this.filmScheduleId = filmScheduleId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FilmTime filmTime = (FilmTime) o;

        if (id != filmTime.id) return false;
        if (status != filmTime.status) return false;
        if (filmScheduleId != null ? !filmScheduleId.equals(filmTime.filmScheduleId) : filmTime.filmScheduleId != null)
            return false;
        if (film != null ? !film.equals(filmTime.film) : filmTime.film != null) return false;
        if (startTime != null ? !startTime.equals(filmTime.startTime) : filmTime.startTime != null) return false;
        if (endTime != null ? !endTime.equals(filmTime.endTime) : filmTime.endTime != null) return false;
        if (createdBy != null ? !createdBy.equals(filmTime.createdBy) : filmTime.createdBy != null) return false;
        return !(createdAt != null ? !createdAt.equals(filmTime.createdAt) : filmTime.createdAt != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (filmScheduleId != null ? filmScheduleId.hashCode() : 0);
        result = 31 * result + (film != null ? film.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FilmTime{" +
                "id=" + id +
                ", filmScheduleId=" + filmScheduleId +
                ", film=" + film +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status=" + status +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                '}';
    }
}
