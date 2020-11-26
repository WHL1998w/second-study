package com.soft1851.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

/**
 * @ClassName
 * @Description 按照性别同意粉丝数统计VO
 * @Author wanghuanle
 * @Date
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FansCountVO {
    private Integer manCounts;
    private Integer womanCounts;
}
