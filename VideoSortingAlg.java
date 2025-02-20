import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

<<<<<<< HEAD
=======
// Video object defined with views and id
>>>>>>> master
class Video{
    int id;
    int views;

<<<<<<< HEAD
=======
    // Constructor
>>>>>>> master
    public Video(int id, int views){
        this.id = id;
        this.views = views;
    }
}

public class VideoSortingAlg {
    
    public List<Video> kMostViewed(List<Video> videos, int k){
<<<<<<< HEAD
        
        PriorityQueue<Video> minHeap = new PriorityQueue<>(k, (Video v1, Video v2) -> Integer.compare(v1.views, v2.views));

=======

        // New priorityQueue created and inistialised with a comparator to sort the video objects by views        
        PriorityQueue<Video> minHeap = new PriorityQueue<>(k, (Video v1, Video v2) -> Integer.compare(v1.views, v2.views));

        // Loop through each video in the list and add if it meets requirements
        // Add if the heap isnt full or if current video has more views then lowest in heap
>>>>>>> master
        for (Video video : videos){
            if (minHeap.size() < k){
                minHeap.offer(video);
                System.out.println("adding: " + video.views);
            } else if (video.views > minHeap.peek().views) {
                System.out.println("Comparing: "+ video.views + " and " + minHeap.peek().views);
                minHeap.poll();
                System.out.println("adding: " + video.views);
                minHeap.offer(video);
            }
        }

<<<<<<< HEAD
=======
        // Get the k most viewed videos from the heap and return in descending order
>>>>>>> master
        List<Video> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }

        Collections.reverse(result);
        return result;
    }

<<<<<<< HEAD
=======
    // Main method that creates a random amount of video objects with a random amount of views, then calls algortihm on the list
>>>>>>> master
    public static void main(String[] args) {
        VideoSortingAlg service = new VideoSortingAlg();
        List<Video> videos = new ArrayList<>();
        Random rand = new Random();

        int numVids = rand.nextInt(50);
        System.out.println("numVids: " + numVids);
        for (int i = 1; i < numVids; i++){
            videos.add(new Video(i, rand.nextInt(1000000)));
        }

        for (Video vid : videos){
            System.out.println("Id: " + vid.id + " Views: " + vid.views);
        }
        
        int k = 3;
        
        List<Video> topKVideos = service.kMostViewed(videos, k);
        
<<<<<<< HEAD
=======
        // Display the most viewed videos
>>>>>>> master
        for (Video video : topKVideos) {
            System.out.println("Video ID: " + video.id + ", Views: " + video.views);
        }
    }
}