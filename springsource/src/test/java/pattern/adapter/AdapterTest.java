package pattern.adapter;

import org.junit.Test;

public class AdapterTest {

    @Test
    public void testAdapter() {
        Video video = new Video(VideoType.MP4, "加勒比海盗");
        AviVideoPlayer aviVideoPlayer = new AviVideoPlayer();
        aviVideoPlayer.play(video);
        System.out.println("---------");
        FormatFactoryApp formatFactoryApp = new FormatFactoryApp();
        video = formatFactoryApp.transform(video, VideoType.AVI);
        aviVideoPlayer.play(video);
    }
}
