
package com.bootx.mall.template.directive;

import com.bootx.mall.entity.CategoryApplication;
import com.bootx.mall.service.CategoryApplicationService;
import com.bootx.mall.util.FreeMarkerUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * 模板指令 - 经营分类申请数量
 * 
 * @author BOOTX Team
 * @version 6.1
 */
@Component
public class CategoryApplicationCountDirective extends BaseDirective {

	/**
	 * "状态"参数名称
	 */
	private static final String STATUS_PARAMETER_NAME = "status";

	/**
	 * "店铺ID"参数名称
	 */
	private static final String STORE_ID_PARAMETER_NAME = "storeId";

	/**
	 * "商品分类ID"参数名称
	 */
	private static final String PRODUCT_CATEGORY_PARAMETER_NAME = "productCategoryId";

	/**
	 * 变量名称
	 */
	private static final String VARIABLE_NAME = "count";

	@Resource
	private CategoryApplicationService categoryApplicationService;
	public static CategoryApplicationCountDirective categoryApplicationCountDirective;

	@PostConstruct
	public void init() {
		categoryApplicationCountDirective = this;
		categoryApplicationCountDirective.categoryApplicationService = this.categoryApplicationService;
	}
	/**
	 * 执行
	 * 
	 * @param env
	 *            环境变量
	 * @param params
	 *            参数
	 * @param loopVars
	 *            循环变量
	 * @param body
	 *            模板内容
	 */
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		CategoryApplication.Status status = FreeMarkerUtils.getParameter(STATUS_PARAMETER_NAME, CategoryApplication.Status.class, params);
		Long storeId = FreeMarkerUtils.getParameter(STORE_ID_PARAMETER_NAME, Long.class, params);
		Long productCategoryId = FreeMarkerUtils.getParameter(PRODUCT_CATEGORY_PARAMETER_NAME, Long.class, params);

		Long count = categoryApplicationService.count(status, storeId, productCategoryId);
		setLocalVariable(VARIABLE_NAME, count, env, body);
	}

}