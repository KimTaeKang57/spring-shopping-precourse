package shopping;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.module.ResolutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Configuration
public class ProductValidator {
    public void isOverLimitLength(String name) {
        // 상품은 최대 15자를 넘는 이름을 가져 서는 안된다.
        if (name.length() >= 15) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "상품의 이름은 15자를 넘길 수 없습니다.");
        }

        // 상품은 일부 특수문자는 허용하지 않는다.
        // 허용하지 않는 특수문자 '(' , ')' , '*'
        /**
         * ^[^()*]+$: 이 정규표현식은 (, ), *를 제외한 모든 문자를 허용합니다.
         * ^: 문자열의 시작.
         * [^()*]: (, ), *를 제외한 모든 문자를 허용합니다. 대괄호 [] 안에 있는 문자들 중에서 부정(^) 기호가 추가된 부분은 해당 문자들을 제외한다는 의미입니다.
         * +: 하나 이상의 허용된 문자가 있어야 함.
         * $: 문자열의 끝.
         */
        String regex = "^[^()*]+$";

        // 패턴 생성
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(name);
        if (!matcher.matches()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "상품명에 허용되지 않는 특수 문자가 포함되어 있습니다.");
        }

        // 상품은 비속어를 포함하지 않는다. > 외부 API

    }
}
