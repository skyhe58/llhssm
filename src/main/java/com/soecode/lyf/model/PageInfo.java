package com.soecode.lyf.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageInfo {
    //@ApiModelProperty(value = "当前页码")
    private Integer startPage = 1;
    //@ApiModelProperty(value = "每页条数")
    private Integer pageSize = 10;
    // @ApiModelProperty(value = "总记录数")
    private Integer total = 0;
    //@ApiModelProperty(value = "是否分页")
    private boolean pagination = true;

    /**
     * 获得起始记录的下标
     *
     * @return
     */
    public Integer getStartIndex() {
        return (this.startPage - 1) * this.pageSize;
    }

    @Override
    public String toString() {
        return "PageInfo [startPage=" + startPage + ", pageSize=" + pageSize + ", total=" + total + ", pagination=" + pagination + "]";
    }

}
