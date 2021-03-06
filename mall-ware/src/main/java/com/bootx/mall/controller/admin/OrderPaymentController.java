
package com.bootx.mall.controller.admin;

import javax.inject.Inject;

import com.bootx.mall.common.Pageable;
import com.bootx.mall.common.Results;
import com.bootx.mall.service.OrderPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller - 订单支付
 * 
 * @author BOOTX Team
 * @version 6.1
 */
@Controller("adminOrderPaymentController")
@RequestMapping("/admin/order_payment")
public class OrderPaymentController extends BaseController {

	@Inject
	private OrderPaymentService orderPaymentService;

	/**
	 * 查看
	 */
	@GetMapping("/view")
	public String view(Long id, ModelMap model) {
		model.addAttribute("orderPayment", orderPaymentService.find(id));
		return "admin/order_payment/view";
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(Pageable pageable, ModelMap model) {
		model.addAttribute("page", orderPaymentService.findPage(pageable));
		return "admin/order_payment/list";
	}

	/**
	 * 删除
	 */
	@PostMapping("/delete")
	public ResponseEntity<?> delete(Long[] ids) {
		orderPaymentService.delete(ids);
		return Results.OK;
	}

}