package com.team.mine.service;

import java.util.List;

import com.team.mine.common.ResultInfo;
import com.team.mine.domain.UserAccount;

public interface UserService {

	public Integer insert(UserAccount user);
	
	public Integer delete(Integer id);
	
	public Integer update(UserAccount user);
	
	public UserAccount findById(Integer id);
	
	public UserAccount login(UserAccount user);
	
	public Integer updatePassword(UserAccount user);
	
	public Integer updateTradePass(UserAccount user);
	
	public Integer updateUserInfo(UserAccount user,ResultInfo result);
	
	public Integer updateVipLevel(Integer accountId,Integer level);
	
	public boolean isMobileExists(String mobile);
	
	public UserAccount findByMobile(String mobile) ;
	
	public List<UserAccount> findByParams(UserAccount user);
	
	public List<UserAccount> findByName(String name);
	
	/**
	 * 查询userList信息
	 * 
	 * @param params
	 * @return
	 */
	public List<UserAccount> queryUserList(UserAccount params);
	
	/**
	 * 根据accountId停用user，修改状态为停用
	 * 
	 * @param accountId
	 * @return
	 */
	public Integer disableUserByAccountId(int accountId);
	
	/**
	 * 根据accountId启用user，修改状态为启用
	 * 
	 * @param accountId
	 * @return
	 */
	public Integer enableUserByAccountId(int accountId);
	
	/**
	 * 根据accountId锁定user，修改状态为黑名单
	 * 
	 * @param accountId
	 * @return
	 */
	public Integer lockUserByAccountId(int accountId);
	
	/**
	 * 根据accountId 修改 最大登陆人数
	 * 
	 * @param maxLogin
	 * @param accountId
	 * @return
	 */
	public Integer updateMaxLoginByAccountId(Integer maxLogin, Integer accountId);
	
}
