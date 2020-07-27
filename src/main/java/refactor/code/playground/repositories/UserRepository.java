package refactor.code.playground.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import refactor.code.playground.domain.PlatformUser;

import java.util.List;
import java.util.Optional;


/**
 * 从基本仓库拓展而来的仓库
 */
public interface UserRepository extends BaseRepository<PlatformUser, Long> {
    Optional<PlatformUser> findByTrueName(String trueName);

    List<PlatformUser> findByAgeGreaterThanEqualAndAgeIsLessThanEqual(int age1, int age2);

    /**
     * 可根据查寻条件分页
     */
    Page<PlatformUser> findByTrueNameContaining(String component, Pageable pageable);

    List<PlatformUser> findAll(Sort sort);

    /**
     * 嵌套属性
     */
    PlatformUser findByAddressDetailAddress(String detailAddress);
}
