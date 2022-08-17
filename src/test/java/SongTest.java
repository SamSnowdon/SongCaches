import com.sam.songcahce.SongCache;
import com.sam.songcahce.SongCacheImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SongTest {
    @Test
    public void cacheIsWorking() {
        SongCache cache = new SongCacheImpl();
        cache.recordSongPlays("ID-1", 3);
        cache.recordSongPlays("ID-1", 1);
        cache.recordSongPlays("ID-2", 2);
        cache.recordSongPlays("ID-3", 5);

        List<String> topTwoSongs = cache.getTopNSongsPlayed(2);
        List<String> emptySongs = cache.getTopNSongsPlayed(0);

        assertEquals (cache.getPlaysForSong("ID-1"), 4);
        assertEquals (cache.getPlaysForSong("ID-9"), -1);

        assert  topTwoSongs.contains("ID-3");
        assert  topTwoSongs.contains("ID-1");
        assert  topTwoSongs.size() == 2;

        assert  emptySongs.isEmpty();
    }
}
