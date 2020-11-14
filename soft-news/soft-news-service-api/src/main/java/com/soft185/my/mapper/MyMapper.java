
package com.soft185.my.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * @author wanghuanle
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
