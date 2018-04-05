package pattern.adapter;

public class Video {

    private VideoType videoType;
    private String name;

    public Video(VideoType videoType, String name) {
        this.videoType = videoType;
        this.name = name;
    }

    public VideoType getVideoType() {
        return videoType;
    }

    public void setVideoType(VideoType videoType) {
        this.videoType = videoType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
