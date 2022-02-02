package contentsite;

import java.util.Objects;

public class User {
    private String userName;
    private String password;
    private boolean premiumMember;
    private boolean logIn;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = Integer.toString(Objects.hash(userName+password));

        premiumMember=false;
        logIn=false;
    }

    public void upgradeForPremium() {
        this.premiumMember = true;
    }

    public void setLogIn(boolean logIn) {
        this.logIn = logIn;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public boolean isLogIn() {
        return logIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
}
