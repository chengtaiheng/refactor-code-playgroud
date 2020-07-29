package refactor.code.playground.security;

//import com.github.yingzhuo.carnival.nonce.util.NonceUtils;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/no-repeat")
public class NoRepeatController {

    @GetMapping("/nonce-token")
    public String getNoneToken(){
//        val nonceToken = NonceUtils.generate();
//        NonceUtils.save(nonceToken);
//        return  nonceToken.toString();
        return "very good";
    }
}
