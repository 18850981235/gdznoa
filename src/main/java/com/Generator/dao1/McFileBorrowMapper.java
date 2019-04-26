package com.Generator.dao1;

import com.Generator.bean.McFileBorrow;
import com.Generator.bean.McFileBorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface McFileBorrowMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int countByExample(McFileBorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int deleteByExample(McFileBorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int insert(McFileBorrow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int insertSelective(McFileBorrow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    List<McFileBorrow> selectByExample(McFileBorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    McFileBorrow selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int updateByExampleSelective(@Param("record") McFileBorrow record, @Param("example") McFileBorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int updateByExample(@Param("record") McFileBorrow record, @Param("example") McFileBorrowExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int updateByPrimaryKeySelective(McFileBorrow record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_file_borrow
     *
     * @mbggenerated Fri Mar 22 08:57:12 CST 2019
     */
    int updateByPrimaryKey(McFileBorrow record);
}