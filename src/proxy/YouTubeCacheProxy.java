package proxy;


import some_cool_media_library.ThirdPartyYouTubeClass;
import some_cool_media_library.ThirdPartyYouTubeLib;
import some_cool_media_library.Video;

import java.util.HashMap;
//პროქსის ქეშირება
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {
    private ThirdPartyYouTubeLib youtubeService;
    private HashMap<String, Video> cachePopular = new HashMap<String, Video>();
    private HashMap<String, Video> cacheAll = new HashMap<String, Video>();

    public YouTubeCacheProxy() {
        this.youtubeService = new ThirdPartyYouTubeClass();
    }

    //მოწმდება არის თუ არა პოპულარული ვიდეო ქეშში,თუ არის აბრუნებს ქეშიდან
    @Override
    public HashMap<String, Video> popularVideos() {
        if (cachePopular.isEmpty()) {
            cachePopular = youtubeService.popularVideos();
        } else {
            System.out.println("Retrieved list from cache.");
        }
        return cachePopular;
    }

    //მოწმდება არის თუ არა მოთხოვნილი ვიდეო ქეშში,თუ არის აბრუნებს ქეშიდან
    @Override
    public Video getVideo(String videoId) {
        Video video = cacheAll.get(videoId);
        if (video == null) {
            video = youtubeService.getVideo(videoId);
            cacheAll.put(videoId, video);
        } else {
            System.out.println("Retrieved video '" + videoId + "' from cache.");
        }
        return video;
    }

    //cachePopular და cacheAll hashMap -ის გასუფთავება
    public void reset() {
        cachePopular.clear();
        cacheAll.clear();
    }
}