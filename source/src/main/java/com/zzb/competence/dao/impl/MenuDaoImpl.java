package com.zzb.competence.dao.impl;

import com.zzb.competence.dao.BaseDao;
import com.zzb.competence.entity.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by guanzhenxing on 2014-09-10.
 */
@Repository("menuDao")
public interface MenuDaoImpl extends BaseDao<Menu,Long>{

    /**
     * 根据Menu name 和 menu num 查询menu
     * @param menuName menuName
     * @param menuNum menuNum
     * @param pageable pageable
     * @return Page<Menu>
     */
    @Query("select g from Menu g where g.menuName like :menuName and g.menuNum like :menuNum " +
            "or g.menuName is null order by g.createTime desc")
    public Page<Menu> findByMenuNameAndMenuNum(@Param("menuName") String menuName,@Param("menuNum")String menuNum, Pageable pageable);
}
