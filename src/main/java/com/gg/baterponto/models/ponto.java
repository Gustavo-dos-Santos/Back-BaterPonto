@Entity
@Table(name = "ponto")
public class Ponto {

    @Id
    private UUID id;

    @Column(name = "createdat")
    private LocalDate createdAt;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Getters e Setters
}
