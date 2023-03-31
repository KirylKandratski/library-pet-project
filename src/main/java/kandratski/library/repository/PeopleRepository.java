package kandratski.library.repository;

import kandratski.library.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository  extends JpaRepository<Person, Integer> {
}
