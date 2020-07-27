package refactor.code.playground.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import refactor.code.playground.domain.PlatformUser;
import refactor.code.playground.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public PlatformUser findById(@PathVariable("id") Long id) {

        log.info("id =  {}", id);
        return userRepository.findById(id).get();
    }

    @GetMapping("/true_name")
    public PlatformUser findByTrueName(@RequestParam("trueName") String trueName) {

        log.info("trueName = {}", trueName);
        Optional<PlatformUser> byTrueName = userRepository.findByTrueName(trueName);

        if (byTrueName.isPresent()) {
            return byTrueName.get();
        } else {
            return PlatformUser.builder().build();
        }
    }

    @PostMapping("/save")
    public boolean save(@RequestBody PlatformUser platformUser) {

        log.info("up user = {}", platformUser);
        try {
            userRepository.save(platformUser);
        } catch (Throwable throwable) {
            return false;
        }

        return true;
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody PlatformUser platformUser) {
        log.info("up user = {}", platformUser);
        try {
            userRepository.delete(platformUser);
        } catch (Throwable throwable) {
            return false;
        }

        return true;
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        log.info("id = {}", id);

        try {
            userRepository.deleteById(id);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return false;
        }

        return true;
    }


    @GetMapping("/all")
    public Page<PlatformUser> findAll(@RequestParam(value = "pn", required = false, defaultValue = "0") int pn,
                                      @RequestParam(value = "ps", required = false, defaultValue = "10") int ps) {
        log.info("pn = {}", pn);
        log.info("ps = {}", ps);
        Page<PlatformUser> all = userRepository.findAll(PageRequest.of(pn, ps));
        return all;
    }

    @GetMapping("/age-between")
    public List<PlatformUser> findAgeBetween(@RequestParam("ageFirst") int ageFirst, @RequestParam("ageSecond") int ageSecond) {
        log.info("ageFirst = {}", ageFirst);
        log.info("ageSecond = {}", ageSecond);

        return userRepository.findByAgeGreaterThanEqualAndAgeIsLessThanEqual(ageFirst, ageSecond);
    }

    @GetMapping("/true_name_contain")
    public Page<PlatformUser> findTrueNameContains(@RequestParam("component") String component) {
        log.info("component = {}", component);

        return userRepository.findByTrueNameContaining(component, PageRequest.of(0, 3));
    }

    @GetMapping("/all-sort")
    public List<PlatformUser> findAllSort() {
        return userRepository.findAll(Sort.by("id").descending());
    }

    @GetMapping("/detail-address")
    public PlatformUser findByDetailAddress(@RequestParam("detailAddress") String detailAddress) {
        log.info("detailAddress = {}", detailAddress);
        return userRepository.findByAddressDetailAddress(detailAddress);
    }
}
