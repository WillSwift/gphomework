package pattern.adapter;

/**
 * 格式工厂应用
 */
public class FormatFactoryApp {

    public Video transform(Video video, VideoType videoType) {
        video.setVideoType(videoType);
        return video;
    }
}
