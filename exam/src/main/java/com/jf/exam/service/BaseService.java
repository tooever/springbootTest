package com.jf.exam.service;

import com.github.pagehelper.PageInfo;
import com.jf.exam.utils.BaseExample;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseService<T> {
    int deleteByPrimaryKey(Example example);


    int delete(T o);


    int insert(T o);


    int insertSelective(T o);


    List<T> selectAll();


    T selectByPrimaryKey(Long example);


    public int selectCount(T o);


    public List<T> select(T o);


    public T selectOne(T o);


    public int updateByPrimaryKey(T o);


    public int updateByPrimaryKeySelective(T o);


    public int deleteByExample(Example example);


    public List<T> selectByExample(Example example);


    public int selectCountByExample(Example example);


    public T selectOneByExample(Example example);


    public int updateByExample(T o, Example example);


    public int updateByExampleSelective(T o, Example example);


    public List<T> selectByExampleAndRowBounds(Example example, RowBounds rowBounds);


    public List<T> selectByRowBounds(T o, RowBounds rowBounds);

    boolean existsWithPrimaryKey(Example example);

    public PageInfo<T> selectPageInfo(BaseExample example);
}
