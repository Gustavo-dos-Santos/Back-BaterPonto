@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    private UUID id;

    private String nome;
    private String email;
    private String senha;

    // Getters e Setters
}
