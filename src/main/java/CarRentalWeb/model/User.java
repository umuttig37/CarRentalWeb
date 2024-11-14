package CarRentalWeb.model;

import jakarta.persistence.*;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String language; // Tracks user's preferred language, e.g., "fi", "en", etc.

    // Universal fields stored in the main `user` table
    private String userPassword;
    @Column(unique = true)
    private String userEmail;

    // Fields with the same names across all language tables
    @Column(table = "user_fi")
    private String userNameFi;
    @Column(table = "user_fi")
    private String userLastnameFi;
    @Column(table = "user_fi")
    private String userFirstNameFi;

    @Column(table = "user_en")
    private String userNameEn;
    @Column(table = "user_en")
    private String userLastnameEn;
    @Column(table = "user_en")
    private String userFirstNameEn;

    @Column(table = "user_fr")
    private String userNameFr;
    @Column(table = "user_fr")
    private String userLastnameFr;
    @Column(table = "user_fr")
    private String userFirstNameFr;

    @Column(table = "user_jp")
    private String userNameJp;
    @Column(table = "user_jp")
    private String userLastnameJp;
    @Column(table = "user_jp")
    private String userFirstNameJp;

    @Column(table = "user_zh")
    private String userNameZh;
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
        switch (language) {
            case "fi": return userNameFi;
            case "en": return userNameEn;
            case "fr": return userNameFr;
            case "jp": return userNameJp;
            case "zh": return userNameZh;
            default: return null;
        }
    }
    public void setUserName(String userName) {
        switch (language) {
            case "fi": this.userNameFi = userName; break;
            case "en": this.userNameEn = userName; break;
            case "fr": this.userNameFr = userName; break;
            case "jp": this.userNameJp = userName; break;
            case "zh": this.userNameZh = userName; break;
        }
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
        }
    }
}