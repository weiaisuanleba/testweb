package web.test.pojo;


public class BasePojo4Integer extends BasePojo<Integer> {

    /**
     * <code>serialVersionUID</code> - {description}.
     */
    private static final long serialVersionUID = 1L;

    /**
     * ID. 列： r_test.c_id
     * 
     * @return the value of r_test.c_id
     * 
     * @mbggenerated
     */
    @Override
    public Integer getId() {
        return id;
    }

    /**
     * ID. 列： r_test.c_id
     * 
     * @param id the value for r_test.c_id
     * 
     * @mbggenerated
     */
    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    public void setIdString(final String id) {
        this.id = Integer.parseInt(id);
    }
}
