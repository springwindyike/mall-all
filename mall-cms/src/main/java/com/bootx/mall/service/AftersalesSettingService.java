
package com.bootx.mall.service;

import com.bootx.mall.entity.AftersalesSetting;
import com.bootx.mall.entity.Store;

/**
 * Service - 售后设置
 * 
 * @author BOOTX Team
 * @version 6.1
 */
public interface AftersalesSettingService extends BaseService<AftersalesSetting, Long> {

	/**
	 * 通过店铺查找售后设置
	 * 
	 * @param store
	 *            店铺
	 * @return 售后设置
	 */
	AftersalesSetting findByStore(Store store);

}