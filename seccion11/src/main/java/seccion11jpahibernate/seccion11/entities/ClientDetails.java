package seccion11jpahibernate.seccion11.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "clients_details")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class ClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean premium;
    private Integer points;

    @OneToOne
    @JoinColumn(name = "id_cliente")
    private Client client;

    public ClientDetails(boolean premium, int points) {
        this.premium = premium;
        this.points = points;
    }
}
