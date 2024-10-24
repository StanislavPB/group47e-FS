package lesson_10.code.exceptions.userException;

public class ProductServiceWithException {

    private final ValidationServiceWithException validationService;

    public ProductServiceWithException(ValidationServiceWithException validationService) {
        this.validationService = validationService;
    }

    public void add(Product product) {

        validationService.validate(product);

        System.out.println("Success add new product");

    }
}
