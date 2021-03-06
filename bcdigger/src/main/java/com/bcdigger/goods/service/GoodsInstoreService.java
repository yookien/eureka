package com.bcdigger.goods.service;

import java.util.List;

import com.bcdigger.common.page.PageInfo;
import com.bcdigger.goods.entity.GoodsInstore;
import com.bcdigger.goods.entity.GoodsInstoreBiz;

public interface GoodsInstoreService {

	public GoodsInstore getGoodsInstore(int id);

	public GoodsInstore getGoodsInstore(GoodsInstore goodsInstore);

	public PageInfo<GoodsInstore> getGoodsInstore(GoodsInstore goodsInstore, PageInfo pageInfo);

	public int addGoodsInstore(GoodsInstore goodsInstore);

	public int updateGoodsInstore(GoodsInstore goodsInstore);
	
	/**
	 * 获取收货审核列表(分页)
	 * @Title: getGoodsInstoreBizs   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param goodsInstoreBiz
	 * @param: @return      
	 * @return: PageInfo<GoodsInstoreBiz>      
	 * @throws
	 */
	public PageInfo<GoodsInstoreBiz> getGoodsInstoreBizs(GoodsInstoreBiz goodsInstoreBiz, PageInfo pageInfo);
	
	/**
	 * 根据订货单id查找需审核的收货信息
	 * @Title: getGoodsInstoreBizs   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param goodsInstoreBiz
	 * @param: @return      
	 * @return: List<GoodsInstoreBiz>      
	 * @throws
	 */
	public List<GoodsInstoreBiz> getGoodsInstoreInfo(GoodsInstoreBiz goodsInstoreBiz);
	/**
	 * 根据订货单id查找需添加的收货信息
	 * @Title: getGoodsInstoreBizs   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param goodsInstoreBiz
	 * @param: @return      
	 * @return: List<GoodsInstoreBiz>      
	 * @throws
	 */
	public List<GoodsInstoreBiz> getAddGoodsInstoreInfo(GoodsInstoreBiz goodsInstoreBiz);
	
	/**
	 * 获取待关闭收货单列表(分页)
	 * @Title: getCloseOrders   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param goodsInstoreBiz
	 * @param: @return      
	 * @return: PageInfo<GoodsInstoreBiz>      
	 * @throws
	 */
	public PageInfo<GoodsInstoreBiz> getCloseOrders(GoodsInstoreBiz goodsInstoreBiz, PageInfo pageInfo);
	
	/**
	 * 根据订货单id查找需关闭的收货单详细信息
	 * @Title: getGoodsInstoreBizs   
	 * @Description: TODO(这里用一句话描述这个方法的作用)   
	 * @param: @param goodsInstoreBiz
	 * @param: @return      
	 * @return: List<GoodsInstoreBiz>      
	 * @throws
	 */
	public List<GoodsInstoreBiz> getCloseOrderInfo(GoodsInstoreBiz goodsInstoreBiz);

}
