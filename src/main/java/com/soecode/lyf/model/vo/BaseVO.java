package com.soecode.lyf.model.vo;

import com.soecode.lyf.model.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseVO implements Serializable {

    private static final long serialVersionUID = -5996562225527918196L;
    /**
     * 分页信息
     */
    private PageInfo pageInfo;
    /**
     * 是否删除
     */
    private Integer deleted;

    /**
     * 创建人id
     */
    private Long createUserId;

    /**
     * 创建人用户名
     */
    private String createUsername;

    /**
     * 更新人id
     */
    private Long updateUserId;

    /**
     * 更新人用户名
     */
    private String updateUsername;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建数据库时间戳
     */
    private LocalDateTime createTimeDb;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新数据库时间戳
     */
    private LocalDateTime updateTimeDb;

    /**
     * 公司id
     */
    private Long companyId;


}
