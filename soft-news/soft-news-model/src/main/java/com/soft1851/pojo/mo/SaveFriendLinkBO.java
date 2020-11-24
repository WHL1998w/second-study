package com.soft1851.pojo.mo;


import com.soft1851.pojo.validate.CheckUrl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author wanghuanle
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveFriendLinkBO {
    private String id;
    @NotBlank(message = "友情链接名不能为空")
    private String linkName;
    @NotBlank(message = "友情链接地址不能为空")
    @CheckUrl
    private String linkUrl;
    @NotNull(message = "请选择保留或者删除")
    private Integer isDelete;

}
