package seccion9hibernet.seccion9hibernet.dto;

public class PersonDto {
    private String namme;
    private String lastname;

    public PersonDto(String namme, String lastname) {
        this.namme = namme;
        this.lastname = lastname;
    }

    public String getNamme() {
        return namme;
    }
    public void setNamme(String namme) {
        this.namme = namme;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "PersonDto [namme=" + namme + ", lastname=" + lastname + "]";
    }

    

    
}
