package de.todo42.workshop.book;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Book.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book)target;
        validateIsbn(book, errors);
    }

    private void validateIsbn(Book book, Errors errors) {
        String isbn = book.getIsbn().replace("-", "");
        if (isbn.length() != 13) {
            errors.rejectValue("isbn", ErrorCodes.ISBN_FAILED.name(), new Object[] {isbn}, ErrorCodes.ISBN_FAILED.name());
        }
        
        
    }

}
