package model;//5/27/2021//
import javafx.beans.property.SimpleStringProperty;
//Niko Silabest//
//IntelliJ IDEA//
public class modelDatabase {
    public final SimpleStringProperty nim;
    public final SimpleStringProperty nama;
    public final SimpleStringProperty jurusan;
    public final SimpleStringProperty alamat;
    public final SimpleStringProperty waktu;

    public String getWaktu() {
        return waktu.get();
    }


    public void setWaktu(String waktu) {
        this.waktu.set(waktu);
    }

    public modelDatabase(String fnim, String fnama, String fjurusan, String falamat, String fwaktu){
        this.nim = new SimpleStringProperty(fnim);
        this.nama = new SimpleStringProperty(fnama);
        this.jurusan = new SimpleStringProperty(fjurusan);
        this.alamat = new SimpleStringProperty(falamat);
        this.waktu = new SimpleStringProperty(fwaktu);
    }

    public String getNim() {
        return nim.get();
    }

    public void setNim(String value) {
        nim.set(value);
    }


    public String getNama() {
        return nama.get();
    }

    public void setNama(String value) {
        nama.set(value);
    }


    public String getJurusan() {
        return jurusan.get();
    }

    public void setJurusan(String value) {
        jurusan.set(value);
    }


    public String getAlamat() {
        return alamat.get();
    }

    public void setAlamat(String value) {
        alamat.set(value);
    }
}
