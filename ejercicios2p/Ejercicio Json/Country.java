package Ejercicios2p.json;

public class Country {
    private String name_en;
    private String name_es;
    private String dial_code;
    private String code;

    public String getName_en() {
        return name_en;
    }
    public void setName_en(String name_en) {
        this.name_en = name_en;
    }
    public String getName_es() {
        return name_es;
    }
    public void setName_es(String name_es) {
        this.name_es = name_es;
    }
    public String getDial_code() {
        return dial_code;
    }
    public void setDial_code(String dial_code) {
        this.dial_code = dial_code;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString() {
        return this.name_es;
    }
}
