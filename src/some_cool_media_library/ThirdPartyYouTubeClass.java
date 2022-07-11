package some_cool_media_library;

import java.util.HashMap;

/*
ThirdPartyYouTubeClass კლასი ახდენს ThirdPartyYouTubeLib ინტერფეისის რეალიზაციას სადაც განსაზღვრულია მეთოდი getVideo(),
რომელიც უკავშირდება  იუთუბის სერვერს და  მოაქვს პარამეტრად გადაცემული ვიდეო აიდით
 */

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

    @Override
    public HashMap<String, Video> popularVideos() {
        connectToServer("http://www.youtube.com");
        return getRandomVideos();
    }

    @Override
    public Video getVideo(String videoId) {
        connectToServer("http://www.youtube.com/" + videoId);
        return getSomeVideo(videoId);
    }

    // -----------------------------------------------------------------------
    // Fake methods to simulate network activity. They as slow as a real life.

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    //მეთოდი რომელიც ახდემს ქსელის დაყოვნების სიმულაცის
    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    //სერვერთან კავშირი
    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }

    //რენდომ ვიდეოების მოქაჩვა
    private HashMap<String, Video> getRandomVideos() {
        System.out.print("Downloading populars... ");

        experienceNetworkLatency();
        HashMap<String, Video> hmap = new HashMap<String, Video>();
        //put video in hasMap with builder

        //ვიდეოების ინიციალიზაცია builder-ით

        //video with id and title
        hmap.put("dancesvideoo", new Video.Builder()
                .videoBuilderWithId("asdfas3ffasd")
                .videoBuilderWithTitle("inception trailer.mp4").build());

        //video with id,title,category and duration
        hmap.put("dlsdk5jfslaf", new Video.Builder()
                .videoBuilderWithId("dlsdk5jfslaf")
                .videoBuilderWithTitle("F1 sprint highlights")
                .videoBuilderWithCategory("sport")
                .videoBuilderWithDuration(5).build());

        //video with id,title and duration
        hmap.put("3sdfgsd1j333", new Video.Builder()
                .videoBuilderWithId("3sdfgsd1j333")
                .videoBuilderWithTitle("mountain jdm drift")
                .videoBuilderWithDuration(2).build());

        System.out.print("Done!" + "\n");
        return hmap;
    }

    private Video getSomeVideo(String videoId) {
        System.out.print("Downloading video... ");

        experienceNetworkLatency(); //ქსელის დაყოვნება
        Video video = new Video.Builder().videoBuilderWithId(videoId).build();

        System.out.print("Done!" + "\n");
        return video;
    }

}