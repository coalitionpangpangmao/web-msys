package com.ht18.msys.admin.service.impl;

import java.util.Date;
import java.util.List;

import com.ht18.msys.admin.utils.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ht18.msys.admin.core.MybatisPageHelper;
import com.ht18.msys.admin.core.PageRequest;
import com.ht18.msys.admin.core.PageResult;

import com.ht18.msys.admin.model.SysUserToken;
import com.ht18.msys.admin.dao.SysUserTokenMapper;
import com.ht18.msys.admin.service.SysUserTokenService;

/**
 * ---------------------------
 * 用户Token (SysUserTokenServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2019-11-18 15:20:07
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysUserTokenServiceImpl implements SysUserTokenService {

	@Autowired
	private SysUserTokenMapper sysUserTokenMapper;
	private final static int EXPIRE = 3600 * 12;
	@Override
	public int save(SysUserToken record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysUserTokenMapper.add(record);
		}
		return sysUserTokenMapper.update(record);
	}

	@Override
	public int delete(SysUserToken record) {
		return sysUserTokenMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysUserToken> records) {
		for(SysUserToken record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysUserToken findById(Long id) {
		return sysUserTokenMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysUserTokenMapper);
	}
	@Override
	public SysUserToken findByUserId(Long userId) {
		return sysUserTokenMapper.findByUserId(userId);
	}

	@Override
	public SysUserToken findByToken(String token) {
		return sysUserTokenMapper.findByToken(token);
	}
	@Override
	public SysUserToken createToken(long userId) {
		// 生成一个token
		String token = TokenGenerator.generateToken();
		// 当前时间
		Date now = new Date();
		// 过期时间
		Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
		// 判断是否生成过token
		SysUserToken sysUserToken = findById(userId);
		if(sysUserToken == null){
			sysUserToken = new SysUserToken();
			sysUserToken.setUserId(userId);
			sysUserToken.setToken(token);
			sysUserToken.setLastUpdateTime(now);
			sysUserToken.setExpireTime(expireTime);
			// 保存token，这里选择保存到数据库，也可以放到Redis或Session之类可存储的地方
			save(sysUserToken);
		} else{
			sysUserToken.setToken(token);
			sysUserToken.setLastUpdateTime(now);
			sysUserToken.setExpireTime(expireTime);
			// 如果token已经生成，则更新token的过期时间
			save(sysUserToken);
		}
		return sysUserToken;
	}

}
