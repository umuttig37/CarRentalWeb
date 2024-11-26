package CarRentalWeb.model;

import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "user")
@SecondaryTables({
        @SecondaryTable(name = "user_fi"),
        @SecondaryTable(name = "user_en"),
        @SecondaryTable(name = "user_fr"),
        @SecondaryTable(name = "user_jp"),
        @SecondaryTable(name = "user_zh")
})
public class User {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String language;

    private String userName;

    private String userPassword;
    @Column(unique = true)
    private String userEmail;

    @Column(table = "user_fi")
    private String userLastnameFi;
    @Column(table = "user_fi")
    private String userFirstNameFi;

    @Column(table = "user_en")
    private String userLastnameEn;
    @Column(table = "user_en")
    private String userFirstNameEn;

    @Column(table = "user_fr")
    private String userLastnameFr;
    @Column(table = "user_fr")
    private String userFirstNameFr;

    @Column(table = "user_jp")
    private String userLastnameJp;
    @Column(table = "user_jp")
    private String userFirstNameJp;

    @Column(table = "user_zh")
    private String userLastnameZh;
    @Column(table = "user_zh")
    private String userFirstNameZh;

    // Getters and Setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        switch (language) {
            case "fi": return userLastnameFi;
            case "en": return userLastnameEn;
            case "fr": return userLastnameFr;
            case "jp": return userLastnameJp;
            case "zh": return userLastnameZh;
            default: return null;
        }
    }
    public void setUserLastname(String userLastname) {
        switch (language) {
            case "fi": this.userLastnameFi = userLastname; break;
            case "en": this.userLastnameEn = userLastname; break;
            case "fr": this.userLastnameFr = userLastname; break;
            case "jp": this.userLastnameJp = userLastname; break;
            case "zh": this.userLastnameZh = userLastname; break;
            default:
                logger.warn("Unsupported language - {}", language);
                break;
        }
    }

    public String getUserFirstName() {
        switch (language) {
            case "fi": return userFirstNameFi;
            case "en": return userFirstNameEn;
            case "fr": return userFirstNameFr;
            case "jp": return userFirstNameJp;
            case "zh": return userFirstNameZh;
            default: return null;
        }
    }
    public void setUserFirstName(String userFirstName) {
        switch (language) {
            case "fi": this.userFirstNameFi = userFirstName; break;
            case "en": this.userFirstNameEn = userFirstName; break;
            case "fr": this.userFirstNameFr = userFirstName; break;
            case "jp": this.userFirstNameJp = userFirstName; break;
            case "zh": this.userFirstNameZh = userFirstName; break;
            default:
                logger.warn("Unsupported language - {}", language);
                break;
        }
    }
}
