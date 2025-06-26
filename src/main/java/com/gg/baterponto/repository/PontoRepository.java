public interface PontoRepository extends JpaRepository<Ponto, UUID> {
    List<Ponto> findByUsuarioId(UUID usuarioId);
}
