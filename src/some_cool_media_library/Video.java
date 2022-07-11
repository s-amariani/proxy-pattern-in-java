package some_cool_media_library;

//ვიდეოს კლასი რომელიღ აღწერს ვიდეოს ფაილურ სტრუქტურას
public class Video {
    public String id;
    public String title;
    public String data;
    public double duration;
    public String category;

    //Builder-ის გამოყენების მაგალითი
    public static class Builder{
        private Video  newVideo;

        public Builder(){
            newVideo = new Video();
        }
        public Builder videoBuilderWithId(String id){
            newVideo.id = id;
            newVideo.data = "Random video with id";
            return this;
        }
        public Builder videoBuilderWithTitle(String title){
            newVideo.title = title;
            newVideo.data = "Random video with title";
            return this;
        }
        public Builder videoBuilderWithDuration (double durationInsMinutes) {
            newVideo.data = "Random video with duration";
            newVideo.duration = durationInsMinutes;
            return  this;
        }
        public Builder videoBuilderWithCategory(String category) {
            newVideo.data = "Random video with category";
            newVideo.category = category;
            return this;
        }
        public Video build(){
            return newVideo;
        }

    }

}