package com.ntuzy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntuzy.domain.Account;
import com.ntuzy.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Resource
	private AccountService accountService;

	@RequestMapping("/input")
	public String input() {
		return "input";
	}

	@RequestMapping("/save")
	public String save(Account account) {
		System.out.println(account.getName() + "--" + account.getMoney());
		accountService.save(account);
		return "success";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Account> list = accountService.findAll();
		model.addAttribute("list",list);
		return "list";
	}
	
	/**
	 * 根据id查询
	 */
	@RequestMapping("/findById")
	public String findById(Integer id,Model model){
		Account acc = accountService.findById(id);
		model.addAttribute("acc", acc);
		return "input";
	}
	
	/**
	 * 删除客户
	 */
	@RequestMapping("/delete")
	public String delete(Integer id){
		accountService.delete(id);
		return "redirect:/account/list";
	}

}
