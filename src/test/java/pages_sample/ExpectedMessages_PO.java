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
    private String commaAfter = "A part following '@' should not contain the symbol ','.";
    private String commaBefore = "A part followed by '@' should not contain the symbol ','.";
    private String incorrectName = "Please enter a part followed by '@'. '";
    private String incorrectDomain = "Please enter a part following '@'. '";
    private String incomplete = "' is incomplete.";
    private String missingEta1 = "Please include an '@' in the email address. '";
    private String missingEta2 = "' is missing an '@'.";

    public String getTooltipMessage (String tooltip, String email) {
        String message = null;
        switch (tooltip) {
            case "comma after":
                message = commaAfter;
                break;
            case "comma before":
                message = commaBefore;
                break;
            case "incorrect name":
                message = incorrectName+email+incomplete;
                break;
            case "incorrect domain":
                message = incorrectDomain+email+incomplete;
                break;
            case "missing eta":
                message = missingEta1+email+missingEta2;
                break;
        }
        return message;
    }

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
            case "Email Already Registered" :
                message = EmailAlreadyRegistered;
                break;
            case "Success Update" :
                message = SuccessUpdate;
                break;
        }
        return message;
    }
}
