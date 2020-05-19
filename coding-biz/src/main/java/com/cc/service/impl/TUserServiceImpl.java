package com.cc.service.impl;

import com.cc.entity.TUser;
import com.cc.mapper.TUserDao;
import com.cc.service.TUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-19 11:13:11
 */
@Service("tUserService")
public class TUserServiceImpl implements TUserService {
    @Resource
    private TUserDao tUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fId 主键
     * @return 实例对象
     */
    @Override
    public TUser queryById(Integer fId) {
        return this.tUserDao.queryById(fId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TUser> queryAllByLimit(int offset, int limit) {
        return this.tUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser insert(TUser tUser) {
        this.tUserDao.insert(tUser);
        return tUser;
    }

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @Override
    public TUser update(TUser tUser) {
        this.tUserDao.update(tUser);
        return this.queryById(tUser.getFId());
    }

    /**
     * 通过主键删除数据
     *
     * @param fId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer fId) {
        return this.tUserDao.deleteById(fId) > 0;
    }
}