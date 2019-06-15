package dev.bonjugi.boottemp.videoshop;

import java.util.ArrayList;
import java.util.List;

public class VideoShop {

	List<Video> videos = new ArrayList<>();

	public List<Video> all() {
		return videos;
	}

	public void store(Video video) {
		videos.add(video);
	}
}
