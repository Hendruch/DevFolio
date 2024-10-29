package mx.ulsa.hendricklpsw.repository;

import mx.ulsa.hendricklpsw.modelo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
