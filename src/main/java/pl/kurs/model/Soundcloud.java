package pl.kurs.model;

public class Soundcloud {
    private double version;
    private String type;
    private String provider_name;
    private String provider_url;
    private int height;
    private String width;
    private String title;
    private String description;
    private String thumbnail_url;
    private String html;
    private String author_name;
    private String author_url;

    public Soundcloud() {
    }

    public double getVersion() {
        return version;
    }

    public String getType() {
        return type;
    }


    public String getProvider_name() {
        return provider_name;
    }

    public String getProvider_url() {
        return provider_url;
    }

    public int getHeight() {
        return height;
    }

    public String getWidth() {
        return width;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getHtml() {
        return html;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_url() {
        return author_url;
    }

    @Override
    public String toString() {
        return "Soundcloud{" +
                "version=" + version +
                ", type='" + type + '\'' +
                ", provider_name='" + provider_name + '\'' +
                ", provider_url='" + provider_url + '\'' +
                ", height=" + height +
                ", width='" + width + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail_url='" + thumbnail_url + '\'' +
                ", html='" + html + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_url='" + author_url + '\'' +
                '}';
    }
}
