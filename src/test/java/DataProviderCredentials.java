import org.testng.annotations.DataProvider;

public class DataProviderCredentials {

    @DataProvider(name = "incorrectCredentials")
    public Object[][] provideIncorrectCredentials() {
        return new Object[][] {
                {"demo@class.com", ""},
                {"", "te$t$tudent"},
                {"demo@class", "te$t$tudent"},
                {"demo@class.com", "te$t"},
                {"demo@class", "te$t"}
        };
    }
}
