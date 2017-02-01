package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by mi on 1/24/17.
 */
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @OneToOne
    @JoinColumn(name = "seat_type_id",referencedColumnName = "id")
    private SeatType seatType;

    @OneToOne
    @JoinColumn(name = "vat_id",referencedColumnName = "id")
    private VatSetting vat;

    @ManyToMany
    @JoinTable(name = "ticket_channels", joinColumns = {
            @JoinColumn(name = "ticket_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "channel_id",
                    nullable = false, updatable = false) })
    private Set<SellsChannel> sellsChannels;


    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "annotation")
    private String annotation;

    @Basic
    @Column(name = "printed_price")
    private Double printedPrice;

    public VatSetting getVat() {
        return vat;
    }

    public void setVat(VatSetting vat) {
        this.vat = vat;
    }


    @Basic
    @Column(name = "sell_on_web")
    private boolean sellOnWeb;

    @Basic
    @Column(name = "sell_on_kiosk")
    private boolean sellOnKiosk;

    @Basic
    @Column(name = "sell_on_pos")
    private boolean sellOnPos;

    @Basic
    @Column(name = "is_child")
    private boolean isChild;

    @Basic
    @Column(name = "is_adult")
    private boolean isAdult;

    @Basic
    @Column(name = "status")
    private boolean status;

    @Basic
    @Column(name = "start_date")
    private Date startDate;

    @Basic
    @Column(name = "end_date")
    private Date endDate;
    @Basic
    @Column(name = "created_by")
    private Integer createdBy;

    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<SellsChannel> getSellsChannels() {
        return sellsChannels;
    }

    public void setSellsChannels(Set<SellsChannel> sellsChannels) {
        this.sellsChannels = sellsChannels;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Double getPrintedPrice() {
        return printedPrice;
    }

    public void setPrintedPrice(Double printedPrice) {
        this.printedPrice = printedPrice;
    }

    public boolean isSellOnWeb() {
        return sellOnWeb;
    }

    public void setSellOnWeb(boolean sellOnWeb) {
        this.sellOnWeb = sellOnWeb;
    }

    public boolean isSellOnKiosk() {
        return sellOnKiosk;
    }

    public void setSellOnKiosk(boolean sellOnKiosk) {
        this.sellOnKiosk = sellOnKiosk;
    }

    public boolean isSellOnPos() {
        return sellOnPos;
    }

    public void setSellOnPos(boolean sellOnPos) {
        this.sellOnPos = sellOnPos;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setIsChild(boolean isChild) {
        this.isChild = isChild;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setIsAdult(boolean isAdult) {
        this.isAdult = isAdult;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (sellOnWeb != ticket.sellOnWeb) return false;
        if (sellOnKiosk != ticket.sellOnKiosk) return false;
        if (sellOnPos != ticket.sellOnPos) return false;
        if (isChild != ticket.isChild) return false;
        if (isAdult != ticket.isAdult) return false;
        if (status != ticket.status) return false;
        if (seatType != null ? !seatType.equals(ticket.seatType) : ticket.seatType != null) return false;
        if (vat != null ? !vat.equals(ticket.vat) : ticket.vat != null) return false;
        if (sellsChannels != null ? !sellsChannels.equals(ticket.sellsChannels) : ticket.sellsChannels != null)
            return false;
        if (description != null ? !description.equals(ticket.description) : ticket.description != null) return false;
        if (annotation != null ? !annotation.equals(ticket.annotation) : ticket.annotation != null) return false;
        if (printedPrice != null ? !printedPrice.equals(ticket.printedPrice) : ticket.printedPrice != null)
            return false;
        if (startDate != null ? !startDate.equals(ticket.startDate) : ticket.startDate != null) return false;
        if (endDate != null ? !endDate.equals(ticket.endDate) : ticket.endDate != null) return false;
        if (createdBy != null ? !createdBy.equals(ticket.createdBy) : ticket.createdBy != null) return false;
        return !(createdAt != null ? !createdAt.equals(ticket.createdAt) : ticket.createdAt != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (seatType != null ? seatType.hashCode() : 0);
        result = 31 * result + (vat != null ? vat.hashCode() : 0);
        result = 31 * result + (sellsChannels != null ? sellsChannels.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (annotation != null ? annotation.hashCode() : 0);
        result = 31 * result + (printedPrice != null ? printedPrice.hashCode() : 0);
        result = 31 * result + (sellOnWeb ? 1 : 0);
        result = 31 * result + (sellOnKiosk ? 1 : 0);
        result = 31 * result + (sellOnPos ? 1 : 0);
        result = 31 * result + (isChild ? 1 : 0);
        result = 31 * result + (isAdult ? 1 : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (createdBy != null ? createdBy.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }
}
