package validator.admin.restservice.screen.createScreen;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Time;

/**
 * Created by mi on 1/5/17.
 */
public class CreateScreenFrom {

    @NotBlank(message = "Name required")
    @Length(max=50,message = "Name too large")
    private String name;

    @NotNull(message = "Opening time required")
    private Integer screenTypeId;

    @NotNull(message = "Row count required")
    @Min(value = 1, message = "The Row must be positive")
    private Integer  rowCount;

    @NotNull(message = "Column count required")
    @Min(value = 1, message = "The Column must be positive")
    private Integer columnCount;

    @NotNull(message = "Seat count required")
    private Integer seatCount;


    @NotNull(message = "Opening time required")
    private Time openingTime;

    @NotNull(message = "Closing time required")
    private Time closingTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Integer getScreenTypeId() {
        return screenTypeId;
    }

    public void setScreenTypeId(Integer screenTypeId) {
        this.screenTypeId = screenTypeId;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(Integer columnCount) {
        this.columnCount = columnCount;
    }

    public Time getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(Time openingTime) {
        this.openingTime = openingTime;
    }

    public Time getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(Time closingTime) {
        this.closingTime = closingTime;
    }


    @Override
    public String toString() {
        return "CreateScreenFrom{" +
                "name='" + name + '\'' +
                ", seatCount=" + seatCount +
                ", screenTypeId=" + screenTypeId +
                ", rowCount=" + rowCount +
                ", columnCount=" + columnCount +
                ", openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
