@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @PostMapping
    public Usuario criar(@RequestBody Usuario u) {
        return repo.save(u);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario u) {
        return repo.findByEmailAndSenha(u.getEmail(), u.getSenha());
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable UUID id, @RequestBody Usuario atualizado) {
        Usuario usuario = repo.findById(id).orElseThrow();
        usuario.setNome(atualizado.getNome());
        usuario.setEmail(atualizado.getEmail());
        usuario.setSenha(atualizado.getSenha());
        return repo.save(usuario);
    }
}
