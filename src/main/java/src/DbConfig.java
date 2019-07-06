package src;

public enum DbConfig {
    INSTANCE;
    private String url = "jdbc:mysql://remotemysql.com:3306/0gkgDNX2ss";
    private String login = "0gkgDNX2ss";
    private String password = "EVXK5R7bsX";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
