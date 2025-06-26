public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Usuario findByEmailAndSenha(String email, String senha);
}
