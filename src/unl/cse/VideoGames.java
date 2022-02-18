package unl.cse;

import java.util.Comparator;

public class VideoGames {
	public record VideoGame(String game, String publisher, String year, String platform) {
	}

	public static final Comparator<VideoGame> byPublisherName = new Comparator<VideoGame>() {
		@Override
		public int compare(VideoGame a, VideoGame b) {
			return a.publisher.compareTo(b.publisher);
		}
	};

	public static final Comparator<VideoGame> byGameName = new Comparator<VideoGame>() {
		@Override
		public int compare(VideoGame a, VideoGame b) {
			return a.game.compareTo(b.game);
		}
	};

	public static final Comparator<VideoGame> byPlatformName = new Comparator<VideoGame>() {
		@Override
		public int compare(VideoGame a, VideoGame b) {
			return a.platform.compareTo(b.platform);
		}
	};
}
