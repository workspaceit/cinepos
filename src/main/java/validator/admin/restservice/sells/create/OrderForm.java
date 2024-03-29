package validator.admin.restservice.sells.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Sarwar on 2/3/2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderForm {

    private Integer screenId;
    private Integer terminalId;
    private String sellingComment;
    private List<CartForm> cartForms;

    public Integer getScreenId() {
        return screenId;
    }

    public void setScreenId(Integer screenId) {
        this.screenId = screenId;
    }

    public Integer getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Integer terminalId) {
        this.terminalId = terminalId;
    }

    public String getSellingComment() {
        return sellingComment;
    }

    public void setSellingComment(String sellingComment) {
        this.sellingComment = sellingComment;
    }

    public List<CartForm> getCartForms() {
        return cartForms;
    }

    public void setCartForms(List<CartForm> cartForms) {
        this.cartForms = cartForms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderForm orderForm = (OrderForm) o;

        if (screenId != null ? !screenId.equals(orderForm.screenId) : orderForm.screenId != null) return false;
        if (terminalId != null ? !terminalId.equals(orderForm.terminalId) : orderForm.terminalId != null) return false;
        if (sellingComment != null ? !sellingComment.equals(orderForm.sellingComment) : orderForm.sellingComment != null)
            return false;
        return !(cartForms != null ? !cartForms.equals(orderForm.cartForms) : orderForm.cartForms != null);

    }

    @Override
    public int hashCode() {
        int result = screenId != null ? screenId.hashCode() : 0;
        result = 31 * result + (terminalId != null ? terminalId.hashCode() : 0);
        result = 31 * result + (sellingComment != null ? sellingComment.hashCode() : 0);
        result = 31 * result + (cartForms != null ? cartForms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderForm{" +
                "screenId=" + screenId +
                ", terminalId=" + terminalId +
                ", sellingComment='" + sellingComment + '\'' +
                ", cartForms=" + cartForms +
                '}';
    }
}
