
package com.soft1851.my.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * @author mqxu
 */
@Repository
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
