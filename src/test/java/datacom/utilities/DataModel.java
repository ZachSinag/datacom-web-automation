package datacom.utilities;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataModel {

    @CsvBindByName(column = "email", required = false)
    private String email;

    @CsvBindByName(column = "forename", required = false)
    private String forename;

    @CsvBindByName(column = "lastname", required = false)
    private String lastname;

    @CsvBindByName(column = "number", required = false)
    private String number;

    @CsvBindByName(column = "jobTitle", required = false)
    private String jobTitle;

    @CsvBindByName(column = "companyName", required = false)
    private String companyName;

    @CsvBindByName(column = "message", required = false)
    private String message;

    @CsvBindByName(column = "country", required = false)
    private String country;

    @CsvBindByName(column = "forename_error_message", required = false)
    private String forename_error_message;

    @CsvBindByName(column = "lastname_error_message", required = false)
    private String lastname_error_message;

    @CsvBindByName(column = "number_error_message", required = false)
    private String number_error_message;

    @CsvBindByName(column = "job_error_message", required = false)
    private String job_error_message;

    @CsvBindByName(column = "email_error_message", required = false)
    private String email_error_message;

    @CsvBindByName(column = "dropdown_error_message", required = false)
    private String dropdown_error_message;

    @CsvBindByName(column = "company_error_message", required = false)
    private String company_error_message;

    @CsvBindByName(column = "environment", required = false)
    private String environment;

    @CsvBindByName(column = "identifier", required = false)
    private String identifier;


}



