package pattern.adapter;

/**
 * 仅支持AVI格式的电影播放器
 */
public class AviVideoPlayer {

    public void play(Video video) {
        if (video.getVideoType() == VideoType.AVI) {
            System.out.println("正在播放：" + video.getName());
        } else {
            System.out.println("不支持的视频格式");
        }
    }
}
