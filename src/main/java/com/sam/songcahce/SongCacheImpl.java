package com.sam.songcahce;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SongCacheImpl implements SongCache {
    private ConcurrentHashMap<String, Song> songs = new ConcurrentHashMap<>();


    @Override
    public void recordSongPlays(String songId, int numPlays) {
        if (songs.containsKey(songId)) {
            Song song = songs.get(songId);
            int plays = song.getNumPlays() + numPlays;
            song.setNumPlays(plays);
        } else {
            Song song = new Song();
            song.setSongId(songId);
            song.setNumPlays(numPlays);
            songs.put(songId, song);

        }
    }

    @Override
    public int getPlaysForSong(String songId) {
        if (songs.containsKey(songId)){
            return songs.get(songId).getNumPlays();
        }
        return -1;
    }

    @Override
    public List<String> getTopNSongsPlayed(int n) {
        return songs.values()
                .stream()
                .sorted(Comparator.comparing(Song::getNumPlays).reversed())
                .limit(n)
                .map(Song::getSongId)
                .collect(Collectors.toList());
    }
}
