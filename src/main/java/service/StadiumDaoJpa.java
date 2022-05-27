package service;

import domain.Stadium;
import domain.Wedstrijd;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository("stadiumDaoJpa")
public class StadiumDaoJpa extends GenericDaoJpa<Stadium> implements StadiumDao{

    public StadiumDaoJpa() {
        super(Stadium.class);
    }


}
