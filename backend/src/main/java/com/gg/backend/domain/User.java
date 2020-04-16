package com.gg.backend.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @NotNull @NotBlank@NotEmpty
 * @NotBlank通常作用在String类型参数上面。下面注释得意思是，参数即使是空字符串也不行，必须要有值。
 * @NotNull通常作用的是基本类型数据，但是它是可以接收任何类型的(Accepts any type.)
 * @NotEmpty通常情况下作用到Collection，Map，Array数组
 * @Null 被注释的元素必须为 null
 * @NotNull 被注释的元素必须不为 null
 * @AssertTrue 被注释的元素必须为 true
 * @AssertFalse 被注释的元素必须为 false
 * @Min(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @Max(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @DecimalMin(value) 被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * @DecimalMax(value) 被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * @Size(max=, min=)   被注释的元素的大小必须在指定的范围内
 * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * @Past 被注释的元素必须是一个过去的日期
 * @Future 被注释的元素必须是一个将来的日期
 * @Pattern(regex=,flag=) 被注释的元素必须符合指定的正则表达式
 *
 *
 * Hibernate Validator提供的校验注解：
 * @NotBlank(message =)   验证字符串非null，且trim后长度必须大于0
 * @Email 被注释的元素必须是电子邮箱地址
 * @Length(min=,max=) 被注释的字符串的大小必须在指定的范围内
 * @NotEmpty 被注释的字符串的必须非空
 * @Range(min=,max=,message=) 被注释的元素必须在合适的范围内
 *
 * @AssertFalse 校验false
 * @AssertTrue 校验true
 * @DecimalMax(value=,inclusive=) 小于等于value，
 * inclusive=true,是小于等于
 * @DecimalMin(value=,inclusive=) 与上类似
 * @Max(value=) 小于等于value
 * @Min(value=) 大于等于value
 * @NotNull 检查Null
 * @Past 检查日期
 * @Pattern(regex=,flag=) 正则
 * @Size(min=, max=)  字符串，集合，map限制大小
 * @Valid 对po实体类进行校验
 *
 * @author GG
 * @date 2019/1/23 13:39
 */
@Data
@Table(name = "t_user")
public class User {

    @Column(name = "pk_user_id")
    private Integer id;
    @NotBlank(message = "用户名不能为空")
    private String userName;
    @NotBlank(message = "密码不能为空")
    @Size(min=6, max=20,message = "最低6位，最长20位")
    private String userPwd;
    private Date createTime;
    private Integer isDelete;

    public User(){

    }

    public User(String user,String password){
        this.userName = user;
        this.userPwd = password;
    }
}
