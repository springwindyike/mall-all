
package com.bootx.mall.controller.admin;

import javax.inject.Inject;

import com.bootx.mall.common.Results;
import com.bootx.mall.entity.MessageConfig;
import com.bootx.mall.service.MessageConfigService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller - 消息配置
 * 
 * @author BOOTX Team
 * @version 6.1
 */
@Controller("adminMessageConfigController")
@RequestMapping("/admin/message_config")
public class MessageConfigController extends BaseController {

	@Inject
	private MessageConfigService messageConfigService;

	/**
	 * 编辑
	 */
	@GetMapping("/edit")
	public String edit(Long id, ModelMap model) {
		model.addAttribute("messageConfig", messageConfigService.find(id));
		return "admin/message_config/edit";
	}

	/**
	 * 更新
	 */
	@PostMapping("/update")
	public ResponseEntity<?> update(MessageConfig messageConfig) {
		if (!isValid(messageConfig)) {
			return Results.UNPROCESSABLE_ENTITY;
		}
		messageConfigService.update(messageConfig, "type");
		return Results.OK;
	}

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("messageConfigs", messageConfigService.findAll());
		return "admin/message_config/list";
	}

}