package web.test.pojo;

import com.google.common.base.Strings;

import java.util.UUID;


public class BasePojo4String extends BasePojo<String> {
    /**
     * <code>serialVersionUID</code> - {description}.
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String getId() {
        if (Strings.isNullOrEmpty(id)) {
            id = UUID.randomUUID().toString().replaceAll("-", "");
            return id;
        }
        return id;
    }
}
