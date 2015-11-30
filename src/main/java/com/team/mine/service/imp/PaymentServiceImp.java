//package com.team.mine.service.imp;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.team.mine.bo.PaymentItemBo;
//import com.team.mine.bo.PaymentItemVipBo;
//import com.team.mine.common.PageBean;
//import com.team.mine.dao.PaymentMapper;
//import com.team.mine.domain.Payment;
//import com.team.mine.service.PaymentService;
//@Transactional
//public class PaymentServiceImp extends SqlSessionDaoSupport implements PaymentService {
//	
//
//	public SqlSessionTemplate sqlSession;
//	
//	public SqlSessionTemplate getSqlSession() {
//		return sqlSession;
//	}
//
//	public void setSqlSession(SqlSessionTemplate sqlSession) {
//		this.sqlSession = sqlSession;
//	}
//
//	
//	
//	public Integer insert(Payment pay) {
//		Integer result=0;
//		result=sqlSession.getMapper(PaymentMapper.class).insert(pay);
//		return result;
//	}
//	
//	public Integer updateOrderPay(Payment pay) {
//		Integer result=0;
//		result=sqlSession.getMapper(PaymentMapper.class).updatePayResult(pay);
//		return result;
//	}
//
//	
//	public Payment queryPaymentById(String orderNo) {
//		return sqlSession.getMapper(PaymentMapper.class).queryPaymentById(orderNo);
//	}
//
//	
//	public List<Payment> queryPaymentList(Integer accountId) {
//		accountId=accountId!=null?accountId:0;
//		List<Payment> list = new ArrayList<Payment>();
//		list=sqlSession.getMapper(PaymentMapper.class).queryPaymentList(accountId);
//		return list;
//	}
//	
//	public List<Payment> queryNoPaymentHalfHour(){
//		return sqlSession.getMapper(PaymentMapper.class).queryNoPaymentHalfHour();
//	}
//	
//	public List<PaymentItemBo> queryNoPaymentItemHalfHour(){
//		return sqlSession.getMapper(PaymentMapper.class).queryNoPaymentItemHalfHour();
//	}
//
//	
//	public PaymentItemBo queryPaymentItemBoById(String orderNo) {
//		return sqlSession.getMapper(PaymentMapper.class).queryPaymentItemBoById(orderNo);
//	}
//	
//	
//	public Payment queryPaymentLockForUpdate(String orderNo) {
//		// TODO Auto-generated method stub
//		return sqlSession.getMapper(PaymentMapper.class).queryPaymentById(orderNo);
//	}
// 
//	public PageBean<PaymentItemVipBo> queryPaymentPage(Integer accountId,Integer curr,Integer size) {
//		accountId=accountId!=null?accountId:0;
//		curr=curr!=null?curr:1;
//		size=size!=null?size:10;
//		PageBean<PaymentItemVipBo> page=new PageBean<PaymentItemVipBo>();
//		page.count=sqlSession.getMapper(PaymentMapper.class).countPaymentPage(accountId);
//		page.data=sqlSession.getMapper(PaymentMapper.class).queryPaymentPage(accountId,curr,size);
//		page.currPage=curr;
//		page.pageSize=size;
//		return page;
//	}
//
//}
