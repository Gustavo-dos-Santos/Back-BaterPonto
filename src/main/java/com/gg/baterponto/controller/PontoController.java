@RestController
@RequestMapping("/pontos")
public class PontoController {

    @Autowired
    private PontoRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @PostMapping("/{idUsuario}")
    public Ponto baterPonto(@PathVariable UUID idUsuario) {
        Usuario usuario = usuarioRepo.findById(idUsuario).orElseThrow();
        Ponto ponto = new Ponto();
        ponto.setId(UUID.randomUUID());
        ponto.setUsuario(usuario);
        ponto.setCreatedAt(LocalDate.now());
        return repo.save(ponto);
    }

    @GetMapping("/{idUsuario}")
    public List<Ponto> listarPontos(@PathVariable UUID idUsuario) {
        return repo.findByUsuarioId(idUsuario);
    }
    @PutMapping("/{id}")
    public Ponto atualizar(@PathVariable UUID id, @RequestBody Ponto atualizado) {
        Ponto ponto = repo.findById(id).orElseThrow();
        ponto.setCreatedAt(atualizado.getCreatedAt());

        if (atualizado.getUsuario() != null) {
            Usuario usuario = usuarioRepo.findById(atualizado.getUsuario().getId()).orElseThrow();
            ponto.setUsuario(usuario);
        }

        return repo.save(ponto);
    }
}
