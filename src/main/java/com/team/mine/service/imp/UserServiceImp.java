package com.team.mine.service.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.allinpay.ets.client.StringUtil;
import com.team.mine.common.ResultInfo;
import com.team.mine.dao.UserMapper;
import com.team.mine.domain.UserAccount;
import com.team.mine.service.UserService;

@Transactional
public class UserServiceImp extends SqlSessionDaoSupport implements UserService {
	

	public SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() { 
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	/**
	 * 添加
	 */
	public Integer insert(UserAccount user) {
		Integer result = 0;
		if (null != user) {
			result = sqlSession.insert("insertAccount", user);
		}
		return result;
	}

	/**

	/**
	 * 多个条件查找
	 */
	public List<UserAccount> findByParams(UserAccount user) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<UserAccount> userList = userMapper.findByParams(user);
		return userList;
	}

	/**
	 * 根据昵称查找
	 * 
	 * @param accountName
	 * @return
	 */
	public List<UserAccount> findByName(String nickName) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nick_name", nickName);
		List<UserAccount> userList = sqlSession.selectList("findByName", map);
		return userList;
	}

	/**
	 * 
	 */
	public UserAccount findById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return sqlSession.selectOne("findById", map);
	}

	/**
	 * 
	 */
	public UserAccount findByMobile(String mobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountName", mobile);
		return sqlSession.selectOne("findByAccountName", map);
	}
	
	/**
	 * 判断手机号码是否已注册
	 */
	public boolean isMobileExists(String mobile) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accountName", mobile);
		UserAccount getUser = sqlSession.selectOne("findByAccountName", map);
		return null == getUser || getUser.getAccountId() <= 0 ? false : true;
	}

	/**
	 * 
	 */
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 */
	public Integer update(UserAccount user) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 登录
	 */
	public UserAccount login(UserAccount user) {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		return userMapper.login(user);
	}

	/**

	// /**
	// * 测试
	// * @param args
	// */
	public static void main(String[] args) {
		// List<UserDetailInfoBo> userDetailList=service.getDetailInfoList();
		// for(UserDetailInfoBo detail:userDetailList){
		// if(null!=detail.user){
		// System.out.println(detail.user.accountName+"\t");
		// }
		// if(null!=detail.userEnt){
		// System.out.println(detail.userEnt.email+"\t");
		// }
		// if(null!=detail.userLevel){
		// System.out.println(detail.user.accountName+"\t");
		// }
		// if(null!=detail.userPer){
		// System.out.println(detail.user.accountName+"\t");
		// }
		// if(null!=detail.vipLevel){
		// System.out.println(detail.vipLevel.name+"\t");
		// }
		// }
//		UserAccount user = new UserAccount();
//		user.accountName = "13112345678";
//		user.password = MD5Util.getMD5code("123123");
//		user = service.login(user);
//		System.out.println(user.accountId);
	}

	/**
	 * 修改登录密码
	 */
	public Integer updatePassword(UserAccount user) {
		Integer result= sqlSession.getMapper(UserMapper.class).updatePassword(user);
		return result;
	}

	/**
	 * 修改交易密码
	 */
	public Integer updateTradePass(UserAccount user) {
		Integer result=0;
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		result=userMapper.updateTradePassword(user);
		return result;
	}

	/**
	 * 更新用户基本信息
	 */
	public Integer updateUserInfo(UserAccount user, ResultInfo info) {
		Integer result = 0;
		if (null == user || StringUtils.isEmpty(user.getAccountName().trim())) {
			info.set(-1, "参数异常");
			return result;
		}
		result=sqlSession.update("updateUserInfo", user);
		return result;
	}

	public Integer updateVipLevel(Integer accountId, Integer level) {
		Integer result = 0;
		result=sqlSession.getMapper(UserMapper.class).updateVipLevel(accountId, level);
		return result;
	}
	
	/**
	 * 查询userList信息
	 * 
	 * @param params
	 * @return
	 */
	public List<UserAccount> queryUserList(UserAccount params) {
		
		// 获取userList
		List<UserAccount> userList = sqlSession.selectList("queryUserList", params);
		
		return userList;
	}
	
	/**
	 * 根据accountId停用user，修改状态为停用
	 * 
	 * @param accountId
	 * @return
	 */
	public Integer disableUserByAccountId(int accountId) {
		
		Integer result = 0;
		
		// 判断参数是否异常
		if (StringUtil.isEmpty(Integer.toString(accountId))) {
			result = -1;
			return result;
		}
		
		// 停用adminAccount
		result = sqlSession.getMapper(UserMapper.class).disableUserByAccountId(accountId);
		return result;
	}
	
	/**
	 * 根据accountId启用user，修改状态为启用
	 * 
	 * @param accountId
	 * @return
	 */
	public Integer enableUserByAccountId(int accountId) {
		
		Integer result = 0;
		
		// 判断参数是否异常
		if (StringUtil.isEmpty(Integer.toString(accountId))) {
			result = -1;
			return result;
		}
		
		// 启用adminAccount
		result = sqlSession.getMapper(UserMapper.class).enableUserByAccountId(accountId);
		return result;
	}
	
	/**
	 * 根据accountId锁定user，修改状态为黑名单
	 * 
	 * @param accountId
	 * @return
	 */
	public Integer lockUserByAccountId(int accountId) {
		
		Integer result = 0;
		
		// 判断参数是否异常
		if (StringUtil.isEmpty(Integer.toString(accountId))) {
			result = -1;
			return result;
		}
		
		// 锁定adminAccount
		result = sqlSession.getMapper(UserMapper.class).lockUserByAccountId(accountId);
		return result;
	}
	
	/**
	 * 根据accountId 修改 最大登陆人数
	 * 
	 * @param maxLogin
	 * @param accountId
	 * @return
	 */
	public Integer updateMaxLoginByAccountId(Integer maxLogin, Integer accountId) {
		
		Integer result = 0;
		
		// 判断参数是否异常
		if (StringUtil.isEmpty(Integer.toString(accountId))) {
			result = -1;
			return result;
		}
		
		// 根据accountId 修改 最大登陆人数
		result = sqlSession.getMapper(UserMapper.class).updateMaxLoginByAccountId(maxLogin, accountId);
		return result;
	}
	
}
