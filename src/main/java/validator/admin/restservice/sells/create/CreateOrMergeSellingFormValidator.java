package validator.admin.restservice.sells.create;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.io.IOException;


@Service
public class CreateOrMergeSellingFormValidator implements Validator {

    @Override
    public void validate(Object obj, Errors errors) {
        CreateOrMergeSellingForm createOrMergeSellingForm = (CreateOrMergeSellingForm) obj;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            createOrMergeSellingForm.orderForm = objectMapper.readValue(createOrMergeSellingForm.getOrdersJson(), OrderForm.class);
        } catch (IOException e) {
            errors.rejectValue("ordersJson", "Order can't be empty or broken");
            return;
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CreateOrMergeSellingForm.class.equals(aClass);
    }
}
