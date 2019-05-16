package com.model;

import java.util.Date;

/**
 * user
 * @author 
 */
public class User  {
    /**
     * 用户主键
     */
    private String id;

    /**
     * 角色外键
     */
    private String roleId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 是否有效
     */
    private Boolean enable;

    /**
     * 系统显示名称
     */
    private String name;

    /**
     * EMAIL
     */
    private String email;

    /**
     * 注册时间
     */
    private Date registerTime;

    /**
     * 电话号码
     */
    private String contact;

    private String organizationId;

    /**
     * 版本
     */
    private Integer version;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getEnable() == null ? other.getEnable() == null : this.getEnable().equals(other.getEnable()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getRegisterTime() == null ? other.getRegisterTime() == null : this.getRegisterTime().equals(other.getRegisterTime()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getOrganizationId() == null ? other.getOrganizationId() == null : this.getOrganizationId().equals(other.getOrganizationId()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getEnable() == null) ? 0 : getEnable().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getRegisterTime() == null) ? 0 : getRegisterTime().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getOrganizationId() == null) ? 0 : getOrganizationId().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleId=").append(roleId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", enable=").append(enable);
        sb.append(", name=").append(name);
        sb.append(", email=").append(email);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", contact=").append(contact);
        sb.append(", organizationId=").append(organizationId);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}