package refactor.code.playground.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.util.Optional;


/*
 * 基本仓库
 * */

@NoRepositoryBean
public interface BaseRepository<T, ID> extends Repository<T, ID> {

    Optional<T> findById(ID id);

    /**
     * 既可以用于保存，也可以修改(根据id相同修改)
     */
    <S extends T> S save(S entity);

    <S extends T> void delete(S entity);

    <S extends T> void deleteById(Long id);

    Page<T> findAll(Pageable pageable);

}
