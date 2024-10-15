public class Reservation {
    private int utilisateur_id;
    private int jeux_id;
    private int reservation;

    public int getUtilisateur_id() {
        return utilisateur_id;
    }

    public void setUtilisateur_id(int utilisateur_id) {
        this.utilisateur_id = utilisateur_id;
    }

    public int getJeux_id() {
        return jeux_id;
    }

    public void setJeux_id(int jeux_id) {
        this.jeux_id = jeux_id;
    }

    public int getReservation() {
        return reservation;
    }

    public void setReservation(int reservation) {
        this.reservation = reservation;
    }
}
