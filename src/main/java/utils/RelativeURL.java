package utils;


public enum RelativeURL {
    LOG_OUT("account/logout/");

    public String url;

    RelativeURL(String URL) {
        this.url = URL;
    }

    public String get(){
        return url;
    }
}
