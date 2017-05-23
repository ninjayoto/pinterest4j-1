package pinterest4j.entity;

import org.joda.time.DateTime;
import org.json.JSONObject;
import pinterest4j.util.json.JsonUtil;

import java.io.Serializable;

/**
 * Entity representing Pinterest Pin
 *
 * Created by Aniket Divekar.
 */
public class Pin implements Serializable {

    private static final long serialVersionUID = -3300936372244598773L;
    private String id;
    private User creator;
    private String url;
    private Media media;
    private DateTime createdAt;
    private String originalLink;
    private String note;
    private String color;
    private String link;
    private Board board;
    private String imageUrl;
    private Counts counts;

    public Pin(JSONObject json) {
        this.id = JsonUtil.getString("id", json);
        this.url = JsonUtil.getString("url", json);
        if (!json.isNull("creator")) {
            this.creator = new User(json.getJSONObject("creator"));
        }
        this.createdAt = new DateTime(JsonUtil.getString("created_at", json));
        this.originalLink = JsonUtil.getString("original_link", json);
        this.note = JsonUtil.getString("note", json);
        this.color = JsonUtil.getString("color", json);
        this.link = JsonUtil.getString("link", json);

        if (!json.isNull("board")) {
            this.board = new Board(json.getJSONObject("board"));
        }

        if (!json.isNull("image")) {
            JSONObject image = json.getJSONObject("image");
            if (!image.isNull("original")) {
                image = image.getJSONObject("original");
                this.imageUrl = JsonUtil.getString("url", image);
            }
        }

        if (!json.isNull("counts")) {
            this.counts = new Counts(json.getJSONObject("counts"));
        }

        if(!json.isNull("media")) {
            this.media = new Media(json.getJSONObject("media"));
        }
    }

    public String getId() {
        return id;
    }

    public User getCreator() {
        return creator;
    }

    public String getUrl() {
        return url;
    }

    public Media getMedia() {
        return media;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public String getNote() {
        return note;
    }

    public String getColor() {
        return color;
    }

    public String getLink() {
        return link;
    }

    public Board getBoard() {
        return board;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Counts getCounts() {
        return counts;
    }
}