package com.Generator.dao1;

import com.Generator.bean.McMaterials;
import com.Generator.bean.McMaterialsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface McMaterialsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int countByExample(McMaterialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int deleteByExample(McMaterialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int insert(McMaterials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int insertSelective(McMaterials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    List<McMaterials> selectByExample(McMaterialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    McMaterials selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int updateByExampleSelective(@Param("record") McMaterials record, @Param("example") McMaterialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int updateByExample(@Param("record") McMaterials record, @Param("example") McMaterialsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int updateByPrimaryKeySelective(McMaterials record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mc_materials
     *
     * @mbggenerated Wed Mar 27 09:07:48 CST 2019
     */
    int updateByPrimaryKey(McMaterials record);
}