package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName
 * @Description 按地区粉丝数统计VO
 * @Author wanghuanle
 * @Date
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegionRatioVO {
    private String name;
    private Integer value;
}
