Song
  Simple pojo with two data fields, String songID and Integer for number of plays.
  Getters and Setters to retrieve and update the private data fields.

SongCache
  Interface that contains the functions to be implemented and given logic to including recordSongPlays, getPlaysForSong, and getTopNSongsPlayed.

SongCacheImpl
  Implementation of methods from the interface.
  Using concurrentHashMap for concurrency, as all logic must pass through the HashMap, all variable updates must wait for the HashMap to be updated
  recordSongPlays records the number of songs played with a simple if check to determine what needs done.
  getPlaysForSong retrieves the number of plays for a certain song
  getTopNSongsPlayed retrieves a list of songs based on users request. Uses a stream API to change the map into a List of descending order.

Test
  JUnit testing to determine the working functionality of all logic written in Java Classes.
