package gabebuzato.SoundWave.Musicas;

public enum generos {

    HIPHOP("Hip-Hop"),
    SERTANEJO("Sertanejo"),
    ROCK("Rock"),
    POP("Pop"),
    COUNTRY("Country"),
    AFROBEATS("Afrobeats"),
    ELETRONICA("Eletrônica"),
    KPOP("K-Pop"),
    TRAP("Trap"),
    PHONK("Phonk"),
    FUNK("Funk"),
    RAP("Rap"),
    RB("R&B"),
    REGGAE("Reggae"),
    JAZZ("Jazz"),
    SOUL("Soul"),
    BLUES("Blues"),
    DANCE("Dance"),
    DISCO("Disco"),
    INDIE("Indie"),
    METAL("Metal");

    private final String displayName;
    generos(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}