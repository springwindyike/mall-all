
package com.bootx.mall.product.dao;

import java.util.List;
import java.util.Set;

import com.bootx.mall.product.common.Page;
import com.bootx.mall.product.common.Pageable;
import com.bootx.mall.product.entity.Coupon;
import com.bootx.mall.product.entity.Store;

/**
 * Dao - 优惠券
 * 
 * @author BOOTX Team
 * @version 6.1
 */
public interface CouponDao extends BaseDao<Coupon, Long> {

	/**
	 * 查找优惠券
	 * 
	 * @param store
	 *            店铺
	 * @param isEnabled
	 *            是否启用
	 * @param isExchange
	 *            是否允许积分兑换
	 * @param hasExpired
	 *            是否已过期
	 * @return 优惠券
	 */
	List<Coupon> findList(Store store, Boolean isEnabled, Boolean isExchange, Boolean hasExpired);

	/**
	 * 查找优惠券
	 * 
	 * @param store
	 *            店铺
	 * @param matchs
	 *            匹配优惠券
	 * @return 优惠券
	 */
	List<Coupon> findList(Store store, Set<Coupon> matchs);

	/**
	 * 查找优惠券分页
	 * 
	 * @param isEnabled
	 *            是否启用
	 * @param isExchange
	 *            是否允许积分兑换
	 * @param hasExpired
	 *            是否已过期
	 * @param pageable
	 *            分页信息
	 * @return 优惠券分页
	 */
	Page<Coupon> findPage(Boolean isEnabled, Boolean isExchange, Boolean hasExpired, Pageable pageable);

	/**
	 * 查找优惠券分页
	 * 
	 * @param store
	 *            店铺
	 * @param pageable
	 *            分页信息
	 * @return 优惠券分页
	 */
	Page<Coupon> findPage(Store store, Pageable pageable);

}