import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodedPathVariableResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(DecodedPathVariable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws UnsupportedEncodingException {
        String value = webRequest.getAttribute(parameter.getParameterName(), NativeWebRequest.SCOPE_REQUEST).toString();
        String encoding = "UTF-8"; // ou l'encodage que vous souhaitez utiliser
        return URLDecoder.decode(value, encoding);
    }
}
