package com.bcdigger.goods.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcdigger.goods.dao.GoodsDao;
import com.bcdigger.goods.entity.Goods;
import com.bcdigger.goods.service.GoodsService;
import com.bcdigger.common.page.PageInfo;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsDao goodsDao;

	@Override
	public Goods getGoods(int id) {

		Goods goods = goodsDao.getById(id);
		return goods;
	}

	public Goods getGoods(Goods goods) {
		try{
			if(goods==null || goods.getGoodsNo()==null || goods.getGoodsNo().equals("")){
				return null;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("goodsNo", goods.getGoodsNo());
			goods = goodsDao.getBy(params);
		}catch(Exception e){
			e.printStackTrace();
		}
		return goods;
	}
	
	@Override
	public PageInfo<Goods> getGoods(Goods goods, PageInfo pageInfo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("goodsNo", goods.getGoodsNo());
		return goodsDao.listPage(pageInfo, params);
	}
	/**
	 * 插入操作商品
	 */
	public int addGoods(Goods goods) {
		return goodsDao.insert(goods);
	}
	
	/**
	 * 更新操作商品信息
	 */
	public int updateGoods(Goods goods) {
		return goodsDao.update(goods);
	}

}
