class Playlist {
    private String[] songs;
    private int count;

    Playlist(int size) {
        songs = new String[size];
        count = 0;
    }

    void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        } else {
            System.out.println("Playlist is full");
        }
    }

    String[] getSongs() {
        String[] copy = new String[count];

        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        // Changing the copy
        copy[0] = "Hacked";

        // Original playlist remains unchanged
        String[] original = p.getSongs();

        System.out.println("First song: " + original[0]);
        System.out.println("Second song: " + original[1]);
        System.out.println("Song count: " + p.getSongCount());
    }
}