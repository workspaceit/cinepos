package entity.tableview;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import entity.app.jsonview.view.BoxOfficeSchedulingViewJsonView;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

/**
 * Created by mi on 2/7/17.
 */
@Entity
@Immutable
@Table(name = "BOX_OFFICE_SCHEDULING_VIEW")
public class BoxOfficeSchedulingView {

    @JsonView(BoxOfficeSchedulingViewJsonView.Basic.class)
    @Id
    @Column(name = "id")
    int id;

    @JsonView(BoxOfficeSchedulingViewJsonView.Summary.class)
    @OneToOne
    @JoinColumn(name = "film_id",referencedColumnName = "id")
    BoxOfficeFilmView film;


    @JsonIgnore
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BoxOfficeFilmView getFilm() {
        return film;
    }

    public void setFilm(BoxOfficeFilmView film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "BoxOfficeSchedulingView{" +
                "film=" + film +
                '}';
    }
}
