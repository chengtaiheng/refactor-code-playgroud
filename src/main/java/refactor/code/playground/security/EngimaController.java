package refactor.code.playground.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试@应卓的的engima插件
 */

@Slf4j
@RestController
@RequestMapping("/engima")
public class EngimaController {

    @GetMapping("/test")
    public String testController() {
        log.debug("nihaoa");
        return "Hello World";
    }
}
