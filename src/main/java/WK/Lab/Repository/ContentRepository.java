package WK.Lab.Repository;

import WK.Lab.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {

    Content findByContentPortfolio_Pid(Long pid);
}
