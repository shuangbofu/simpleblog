package cn.shuangbofu.service.impl;

import cn.shuangbofu.entity.Profile;
import cn.shuangbofu.mapper.ProfileMapper;
import cn.shuangbofu.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ericfu on 2018/4/13.
 */
@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public Profile get() {
        return profileMapper.get();
    }
}
