package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mi on 1/24/17.
 */
@Entity
@Table(name = "ticket_channels")
public class TicketChannels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Basic
    @Column(name = "ticket_id")
    private Integer ticketId;

    @Basic
    @Column(name = "channel_id")
    private Integer channelId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketChannels that = (TicketChannels) o;

        if (id != that.id) return false;
        if (ticketId != null ? !ticketId.equals(that.ticketId) : that.ticketId != null) return false;
        return !(channelId != null ? !channelId.equals(that.channelId) : that.channelId != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (ticketId != null ? ticketId.hashCode() : 0);
        result = 31 * result + (channelId != null ? channelId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TicketChannels{" +
                "id=" + id +
                ", ticketId=" + ticketId +
                ", channelId=" + channelId +
                '}';
    }
}
