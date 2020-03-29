package jp.co.kin.common.context;

import java.util.Enumeration;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
 * Session情報のComponent
 *
 * @since 1.0.0
 */
@Component
public class SessionComponent {

    public void setValue(HttpSession session, String key, Object value) {
        session.setAttribute(key, value);
    }

    public void removeValue(HttpSession session, String key) {
        session.removeAttribute(key);
    }

    public void removeValues(HttpSession session) {
        Enumeration<String> enm = session.getAttributeNames();
        while (enm.hasMoreElements()) {
            this.removeValue(session, enm.nextElement());
        }
    }

    @SuppressWarnings("unchecked")
    public <T> Optional<T> getValue(HttpSession session, String key, Class<T> clazz) {
        return Optional.ofNullable((T) session.getAttribute(key));
    }

}
