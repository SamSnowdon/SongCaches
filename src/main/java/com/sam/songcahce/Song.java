package com.sam.songcahce;


public class Song {

       private String songId;
       private Integer numPlays = 0;

       public String getSongId() {
              return songId;
       }

       public void setSongId(String songId) {
              this.songId = songId;
       }

       public Integer getNumPlays() {
              return numPlays;
       }

       public void setNumPlays(Integer numPlays) {
              this.numPlays = numPlays;
       }
}
