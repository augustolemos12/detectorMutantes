package mutantes.entidades;

import jakarta.persistence.*;
import lombok.*;
import mutantes.algoritmo.Matriz;
import org.hibernate.envers.Audited;

import java.io.Serializable;

//Lombok
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//JPA
@Entity
@Table(name = "Personas")
//Envers
@Audited

public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Edad")
    private int edad;
    @Column(name = "Mutante")
    private boolean mutant;
    @Column(name = "ADN")
    private String[] adn;

    //Relación con la clase que realiza la implementación del algoritmo
    @Transient
    private Matriz matriz;

    public boolean isMutant(String[] dna){
        matriz = new Matriz();
        boolean mutante=matriz.analizarADN(dna);

        if(mutante){
            this.mutant=true;
            System.out.println("El individuo "+this.nombre+" "+this.apellido+" es mutante.");
            return true;
        }else{
            this.mutant=false;
            System.out.println("El individuo "+this.nombre+" "+this.apellido+" NO es mutante.");
            return false;
        }
    }
}
