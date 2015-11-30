package com.team.mine.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.team.mine.domain.UserAccount;

public interface UserMapper {

	
	
	/**
	 * 多个条件筛选用户信息
	 * @param params
	 * @return
	 */
	public List<UserAccount> findByParams(UserAccount params);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	@Select("select * from user_account where account_name='${accountName}' and password='${password}'")
	@ResultMap("userMap")
	public UserAccount login(UserAccount user);
	
	/**
	 * ID查找
	 * @param id
	 * @return
	 */
	@Select("select * from user_account where account_id= '${id}'")
	@ResultMap("userMap")
	public UserAccount findById(int id);
	
	@Select("select * from user_account where account_name='${accountName}'")
	@ResultMap("userMap")
	public UserAccount existsAccountName(UserAccount user);
	
	/**
	 * 修改登录密码
	 * @param user
	 * @return
	 */
	@Update("update user_account set password='${password}' where account_id='${accountId}'")
	public int updatePassword(UserAccount user);
	
	/**
	 * 修改交易密码
	 * @param user
	 * @return
	 */
	@Update("update user_account set trade_password='${tradePassword}' where account_id='${accountId}'")
	public int updateTradePassword(UserAccount user);
	
	@Update("update user_account set vip_level = '${level}' where account_id='${accountId}' ")
	public int updateVipLevel(@Param("accountId")int accountId,@Param("level")int level);
	
	/**
	 * 根据accountId停用userAccount，状态改为停用
	 * 
	 * @param accountId
	 * @return
	 */
	@Update(" update user_account set status = 'DISABLED' where account_id = '${accountId}' ")
	public Integer disableUserByAccountId(@Param("accountId") int accountId);
	
	/**
	 * 根据accountId启用userAccount，状态改为启用
	 * 
	 * @param accountId
	 * @return
	 */
	@Update(" update user_account set status = 'ENABLED' where account_id = '${accountId}' ")
	public Integer enableUserByAccountId(@Param("accountId") int accountId);
	
	/**
	 * 根据accountId锁定userAccount，状态改为黑名单
	 * 
	 * @param accountId
	 * @return
	 */
	@Update(" update user_account set status = 'BLACKLIST' where account_id = '${accountId}' ")
	public Integer lockUserByAccountId(@Param("accountId") int accountId);
	
	/**
	 * 根据accountId 修改 最大登陆人数
	 * 
	 * @param maxLogin
	 * @param accountId
	 * @return
	 */
	@Update(" update user_account set max_login = '${maxLogin}' where account_id = '${accountId}' ")
	public Integer updateMaxLoginByAccountId(@Param("maxLogin") Integer maxLogin, @Param("accountId") Integer accountId);
	
}
