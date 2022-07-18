package pages_sample;

public class ExpectedMessages_PO {
    private String EmailAlreadyRegistered = "Warning: E-Mail Address is already registered!";
    private String PrivacyPolicy = "Warning: You must agree to the Privacy Policy!";
    private String FirstName = "First Name must be between 1 and 32 characters!";
    private String LastName = "Last Name must be between 1 and 32 characters!";
    private String EmailIncorrect = "E-Mail Address does not appear to be valid!";
    private String Telephone = "Telephone must be between 7 and 32 characters!";
    private String Password = "Password must be between 4 and 20 characters!";
    private String PasswordConfirm = "Password confirmation does not match password!";
    private String SuccessUpdate =  "Success: Your account has been successfully updated.";

    public String getExpectedMessage (String messageName) {
        String message = null;
        switch (messageName) {
            case "First Name" :
                message = FirstName;
                break;
            case "Last Name" :
                message = LastName;
                break;
            case "E-Mail" :
                message = EmailIncorrect;
                break;
            case "Telephone" :
                message = Telephone;
                break;
            case "Password" :
                message = Password;
                break;
            case "Password Confirm" :
                message = PasswordConfirm;
                break;
            case "Policy" :
                message = PrivacyPolicy;
                break;
            case "EmailAlreadyRegistered" :
                message = EmailAlreadyRegistered;
                break;
            case "Success Update" :
                message = SuccessUpdate;
                break;
        }
        return message;
    }
}
