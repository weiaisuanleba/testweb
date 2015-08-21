package web.test.pojo;

import java.util.Date;

/**
 * 表: test_user<br>

 * 用户.
 *
 * @mbggenerated
 */
public class User extends BasePojo4String {
    private static final long serialVersionUID = 1L;

    /**
     * 账号.<br>
     * 列： test_user.t_account
     *
     * @mbggenerated
     */
    private String account;

    /**
     * 密码.<br>
     * 列： test_user.t_password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * 姓名.<br>
     * 列： test_user.t_name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * 员工编号.<br>
     * 列： test_user.t_code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * 是否自定义.<br>
     * 列： test_user.t_is_custom
     *
     * @mbggenerated
     */
    private Boolean isCustom;

    /**
     * 性别, male:男,female:女.<br>
     * 列： test_user.t_sex
     *
     * @mbggenerated
     */
    private String sex;

    /**
     * 所属部门.<br>
     * 列： test_user.t_department_id
     *
     * @mbggenerated
     */
    private Integer departmentId;

    /**
     * 手机.<br>
     * 列： test_user.t_mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * 邮箱.<br>
     * 列： test_user.t_email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * 地址.<br>
     * 列： test_user.t_address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * 描述信息.<br>
     * 列： test_user.t_desc
     *
     * @mbggenerated
     */
    private String desc;

    /**
     * 修改时间.<br>
     * 列： test_user.t_modify_time
     *
     * @mbggenerated
     */
    private Date modifyTime;

    /**
     * json格式扩展信息，如发送媒介，如bqq、微信号、qq号等.<br>
     * 列： test_user.t_extend
     *
     * @mbggenerated
     */
    private String extend;

    /**
     * 是否激活.<br>
     * 列： test_user.t_is_enabled
     *
     * @mbggenerated
     */
    private Boolean isEnabled;


    /**
     * 账号.<br>
     * 列： test_user.t_account
     *
     * @return the value of test_user.t_account
     *
     * @mbggenerated
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号.<br>
     * 列： test_user.t_account
     *
     * @param account the value for test_user.t_account
     *
     * @mbggenerated
     */
    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    /**
     * 密码.<br>
     * 列： test_user.t_password
     *
     * @return the value of test_user.t_password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码.<br>
     * 列： test_user.t_password
     *
     * @param password the value for test_user.t_password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 姓名.<br>
     * 列： test_user.t_name
     *
     * @return the value of test_user.t_name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名.<br>
     * 列： test_user.t_name
     *
     * @param name the value for test_user.t_name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 员工编号.<br>
     * 列： test_user.t_code
     *
     * @return the value of test_user.t_code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * 员工编号.<br>
     * 列： test_user.t_code
     *
     * @param code the value for test_user.t_code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 是否自定义.<br>
     * 列： test_user.t_is_custom
     *
     * @return the value of test_user.t_is_custom
     *
     * @mbggenerated
     */
    public Boolean getIsCustom() {
        return isCustom;
    }

    /**
     * 是否自定义.<br>
     * 列： test_user.t_is_custom
     *
     * @param isCustom the value for test_user.t_is_custom
     *
     * @mbggenerated
     */
    public void setIsCustom(Boolean isCustom) {
        this.isCustom = isCustom;
    }

    /**
     * 性别, male:男,female:女.<br>
     * 列： test_user.t_sex
     *
     * @return the value of test_user.t_sex
     *
     * @mbggenerated
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别, male:男,female:女.<br>
     * 列： test_user.t_sex
     *
     * @param sex the value for test_user.t_sex
     *
     * @mbggenerated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 所属部门.<br>
     * 列： test_user.t_department_id
     *
     * @return the value of test_user.t_department_id
     *
     * @mbggenerated
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 所属部门.<br>
     * 列： test_user.t_department_id
     *
     * @param departmentId the value for test_user.t_department_id
     *
     * @mbggenerated
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 手机.<br>
     * 列： test_user.t_mobile
     *
     * @return the value of test_user.t_mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机.<br>
     * 列： test_user.t_mobile
     *
     * @param mobile the value for test_user.t_mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 邮箱.<br>
     * 列： test_user.t_email
     *
     * @return the value of test_user.t_email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱.<br>
     * 列： test_user.t_email
     *
     * @param email the value for test_user.t_email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 地址.<br>
     * 列： test_user.t_address
     *
     * @return the value of test_user.t_address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址.<br>
     * 列： test_user.t_address
     *
     * @param address the value for test_user.t_address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 描述信息.<br>
     * 列： test_user.t_desc
     *
     * @return the value of test_user.t_desc
     *
     * @mbggenerated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 描述信息.<br>
     * 列： test_user.t_desc
     *
     * @param desc the value for test_user.t_desc
     *
     * @mbggenerated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * 修改时间.<br>
     * 列： test_user.t_modify_time
     *
     * @return the value of test_user.t_modify_time
     *
     * @mbggenerated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 修改时间.<br>
     * 列： test_user.t_modify_time
     *
     * @param modifyTime the value for test_user.t_modify_time
     *
     * @mbggenerated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * json格式扩展信息，如发送媒介，如bqq、微信号、qq号等.<br>
     * 列： test_user.t_extend
     *
     * @return the value of test_user.t_extend
     *
     * @mbggenerated
     */
    public String getExtend() {
        return extend;
    }

    /**
     * json格式扩展信息，如发送媒介，如bqq、微信号、qq号等.<br>
     * 列： test_user.t_extend
     *
     * @param extend the value for test_user.t_extend
     *
     * @mbggenerated
     */
    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    /**
     * 是否激活.<br>
     * 列： test_user.t_is_enabled
     *
     * @return the value of test_user.t_is_enabled
     *
     * @mbggenerated
     */
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * 是否激活.<br>
     * 列： test_user.t_is_enabled
     *
     * @param isEnabled the value for test_user.t_is_enabled
     *
     * @mbggenerated
     */
    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    /**
     * toString for 用户:test_user.
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(getId());
        sb.append(", account=").append(getAccount());
        sb.append(", password=").append(getPassword());
        sb.append(", name=").append(getName());
        sb.append(", code=").append(getCode());
        sb.append(", isCustom=").append(getIsCustom());
        sb.append(", sex=").append(getSex());
        sb.append(", departmentId=").append(getDepartmentId());
        sb.append(", mobile=").append(getMobile());
        sb.append(", email=").append(getEmail());
        sb.append(", address=").append(getAddress());
        sb.append(", desc=").append(getDesc());
        sb.append(", modifyTime=").append(getModifyTime());
        sb.append(", extend=").append(getExtend());
        sb.append(", isEnabled=").append(getIsEnabled());
        sb.append(", json=").append(getJson());
        sb.append(", tag1=").append(getTag1());
        sb.append(", tag2=").append(getTag2());
        sb.append("]");
        return sb.toString();
    }
}