package some_cool_media_library;

import java.util.HashMap;

//remote სერვისის ინტერფეისი
public interface ThirdPartyYouTubeLib {
    HashMap<String, Video> popularVideos();

    Video getVideo(String videoId);
}