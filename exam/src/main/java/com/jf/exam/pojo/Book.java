package com.jf.exam.pojo;

import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Data                       //这是lombok,有它可以省去get set等代码
@Table(name = "t_book")
public class Book {
    @Id                         //需要指定主键
    private Integer id;
    private String name;
    private String title;
    private String publishtime;
}
