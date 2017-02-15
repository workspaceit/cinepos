package validator.admin.AdminComboService.createCombo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sarwar on 1/19/2017.
 */
public class CreateComboForm {

    @NotBlank(message = "Combo Name are required")
    @Length(max = 55,message = "Site name too large")
    private String comboName;

    @NotBlank(message = "Combo Details are required")
    @Length(max = 255,message = "Combo Details too large")
    private String details;

    @NotNull(message = "Combo price are required")
    private Float price;

    @NotNull(message = "Start Time is required")
    private String startDate;

    @NotNull(message = "End Date is required")
    private String endDate;

    @NotNull(message = "Combo Type is required")
    private String comboType;

    @NotNull(message = "Product are  required")
    private String productIds;

    @NotNull(message = "Product quantity are  required")
    @Min(value = 1, message = "Product quantity be positive")
    private String productQuantity;

    private int seatTypeId;

    private List<Integer> productsIdArray = new ArrayList<>();



    private Date formattedStartDate;

    private Date formattedEndDate;


    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getComboType() {
        return comboType;
    }

    public void setComboType(String comboType) {
        this.comboType = comboType;
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(int seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public List<Integer> getProductsIdArray() {
        return productsIdArray;
    }

    public void setProductsIdArray(List<Integer> productsIdArray) {
        this.productsIdArray = productsIdArray;
    }

    public Date getFormattedStartDate() {
        return formattedStartDate;
    }

    public void setFormattedStartDate(Date formattedStartDate) {
        this.formattedStartDate = formattedStartDate;
    }

    public Date getFormattedEndDate() {
        return formattedEndDate;
    }

    public void setFormattedEndDate(Date formattedEndDate) {
        this.formattedEndDate = formattedEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateComboForm that = (CreateComboForm) o;

        if (seatTypeId != that.seatTypeId) return false;
        if (comboName != null ? !comboName.equals(that.comboName) : that.comboName != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (comboType != null ? !comboType.equals(that.comboType) : that.comboType != null) return false;
        if (productIds != null ? !productIds.equals(that.productIds) : that.productIds != null) return false;
        if (productQuantity != null ? !productQuantity.equals(that.productQuantity) : that.productQuantity != null)
            return false;
        if (productsIdArray != null ? !productsIdArray.equals(that.productsIdArray) : that.productsIdArray != null)
            return false;
        if (formattedStartDate != null ? !formattedStartDate.equals(that.formattedStartDate) : that.formattedStartDate != null)
            return false;
        return formattedEndDate != null ? formattedEndDate.equals(that.formattedEndDate) : that.formattedEndDate == null;
    }

    @Override
    public int hashCode() {
        int result = comboName != null ? comboName.hashCode() : 0;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (comboType != null ? comboType.hashCode() : 0);
        result = 31 * result + (productIds != null ? productIds.hashCode() : 0);
        result = 31 * result + (productQuantity != null ? productQuantity.hashCode() : 0);
        result = 31 * result + seatTypeId;
        result = 31 * result + (productsIdArray != null ? productsIdArray.hashCode() : 0);
        result = 31 * result + (formattedStartDate != null ? formattedStartDate.hashCode() : 0);
        result = 31 * result + (formattedEndDate != null ? formattedEndDate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CreateComboForm{" +
                "comboName='" + comboName + '\'' +
                ", details='" + details + '\'' +
                ", price=" + price +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", comboType='" + comboType + '\'' +
                ", productIds='" + productIds + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                ", seatTypeId=" + seatTypeId +
                ", productsIdArray=" + productsIdArray +
                ", formattedStartDate=" + formattedStartDate +
                ", formattedEndDate=" + formattedEndDate +
                '}';
    }
}
