package validator;

import md.kniga.backendOnlineShop.dto.Product;
import org.springframework.lang.Nullable;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(@Nullable Object target, Errors errors) {

        Product product = (Product) target;

        if(product.getFile() == null ||
                product.getFile().getOriginalFilename().equals("")){
            errors.rejectValue("file", null, "Please select file to upload");
            return;
        }

        if(!(
                product.getFile().getContentType().equals("image/jpeg") ||
                product.getFile().getContentType().equals("image/png") ||
                product.getFile().getContentType().equals("image/gif")
                ))
        {
            errors.rejectValue("file", null, "Please select image file to upload(.jpeg .png .gif)");
            return;
        }


    }
}
