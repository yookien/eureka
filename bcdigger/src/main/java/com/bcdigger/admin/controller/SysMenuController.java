package com.bcdigger.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bcdigger.admin.entity.SysMenu;
import com.bcdigger.admin.service.SysMenuService;
import com.bcdigger.common.page.PageInfo;
import com.bcdigger.core.annotation.AdminAuth;

/**
 * 
 * ClassName: SysMenuController
 * @Description: 菜单管理
 * @author liubei
 * @date 2018年3月25日
 */
@Controller	
//@RestController  //只返回值，不放回页面渲染
@EnableAutoConfiguration
@RequestMapping("/admin")
@AdminAuth  // 菜单管理全部需要登录鉴权
public class SysMenuController {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	/**
	 * @Description: 添加菜单
	 * @param name
	 * @param password
	 * @param vrifycode
	 * @return Map<String,Object>  
	 * @throws
	 * @author liubei
	 * @date 2018年3月25日
	 */
	@RequestMapping(value ="/addMenu",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addSysMenu(@RequestParam String name, String password, String vrifycode){
		Map<String, Object> map = new HashMap<>();  
		try{
			if(name==null || name.trim().equals("")){
				map.put("result", -2);// 用户名不能为空
				return map;
			}
			
			SysMenu sysMenu=new SysMenu();
			sysMenuService.addSysMenu(sysMenu);
			map.put("result", 1);//登录成功
		}catch(Exception e){
			map.put("result", 0);//系统异常
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * @Description: 根据id查询菜单信息
	 * @param id
	 * @return Map<String,Object>  
	 * @throws
	 * @author liubei
	 * @date 2018年3月25日
	 */
	@RequestMapping(value ="/getSysMenu/{id}",method=RequestMethod.GET)
	public Map<String, Object> getSysMenu(@PathVariable int id) {
		Map<String, Object> map = new HashMap<>();  
		try{
			SysMenu sysMenu = sysMenuService.getSysMenuById(id);
			map.put("result", 1);//登录成功
			map.put("sysMenu", sysMenu);
		}catch(Exception e){
			map.put("result", 0);//系统异常
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	/**
	 * @Description: 分页查询菜单信息
	 * @param pageNum
	 * @return Map<String,Object>  
	 * @throws
	 * @author liubei
	 * @date 2018年3月25日
	 */
	@RequestMapping(value ="/getSysMenus",method={RequestMethod.GET,RequestMethod.POST})
	public String getSysMenus(SysMenu sysMenu, Integer pageNum,ModelMap map) {
		try{
			PageInfo pageInfo =new PageInfo();
			//设置每页显示个数
			pageInfo.setPageSize(20);
			//设置显示哪一页
			if(pageNum==null){
				pageNum=1;
			}
			pageInfo.setPageNum(pageNum);
			
			PageInfo<SysMenu> sysMenuPages = sysMenuService.getSysMenus(sysMenu, pageInfo);
			if(sysMenuPages!=null){
				List<SysMenu> menuList=sysMenuPages.getList();
				map.addAttribute("menuList", menuList);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "admin/menu_list";
	}

}
