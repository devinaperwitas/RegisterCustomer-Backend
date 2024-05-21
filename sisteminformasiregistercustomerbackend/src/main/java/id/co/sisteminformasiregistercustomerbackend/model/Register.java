package id.co.sisteminformasiregistercustomerbackend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "reg_msregister")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reg_id;

    private String reg_berkas_nib;
    private String reg_berkas_npwp;
    private String reg_berkas_skt;
    private String reg_berkas_sppkp;
    private String reg_berkas_siup;

    public Register(Long reg_id, String reg_berkas_nib, String reg_berkas_npwp, String reg_berkas_skt, String reg_berkas_sppkp, String reg_berkas_siup) {
        this.reg_id = reg_id;
        this.reg_berkas_nib = reg_berkas_nib;
        this.reg_berkas_npwp = reg_berkas_npwp;
        this.reg_berkas_skt = reg_berkas_skt;
        this.reg_berkas_sppkp = reg_berkas_sppkp;
        this.reg_berkas_siup = reg_berkas_siup;
    }

    public Long getReg_id() {
        return reg_id;
    }

    public void setReg_id(Long reg_id) {
        this.reg_id = reg_id;
    }

    public String getReg_berkas_nib() {
        return reg_berkas_nib;
    }

    public void setReg_berkas_nib(String reg_berkas_nib) {
        this.reg_berkas_nib = reg_berkas_nib;
    }

    public String getReg_berkas_npwp() {
        return reg_berkas_npwp;
    }

    public void setReg_berkas_npwp(String reg_berkas_npwp) {
        this.reg_berkas_npwp = reg_berkas_npwp;
    }

    public String getReg_berkas_skt() {
        return reg_berkas_skt;
    }

    public void setReg_berkas_skt(String reg_berkas_skt) {
        this.reg_berkas_skt = reg_berkas_skt;
    }

    public String getReg_berkas_sppkp() {
        return reg_berkas_sppkp;
    }

    public void setReg_berkas_sppkp(String reg_berkas_sppkp) {
        this.reg_berkas_sppkp = reg_berkas_sppkp;
    }

    public String getReg_berkas_siup() {
        return reg_berkas_siup;
    }

    public void setReg_berkas_siup(String reg_berkas_siup) {
        this.reg_berkas_siup = reg_berkas_siup;
    }
}
