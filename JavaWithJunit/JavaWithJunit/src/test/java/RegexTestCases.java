import org.Java.regxPrograms.CurrencyValidator;
import org.Java.regxPrograms.EmailValidator;
import org.Java.regxPrograms.PhoneNumberValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegexTestCases {
    private final EmailValidator emailValidator = new EmailValidator();
    private final CurrencyValidator currencyValidator = new CurrencyValidator();
    private final PhoneNumberValidator phoneValidator = new PhoneNumberValidator();

    @Test
    void validateEmail(){
        assertEquals(true, emailValidator.validateEmail("abc@gmail.com"));
        assertEquals(true, emailValidator.validateEmail("user123@gmail.com"));
        assertEquals(true, emailValidator.validateEmail("user.name@gmail.com"));
        assertEquals(true, emailValidator.validateEmail("user_name@gmail.com"));
        assertEquals(true, emailValidator.validateEmail("user-name@gmail.com"));
        assertEquals(true, emailValidator.validateEmail("user123@yahoo.co.in"));
        assertEquals(true, emailValidator.validateEmail("test.email@outlook.com"));
        assertEquals(true, emailValidator.validateEmail("firstname.lastname@company.org"));
        assertEquals(true, emailValidator.validateEmail("email@subdomain.company.com"));
        assertEquals(true, emailValidator.validateEmail("abc+test@gmail.com"));

        assertEquals(false, emailValidator.validateEmail(null));
        assertEquals(false, emailValidator.validateEmail(""));
        assertEquals(false, emailValidator.validateEmail("plainaddress"));
        assertEquals(false, emailValidator.validateEmail("@gmail.com"));
        assertEquals(false, emailValidator.validateEmail("abc@gmail"));
        assertEquals(false, emailValidator.validateEmail("abc@.com"));
        assertEquals(false, emailValidator.validateEmail("abc@com"));
        assertEquals(false, emailValidator.validateEmail("abc@gmail..com"));
        assertEquals(false, emailValidator.validateEmail("abc@@gmail.com"));
        assertEquals(false, emailValidator.validateEmail("abc gmail@gmail.com"));
        assertEquals(false, emailValidator.validateEmail(".abc@gmail.com"));
        assertEquals(false, emailValidator.validateEmail("abc@gmail.com."));
        assertEquals(false, emailValidator.validateEmail("abc@-gmail.com"));
    }

    @Test
    void validateCurrency(){
        assertEquals(true, currencyValidator.validateCurrency("$0", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$1", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$12", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$123", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$0.99", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$1.00", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$12.50", "US"));
        assertEquals(true, currencyValidator.validateCurrency("$123,456.78", "US"));


        assertEquals(false, currencyValidator.validateCurrency("123", "US"));          // no $
        assertEquals(false, currencyValidator.validateCurrency("$", "US"));            // no digits
        assertEquals(false, currencyValidator.validateCurrency("$.", "US"));           // invalid
        assertEquals(false, currencyValidator.validateCurrency("$123.", "US"));        // incomplete decimal
        assertEquals(false, currencyValidator.validateCurrency("$123.4", "US"));       // only 1 decimal digit
        assertEquals(false, currencyValidator.validateCurrency("$123.456", "US"));     // 3 decimal digits

        assertEquals(false, currencyValidator.validateCurrency("$,123", "US"));        // comma wrong position
        assertEquals(false, currencyValidator.validateCurrency("$12,34", "US"));       // wrong grouping
        assertEquals(false, currencyValidator.validateCurrency("$123,45", "US"));      // wrong grouping
        assertEquals(false, currencyValidator.validateCurrency("$1234,567", "US"));    // wrong grouping

        assertEquals(false, currencyValidator.validateCurrency("$-123", "US"));        // negative not allowed (unless supported)
        assertEquals(false, currencyValidator.validateCurrency("$ 123", "US"));        // space not allowed
        assertEquals(false, currencyValidator.validateCurrency(" $123", "US"));        // space before
        assertEquals(false, currencyValidator.validateCurrency("$123 ", "US"));        // space after

        assertEquals(false, currencyValidator.validateCurrency("$abc", "US"));         // letters
        assertEquals(false, currencyValidator.validateCurrency("$12a", "US"));


        assertEquals(true, currencyValidator.validateCurrency("₹0", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹10", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹100", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹1000", "IN"));

        assertEquals(true, currencyValidator.validateCurrency("₹1,000", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹10,000", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹1,00,000", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹10,00,000", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹1,23,456", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹12,34,567", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹1,23,45,678", "IN"));

        assertEquals(true, currencyValidator.validateCurrency("₹100.00", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹1,000.50", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("₹1,23,456.78", "IN"));

        assertEquals(true, currencyValidator.validateCurrency("INR 100", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("INR 1,23,456", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("INR 1,23,456.78", "IN"));

        assertEquals(true, currencyValidator.validateCurrency("Rs 100", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("Rs. 100", "IN"));
        assertEquals(true, currencyValidator.validateCurrency("Rs. 1,23,456.78", "IN"));
    }

    @Test
    void validatePhoneNo(){
        assertEquals(true, phoneValidator.validatePhoneNo("9876543210", "IN"));
        assertEquals(true, phoneValidator.validatePhoneNo("8123456789", "IN"));
        assertEquals(true, phoneValidator.validatePhoneNo("6789012345", "IN"));

        assertEquals(true, phoneValidator.validatePhoneNo("+919876543210", "IN"));
        assertEquals(true, phoneValidator.validatePhoneNo("+918123456789", "IN"));
        assertEquals(true, phoneValidator.validatePhoneNo("+916789012345", "IN"));

        assertEquals(false, phoneValidator.validatePhoneNo("5876543210", "IN"));  // starts with 5
        assertEquals(false, phoneValidator.validatePhoneNo("4876543210", "IN"));  // starts with 4
        assertEquals(false, phoneValidator.validatePhoneNo("987654321", "IN"));   // 9 digits
        assertEquals(false, phoneValidator.validatePhoneNo("98765432101", "IN")); // 11 digits

        assertEquals(false, phoneValidator.validatePhoneNo("+91987654321", "IN"));  // only 9 digits after +91
        assertEquals(false, phoneValidator.validatePhoneNo("+9198765432101", "IN")); // extra digit

        assertEquals(false, phoneValidator.validatePhoneNo("919876543210", "IN")); // 91 without +
        assertEquals(false, phoneValidator.validatePhoneNo("09876543210", "IN"));  // starts with 0

        assertEquals(false, phoneValidator.validatePhoneNo("+91 9876543210", "IN")); // space not allowed
        assertEquals(false, phoneValidator.validatePhoneNo("+91-9876543210", "IN")); // dash not allowed

        assertEquals(false, phoneValidator.validatePhoneNo("98765a3210", "IN")); // letters
        assertEquals(false, phoneValidator.validatePhoneNo(null, "IN")); // null



        assertEquals(true, phoneValidator.validatePhoneNo("2125557890", "US"));
        assertEquals(true, phoneValidator.validatePhoneNo("212-555-7890", "US"));
        assertEquals(true, phoneValidator.validatePhoneNo("(212) 555-7890", "US"));
        assertEquals(true, phoneValidator.validatePhoneNo("(212)555-7890", "US"));

        assertEquals(true, phoneValidator.validatePhoneNo("+12125557890", "US"));
        assertEquals(true, phoneValidator.validatePhoneNo("+1(212) 555-7890", "US"));
        assertEquals(true, phoneValidator.validatePhoneNo("+1212-555-7890", "US"));

        assertEquals(false, phoneValidator.validatePhoneNo("1125557890", "US")); // starts with 1
        assertEquals(false, phoneValidator.validatePhoneNo("0125557890", "US")); // starts with 0

        assertEquals(false, phoneValidator.validatePhoneNo("212555789", "US"));  // 9 digits
        assertEquals(false, phoneValidator.validatePhoneNo("21255578901", "US")); // 11 digits without +1

        assertEquals(false, phoneValidator.validatePhoneNo("+11255557890", "US")); // invalid after +1

        assertEquals(false, phoneValidator.validatePhoneNo("(112) 555-7890", "US")); // invalid area code
        assertEquals(false, phoneValidator.validatePhoneNo("(012) 555-7890", "US")); // invalid area code

        assertEquals(false, phoneValidator.validatePhoneNo("(212 555-7890", "US")); // missing )
        assertEquals(false, phoneValidator.validatePhoneNo("212) 555-7890", "US")); // missing (

        assertEquals(false, phoneValidator.validatePhoneNo("212-55-7890", "US")); // wrong grouping
        assertEquals(false, phoneValidator.validatePhoneNo("212--555-7890", "US")); // double dash

        assertEquals(false, phoneValidator.validatePhoneNo("212 555 7890", "US")); // spaces not allowed in this regex
        assertEquals(false, phoneValidator.validatePhoneNo("abc-def-ghij", "US")); // letters

        assertEquals(false, phoneValidator.validatePhoneNo(null, "US")); // null


        // Important edge cases
        assertEquals(true, phoneValidator.validatePhoneNo("9999999999", "IN"));
        assertEquals(true, phoneValidator.validatePhoneNo("+919999999999", "IN"));

        assertEquals(true, phoneValidator.validatePhoneNo("9876543210", "US")); // valid US format
        assertEquals(false, phoneValidator.validatePhoneNo("+1987654321", "US")); // too short
    }
}
